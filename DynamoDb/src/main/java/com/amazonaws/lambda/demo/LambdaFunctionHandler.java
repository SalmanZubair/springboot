package com.amazonaws.lambda.demo;

import org.json.simple.JSONObject;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<JSONObject, String> {

	private DynamoDB dynamoDb;
	private String DYNAMODB_TABLE_NAME = "testdynamo";

	@Override
	public String handleRequest(JSONObject json, Context context) {

		System.out.println(json);
		System.out.println(json.get("data"));
		this.initDynamoDbClient();
		persistData(json);
		return "Saved Successfully!!!";
	}

	private PutItemOutcome persistData(JSONObject json) throws ConditionalCheckFailedException {
		
		Item it = new Item();
		it.withPrimaryKey("Id", json.get("id"))
		.with("firstName", json.get("firstName"))
		.with("lastName", json.get("lastName")).with("data", json.get("data"));
		
		it.with("Test", "arg1");
		
		return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
				.putItem(new PutItemSpec().withItem(it));
	}

	private void initDynamoDbClient() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		this.dynamoDb = new DynamoDB(client);
	}

}