package com.amazonaws.lambda.demo.token;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiCall {

	public static void main(String[] args) {

		get();

//		post();

	}

	static void get() {

		String url = "https://localhost:8443/api/v1/employees";

		HttpGet get = new HttpGet(url);
		try {
			//get.setHeader("Authorizer", new Token().getToken());
			get.setHeader("Authorization", "Basic dXNlcjo0ZTk1MDA2My1lMTVjLTRiNTMtYmE2Mi00N2IzZWIzODQ4NmQ=");
			get.setHeader("Accept", "application/json");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(get)) {

			String res = EntityUtils.toString(response.getEntity());

			/*
			 * JSONParser parser = new JSONParser(); JSONObject json =
			 * (JSONObject) parser.parse(res);
			 */

			System.out.println(res);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

	static void post() {

		String url = "https://xvl517ya98.execute-api.us-east-1.amazonaws.com/dev1";

		HttpPost post = new HttpPost(url);
		try {
			post.setHeader("Authorizer", new Token().getToken());
			post.setHeader("Accept", "application/json");

			/*
			 * StringEntity params = new StringEntity(json.toString());
			 * 
			 * post.setEntity(params);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {

			String res = EntityUtils.toString(response.getEntity());

			/*
			 * JSONParser parser = new JSONParser(); JSONObject json =
			 * (JSONObject) parser.parse(res);
			 */

			System.out.println(res);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
}