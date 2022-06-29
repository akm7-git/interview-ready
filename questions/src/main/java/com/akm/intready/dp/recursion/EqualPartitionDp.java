package com.akm.intready.dp.recursion;

import java.util.Arrays;

public class EqualPartitionDp {

    /**
     *
     * @param arr
     * @return
     *
     * For a given array , does a solution exists, where it can be divided into 2 equal partitions
     *
     * e.g.  {2,3,1,6 } -> {2,3,1} and {6}
     */

    public boolean doesASolutionExists(int arr[]) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return new SubsetSum().DoesASolutionExistWithDpMemoization(arr, arr.length - 1, sum / 2);
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 7, 8};
        boolean ans = new EqualPartitionDp().doesASolutionExists(arr);
        System.out.println("Solution exists : " + ans);
    }
}
