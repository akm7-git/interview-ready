package com.akm.intready.slidingwindow.fixedwindowsize;

public class MaximumSumInAGivenWindow {

	public static int getMaxSum(int[] arr, int window) {
		int sum = 0;
		int maxSum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i < window) {
				sum = sum + arr[i];
			} else {
				sum = sum + arr[i] - arr[i - window];
				if (sum > maxSum)
					maxSum = sum;
			}
			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}

	public static int getMaxSum1(int[] arr, int windowSize) {

		int j = 0;
		int i = 0;
		int sum = 0;
		int maxSum = 0;
		int k = arr.length;
		while (j < k) {
			if (j - i + 1 <= windowSize) {
				sum = sum + arr[j];
			}
			if ((j - i) + 1 == windowSize) {
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = sum - arr[i];
				i++;
			}
			j++;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 6, 2, 4, 7, 9, 2, 4, 6, 9, 1, 0 };
		System.out.println(getMaxSum(arr, 3));
		System.out.println(getMaxSum1(arr, 3));

	}

}
