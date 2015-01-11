package com.code2040;

public class StageOne {

	
	/**
	 * Method to reverse a string. Takes in a string, 
	 * and builds a new string using the StringBuilder 
	 * library. 
	 * 
	 * @param original
	 * 		A String
	 * @return newString
	 * 		A String
	 */
	public String stringReverser(String original)
	{
		String newString= new StringBuilder(original).reverse().toString();		
		return newString;
	} // stringReverser(String original)
	
	
	
}
