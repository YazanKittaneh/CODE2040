package com.code2040;

import java.io.BufferedReader;
import java.net.URL;

import org.json.simple.JSONObject;

public class Registration {

	public static void main(String[] args) {
		BufferedReader send;
		JSONObject receive;
		// Registering
		String token = register();
		System.out.println("My token is " + token + ".");
		
		receive.put(token, value);
	}

	private static String register() {
		JSONObject dic = new JSONObject();
		dic.put("email", "kittaneh17@grinnell.edu");
		dic.put("github", "https://github.com/YazanKittaneh/CODE2040");
		// HTTP Request
		URL url = new URL("http://challenge.code2040.org/api/register");
		JSONObject data = getDate(dic, url);
		return (String) data.get("result");
	}
}
