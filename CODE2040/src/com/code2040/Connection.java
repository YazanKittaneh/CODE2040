package com.code2040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

/**
 * Json implementation derived from github.com/amusse's code
 * 
 * @author Yazan Kittaneh
 * @cite https://github.com/amusse
 *
 */
public class Connection {


	public static String connect(String url, JSONObject input)
			throws Exception {
		// configures connection
		URL api = new URL(url); //takes in url
		HttpURLConnection connection = (HttpURLConnection) api.openConnection(); //opens connection
		connection.setDoOutput(true); //requirement
		connection.setRequestMethod("POST"); //requirement
		connection.setRequestProperty("Content-Type", "application/json"); //requirement
		// writes to the api
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream());
		input.write(out);
		out.close();
		// gets response from the api and sends it to the other methods in
		// string format
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String response;
		while ((response = reader.readLine()) != null) {
			sb.append(response + "\n");
			 System.out.println("Response: " + response);
		}
		reader.close();
		return sb.toString();
	}

	// method registers user and gives out a JSON token
	public static JSONObject register(String url, String email, String github) throws Exception {
		JSONObject input = new JSONObject();
		input.put("email", email);
		input.put("github", github);
		String response = connect(url, input);
		JSONObject jsonresponse = new JSONObject(response);
		JSONObject token = new JSONObject();
		token.put("token", jsonresponse.getString("result"));
		return token;
	}
	
	// method checks grade
	public static void checkGrade(JSONObject token)
			throws Exception {
		String response = connect("http://challenge.code2040.org/api/status", token);
		System.out.println(response);
	}

}
