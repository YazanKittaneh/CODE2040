package com.code2040;

public class StageThree {

	
	/**
	 * Method that compares the prefix of each word with the prefix provided.
	 * 
	 * @param pre
	 *            A String
	 * @param arr
	 *            An array of strings
	 * @return newArray
	 * 			  An array of strings
	 */
	public String[] needleFinder(String pre, String[] arr) {
		int location = 0;
		int preLength = pre.length();
		String[] newArray={};
		int iter=0;
		
		for (location = 0; location < arr.length; location++) {
			if (pre == arr[location].substring(0, preLength)) {
				newArray[iter]=arr[location];
				iter++;
			} // if prefixes are the same
			location++;
		}// for loop
		return newArray;
	} // stringReverser(String original)

}
