package com.amazonaws.dynamodb;

import org.json.simple.JSONObject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "movies")
public class CatalogItem {

	private Integer yr;
	private String title;
	private JSONObject info;

	@DynamoDBAttribute(attributeName = "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@DynamoDBHashKey(attributeName = "yr")
	public Integer getYr() {
		return yr;
	}

	public void setYr(Integer yr) {
		this.yr = yr;
	}

	@DynamoDBAttribute(attributeName = "info")
	public JSONObject getInfo() {
		return info;
	}

	public void setInfo(JSONObject info) {
		this.info = info;
	}

	
	
}