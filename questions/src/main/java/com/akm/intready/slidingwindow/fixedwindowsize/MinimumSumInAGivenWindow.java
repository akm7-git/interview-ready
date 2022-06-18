package com.akm.intready.slidingwindow.fixedwindowsize;

import java.util.ArrayList;
import java.util.List;

public class MinimumSumInAGivenWindow {

	public static List<Integer> getMinSubArraySolution(int arr[], int windowSize) {
		int i = 0;
		int j = 0;
		int lno = Integer.MIN_VALUE;
		List<Integer> result = new ArrayList<Integer>();
		while (j < arr.length) {
			if (j - i + 1 <= windowSize) {
				if (arr[j] > lno) {
					lno = arr[j];
				}
			}
			if (j - i + 1 == windowSize) {
				result.add(lno);
				System.out.println("Found a solution for window between i : " + i + " and j :" + j + " is : " + lno);
				i++;
				lno=arr[i];
			}
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, -4, 2, 7, 9, 1, -7, 5, 6, -4 };
		System.out.println(getMinSubArraySolution(arr, 3));
	}

}
