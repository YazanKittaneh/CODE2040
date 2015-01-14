package com.code2040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Connection {

	private static String connect(String url, JSONObject input)
			throws Exception {
		// configures connection
		URL api = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) api.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
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
			// System.out.println(response);
		}
		reader.close();
		return sb.toString();
	}

	// method checks grade
	public static void checkGrade(JSONObject token, String url)
			throws Exception {
		String response = connect(url, token);
		System.out.println(response);
	}

	// method registers user and gives out a JSON token
	public static JSONObject register(String url) throws Exception {
		String email = "amusse@princeton.edu";
		String github = "https://github.com/amusse/Code2040/";
		JSONObject input = new JSONObject();
		String key1 = "email";
		String key2 = "github";
		input.put(key1, email);
		input.put(key2, github);
		String response = connect(url, input);
		JSONObject jsonresponse = new JSONObject(response);
		JSONObject token = new JSONObject();
		token.put("token", jsonresponse.getString("result"));
		return token;
	}
}
