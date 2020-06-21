/*package com.patiently.postgresql.controller;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiCall {

	public static void main(String[] args) {
		get();
	}

	static void get() {

		String url = "https://localhost:8443/api/v1/employees";

		HttpGet get = new HttpGet(url);
		try {
			get.setHeader("Authorization", "Basic dXNlcjphY2VmOTI4Mi04ZWM1LTQ0ZDktODk3MC0xYTZkZmE1NjA2Yjg=");
			get.setHeader("Accept", "application/json");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(get)) {

			String res = EntityUtils.toString(response.getEntity());

			System.out.println(res);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

}*/