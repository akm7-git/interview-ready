package com.akm.intready.slidingwindow.fixedwindowsize;

import java.util.ArrayList;
import java.util.List;

public class GetFirstNegetiveNoOFWindow {

	public static List<Integer> getFirstNegetiveNoOfSlidingWindow(int[] arr, int windowSize) {

		List<Integer> negs = new ArrayList<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		int j = 0;
		int i = 0;
		int k = arr.length;
		while (j < k) {
			if (j - i + 1 <= windowSize && arr[j] < 0) {
				negs.add(arr[j]);

			}
			if ((j - i) + 1 == windowSize) {
				if (negs.size() > 0) {
					ans.add(negs.get(0));
				} else {
					ans.add(0);
				}
				if (negs.contains(arr[i])) {
					negs.remove(negs.indexOf(arr[i]));
				}
				i++;
			}
			j++;

		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, -5, -2, -8, 2, 4, 7, 0, -8 };
		List<Integer> res = getFirstNegetiveNoOfSlidingWindow(arr, 3);
		System.out.println(res.toString());
	}

}
