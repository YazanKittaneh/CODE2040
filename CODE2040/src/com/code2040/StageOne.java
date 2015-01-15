package com.code2040;

import java.io.PrintWriter;

import org.json.JSONObject;

import com.code2040.Connection;

public class StageOne {

	static PrintWriter pen = new PrintWriter(System.out, true);

	/**
	 * stageOne method removes the user from the back-end. Handles all all
	 * connection and catches exceptions if connection is not established.
	 * 
	 * @param token
	 *            A JSONObject containing key "token" and the individual token
	 *            value
	 * @param URL1
	 *            The first URL, for getting the non-reversed string
	 * @param URL2
	 *            The second URL, used to push the reversed string onto
	 */
	public static void stageOne(JSONObject token, String URL1, String URL2)
	{
		JSONObject tempToken = token;
		try{
			JSONObject outputObject = new JSONObject(Connection.connect(URL1, tempToken));
			String regularString = outputObject.getString("result");
			pen.println(regularString);
			String reversedString = stringReverser(regularString);
			pen.println(reversedString);
			tempToken.put("string", reversedString);
			Connection.connect(URL2, tempToken);
		}
		catch(Exception e)
		{
			Exception failure = new Exception(e);
			pen.println(failure.toString());
		}
	}

	/**
	 * Method to reverse a string. Takes in a string, and builds a new string
	 * using the StringBuilder library.
	 * 
	 * @param original
	 *            A String
	 * @return newString A String
	 */
	public static String stringReverser(String original) {
		String newString = new StringBuilder(original).reverse().toString();
		return newString;
	} // stringReverser(String original)
}
