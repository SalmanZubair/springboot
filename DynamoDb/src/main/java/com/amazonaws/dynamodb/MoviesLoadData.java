package com.amazonaws.dynamodb;

/**
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
*/

import java.io.File;
import java.util.Iterator;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MoviesLoadData {

	public static void main(String[] args) throws Exception {

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		DynamoDB dynamoDb = new DynamoDB(client);

		Table table = dynamoDb.getTable("movies");

		System.out.println(table.describe());

		JsonParser parser = new JsonFactory().createParser(new MoviesLoadData().getFile());

		JsonNode rootNode = new ObjectMapper().readTree(parser);
		Iterator<JsonNode> iter = rootNode.iterator();

		ObjectNode currentNode;

		int i = 0;

		while (iter.hasNext()) {

			currentNode = (ObjectNode) iter.next();

			int year = currentNode.path("year").asInt();
			String title = currentNode.path("title").asText();

			try {
				
				table.putItem(new Item().withPrimaryKey("yr", year, "title", title).withJSON("info",
						currentNode.path("info").toString()));
				System.out.println("PutItem succeeded: " + year + " " + title);
				i++;

			} catch (Exception e) {
				System.err.println("Unable to add movie: " + year + " " + title);
				System.err.println(e.getMessage());
				break;
			}
			if(i>=4000)
				break;
		}
		parser.close();
	}

	File getFile() {
		File file = new File(getClass().getClassLoader().getResource("moviedata.json").getFile());
		System.out.println(file.exists());

		return file;
	}

}
