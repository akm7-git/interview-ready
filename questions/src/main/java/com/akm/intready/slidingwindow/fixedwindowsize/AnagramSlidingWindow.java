package com.akm.intready.slidingwindow.fixedwindowsize;

import java.util.HashMap;

public class AnagramSlidingWindow {

	private static HashMap<Character, Integer> getCharCount(String str) {
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (counter.containsKey(c)) {
				counter.put(c, counter.get(c) + 1);
			} else {
				counter.put(c, 1);
			}
		}
		return counter;
	}

	public static int getAnagramCount(String str, String anagram) {
		int i = 0;
		int j = 0;
		HashMap<Character, Integer> charCounter = getCharCount(anagram);
		System.out.println("Initial char counter : " + charCounter);
		int ctr = charCounter.keySet().size();
		int sol = 0;
		while (j < str.length()) {
			if (j - i + 1 <= anagram.length()) {
				char chj = str.charAt(j);
				if (charCounter.containsKey(chj)) {
					int val = charCounter.get(chj) - 1;
					if (val == 0) {
						ctr--;
					}
					charCounter.put(chj, val);
				} else {
					charCounter.put(chj, 1);
				}
			}
			if (j - i + 1 == anagram.length()) {
				if (ctr == 0) {
					System.out.println("Found a solution : " + str.substring(i, j + 1));
					sol++;
				}
				char chi = str.charAt(i);
				if (charCounter.containsKey(chi)) {
					int val = charCounter.get(chi);
					if (val == 0) {
						ctr++;
					}
					charCounter.put(chi, val + 1);
				}
				i++;
			}
			j++;
		}
		return sol;
	}

	public static void main(String[] args) {

		String s = "abacaabaavcgkjacbaa";
		System.out.println(getAnagramCount(s, "aba"));

	}

}
