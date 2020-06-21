package com.amazonaws.dynamodb;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

public class DynamoDBMapperCRUDExample {

	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

	public static void main(String[] args) throws IOException {
		testCRUDOperations();
		System.out.println("Example complete!");
	}

	@DynamoDBTable(tableName = "movies")
	public static class Movies {
		private int yr;
		private String title;
		private String info;

		// Partition key
		@DynamoDBRangeKey(attributeName = "yr")
		public int getYr() {
			return yr;
		}

		public void setYr(int yr) {
			this.yr = yr;
		}

		@DynamoDBHashKey(attributeName = "title")
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		@DynamoDBAttribute(attributeName = "info")
		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	private static void testCRUDOperations() {

	/*	Movies item = new Movies();
		item.setYr(2002);
		item.setTitle("Salman");
		*/
		// Save the item (book).
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		//mapper.save(item);
		

		// Retrieve the item.
		Movies itemRetrieved = mapper.load(Movies.class, "Salman");
		System.out.println("Item retrieved:");
		System.out.println(itemRetrieved);


	}
}
