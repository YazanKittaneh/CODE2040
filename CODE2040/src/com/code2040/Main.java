package com.code2040;

import java.io.PrintWriter;

import org.json.*;

public class Main {
	
	static PrintWriter pen = new PrintWriter(System.out, true);
	

	public static void main(String[] args) throws Exception {
		String registrationURL = "http://challenge.code2040.org/api/register";
		String email = "kittaneh17@grinnell.edu";
		String stageOneURLGrab = "http://challenge.code2040.org/api/getstring";
		String stageOneURLPost = "http://challenge.code2040.org/api/validatestring";
		String stageTwoURLGrab = "http://challenge.code2040.org/api/haystack";
		String stageTwoURLPost = "http://challenge.code2040.org/api/validateneedle";
		String stageThreeURLGrab = "http://challenge.code2040.org/api/prefix";
		String stageThreeURLPost = "http://challenge.code2040.org/api/validateprefix";
		String stageFourURLGrab = "http://challenge.code2040.org/api/time";
		String stageFourURLPost = "http://challenge.code2040.org/api/validatetime";
		JSONObject token;
	
		
		token = Connection.register(registrationURL, email, registrationURL);
		
		StageOne.stageOne(token, stageOneURLGrab, stageOneURLPost);
		StageTwo.stageTwo(token, stageTwoURLGrab, stageTwoURLPost);
		//StageThree.stageThree(token, stageThreeURLGrab, stageThreeURLPost);

		Connection.checkGrade(token);		
	}

}
