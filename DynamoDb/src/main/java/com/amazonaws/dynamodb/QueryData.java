package com.amazonaws.dynamodb;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;

public class QueryData {

	public static void main(String[] args) throws Exception {

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		DynamoDB dynamoDb = new DynamoDB(client);
		DynamoDBMapper mapper = new DynamoDBMapper(client);

		Table table = dynamoDb.getTable("movies");
		

		System.out.println(table);

		QuerySpec spec = new QuerySpec().withKeyConditionExpression("title = :nn and yr >= :year")
				//.withFilterExpression("info.rating >  :rating")
				.withValueMap(
						new ValueMap().withString(":nn", "Salman").withInt(":year", 1999)
						//.withNumber(":rating", 8.1)
						);

		/*
		 * QueryRequest queryRequest = new QueryRequest()
		 * .withTableName("movies")
		 * .withKeyConditionExpression("title = :nn and yr >= :year")
		 * .withIndexName("FactoryIndex")
		 * .withExpressionAttributeNames(expressionAttributesNames)
		 * .withExpressionAttributeValues(expressionAttributeValues);
		 * QueryResult queryResult = amazonDynamoDB.query(queryRequest);
		 * 
		 */

	/*	CatalogItem partitionKey = new CatalogItem();

		partitionKey.setTitle("Rush");
		DynamoDBQueryExpression<CatalogItem> queryExpression = new DynamoDBQueryExpression<CatalogItem>()
				.withHashKeyValues(partitionKey);

		List<CatalogItem> itemList = mapper.query(CatalogItem.class, queryExpression);

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).getTitle());
			System.out.println(itemList.get(i).getInfo().toJSONString());
		}*/
		
		

		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		Item item = null;

		while (iterator.hasNext()) {
			item = iterator.next();
			System.out.println(item.toJSONPretty());
		}

	}

}
