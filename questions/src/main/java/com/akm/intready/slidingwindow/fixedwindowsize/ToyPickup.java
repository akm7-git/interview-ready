package com.akm.intready.slidingwindow.fixedwindowsize;

import java.util.HashMap;

public class ToyPickup {

	public static int getMaxToys(char[] toys, int type) {
		int i = 0;
		int j = 0;
		int count = 0;
		int maxCount = Integer.MIN_VALUE;

		HashMap<Character, Integer> chrTracker = new HashMap<Character, Integer>();

		while (j < toys.length) {
			if (chrTracker.containsKey(toys[j])) {
				count++;
				chrTracker.put(toys[j], chrTracker.get(toys[j] + 1));
			} else if (!chrTracker.containsKey(toys[j]) && chrTracker.keySet().size() == type) {
				if (count > maxCount) {
					maxCount = count;
				}
				if (chrTracker.containsKey(toys[i])) {
					int val = chrTracker.get(toys[i]);
					if (val == 1) {
						chrTracker.remove(toys[i]);
					} else {
						chrTracker.put(toys[i], val - 1);
					}
					i++;
					count--;
				}

			}
			if (!chrTracker.containsKey(toys[j]) && chrTracker.keySet().size() < type) {
				chrTracker.put(toys[j], 1);
				count++;
			}

			j++;
		}
		if (count > maxCount)
			maxCount = count;
		return maxCount;
	}

	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'c', 'd', 'a', 'b', 'a' };
		System.out.println(getMaxToys(arr, 3));
	}

}
