package com.code2040;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.PrintWriter;


public class StageTwo {
	
	static PrintWriter pen = new PrintWriter(System.out, true);

	@SuppressWarnings("static-access")
	public static void stageTwo(JSONObject token, String URL1, String URL2) throws IOException, Exception
	{
		JSONObject tempToken = token;
		
		//try{
			JSONObject outputObject = new JSONObject(Connection.connect(URL1, tempToken));
			JSONObject dictionary = outputObject.getJSONObject("result");
			//Get haystack and needle
			String needle = dictionary.getString("needle");
			JSONArray haystack = dictionary.getJSONArray("haystack");
			
			int needleIndex = needleFinder(needle,haystack);
			pen.println(needleIndex);
			tempToken.put("needle", 4);
			Connection.connect(URL2, tempToken);
		//}
		//catch(Exception e)
		//{
		//	Exception failure = new Exception(e);
		//	pen.println(failure.toString());
		//}
	}
	
	
	/**
	 * Method to find "needle" within the array "Haystack". Takes the string and
	 * returns the location of that string in the array.
	 * 
	 * @param needle
	 *            A String
	 * @param haystack
	 *            An array of strings
	 * @return location An int
	 * @throws JSONException 
	 */
	public static int needleFinder(String needle, JSONArray haystack) throws JSONException {
		int location = 0;

		for (location = 0; location < haystack.length(); location++) {
			if (needle == haystack.getString(location)) {
				return location;
			} // if needle is in haystack
		}// for loop
		return location;
	} // stringReverser(String original)

}
