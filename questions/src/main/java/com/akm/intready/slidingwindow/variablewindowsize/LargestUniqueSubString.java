package com.akm.intready.slidingwindow.variablewindowsize;

public class LargestUniqueSubString {

	public static String findLargestUniqueSubString(String str) {
		int i = 0;
		int j = 0;
//		List<Character> charUsed = new ArrayList<>();
		String finalStr = "";
		String currentStr = "";
		while (j < str.length()) {
			char c = str.charAt(j);
			if (!currentStr.contains("" + c)) {
				currentStr = currentStr + c;
			}
			else if (currentStr.contains("" + c)) {
				if (currentStr.length() > finalStr.length()) {
					finalStr = currentStr;
					c = str.charAt(i);
					if (currentStr.contains("" + c)) {
						currentStr.replace("" + c, "");
					}
					i++;
				}

			}
			j++;
		}

		return finalStr;
	}

	public static void main(String[] args) {
		String s = "abcabcda";
		System.out.println(findLargestUniqueSubString(s));

	}
}
