package com.code2040;

import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StageThree {

	static PrintWriter pen = new PrintWriter(System.out, true);

	@SuppressWarnings("static-access")
	public static void stageThree(JSONObject token, String URL1, String URL2) throws JSONException, Exception
	{
		JSONObject tempToken = token;
		
		//try{
			JSONObject outputObject = new JSONObject(Connection.connect(URL1, tempToken));
			JSONObject dictionary = outputObject.getJSONObject("result");
			//Get haystack and needle
			String prefix = dictionary.getString("prefix");
			JSONArray array = dictionary.getJSONArray("array");
			
			JSONArray newArray = removePrefix(prefix, array);
			//pen.println();
			tempToken.put("array", newArray);
			Connection.connect(URL2, tempToken);
		//}
		//catch(Exception e)
		//{
		//	Exception failure = new Exception(e);
		//	pen.println(failure.toString());
		//}
	}
	
	/**
	 * Method that compares the prefix of each word with the prefix provided.
	 * 
	 * @param pre
	 *            A String
	 * @param arr
	 *            An array of strings
	 * @return newArray
	 * 			  An array of strings
	 * @throws JSONException 
	 */
	public static JSONArray removePrefix(String pre, JSONArray arr) throws JSONException {
		int location = 0;
		int preLength = pre.length();
		JSONArray newArray = null;
		//int iter=0;
		
		for (location = 0; location < arr.length(); location++) {
			if (pre == arr.getString(location).substring(0, preLength)) {
				newArray.put(arr.getString(location));
				//iter++;
			} // if prefixes are the same
			location++;
		}// for loop
		return newArray;
	} 

}
