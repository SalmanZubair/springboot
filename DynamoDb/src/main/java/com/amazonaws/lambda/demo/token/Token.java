package com.amazonaws.lambda.demo.token;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Token {

	static String url = "https://apiauthsam.auth.us-east-1.amazoncognito.com/oauth2/token";
	static String clientId = "3g0fc1mvosoga8l4hln9gm985n";
	static String clientSecret = "j85hngqvm9ml93o1v5ucffnet3it5kjmp60vdmoem62hl7kpr3v";
	static String auth = clientId + ":" + clientSecret;
	static String authentication = Base64.getEncoder().encodeToString(auth.getBytes());

	String getToken() {

		HttpPost post = new HttpPost(url);
		String token = null;

		post.setHeader("Authorization", "Basic " + authentication);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setHeader("Accept", "application/json");

		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));

		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {

			String res = EntityUtils.toString(response.getEntity());

			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(res);

			token = (String) json.get("access_token");
			
			System.out.println(json.get("access_token"));
		} catch (IOException | ParseException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return token;

	}

}
