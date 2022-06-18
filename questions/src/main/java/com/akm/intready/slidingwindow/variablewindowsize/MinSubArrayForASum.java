package com.akm.intready.slidingwindow.variablewindowsize;

public class MinSubArrayForASum {
	
	public static int getMinSubArrayForASum(int arr[], int sum) {
		int i = 0;
		int j = 0;
		int cSum = 0;
		int maxSubArrayLength = Integer.MAX_VALUE;
		while (j < arr.length) {

			int cs = cSum + arr[j];

			if (cs < sum) {
				cSum = cSum + arr[j];
			}

			else {
				if(cs>cSum)
				{
					cSum = cs - arr[i];
					i+=1;
				}
				if (cs == sum) {
					cSum = cs;
					System.out.println(" found a solution for i : " + i + " j : " + j);
					if (j - i + 1 < maxSubArrayLength) {
						maxSubArrayLength = j - i + 1;
					}
				}
				cSum = cs - arr[i];
				i++;
			}
			j++;
		}
		return maxSubArrayLength;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, -4, -5, 3, 7, 4, 2, 2, 1, 0, 1, 2, 1, 5 };
		System.out.println(getMinSubArrayForASum(arr, 9));
	}


}
