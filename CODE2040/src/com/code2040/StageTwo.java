package com.code2040;

public class StageTwo {

	/**
	 * Method to find "needle" within the array "Haystack". Takes the string and
	 * returns the location of that string in the array.
	 * 
	 * @param needle
	 *            A String
	 * @param haystack
	 *            An array of strings
	 * @return location An int
	 */
	public int needleFinder(String needle, String[] haystack) {
		int location = 0;

		for (location = 0; location < haystack.length; location++) {
			if (needle == haystack[location]) {
				return location;
			} // if needle is in haystack
			location++;
		}// for loop
		return location;
	} // stringReverser(String original)

}
