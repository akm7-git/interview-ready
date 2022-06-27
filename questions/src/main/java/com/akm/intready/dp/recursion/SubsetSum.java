package com.akm.intready.dp.recursion;

public class SubsetSum {

    /***
     *
     * @param arr
     * @param endIndex
     * @param sum
     * @return
     *
     * Famous DP question, In a given array , check if a solution exists for the given no
     * in an array of {2,3} -> a subset sum of 5 is possible where as a subset sum of 4 is not
     *
     */

    public boolean DoesASolutionExist(int[] arr, int endIndex, int sum) {
        boolean solutionExists = false;
        if (sum == 0) {
            return true;
        }
        if (endIndex >= 0 && arr[endIndex] <= sum) {

            solutionExists = DoesASolutionExist(arr, endIndex - 1, sum - arr[endIndex])
                    || DoesASolutionExist(arr, endIndex - 1, sum);
        } else if (endIndex >= 0 && arr[endIndex] > sum) {
            solutionExists = solutionExists || DoesASolutionExist(arr, endIndex - 1, sum);
        }
        return solutionExists;
    }

    public boolean DoesASolutionExistWithDpMemoization(int[] arr, int endIndex, int sum) {
        char matrix[][] = new char[endIndex + 1][sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            matrix[0][i] = 'f';
        }
        for (int j = 0; j < endIndex + 1; j++) {
            matrix[j][0] = 't';
        }

        for (int i = 1; i < sum + 1; i++) {
            for (int j = 1; j < endIndex + 1; j++) {
                matrix[j][i] = 'n';
            }
        }

        if (matrix[endIndex][sum] == 't') {
            return true;
        } else if (matrix[endIndex][sum] == 'f') {
            return false;
        }
        boolean solutionExists = false;
        if (sum == 0) {
            return true;
        }
        if (endIndex >= 0 && arr[endIndex] <= sum) {

            solutionExists = DoesASolutionExistWithDpMemoization(arr, endIndex - 1, sum - arr[endIndex])
                    || DoesASolutionExistWithDpMemoization(arr, endIndex - 1, sum);
        } else if (endIndex >= 0 && arr[endIndex] > sum) {
            solutionExists = solutionExists || DoesASolutionExistWithDpMemoization(arr, endIndex - 1, sum);
        }
        if (solutionExists) {
            matrix[endIndex][sum] = 't';
        } else {
            matrix[endIndex][sum] = 'f';
        }
        return solutionExists;
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 5, 8, 7};
        boolean solutionExists = new SubsetSum().DoesASolutionExist(arr, 4, 11);
        System.out.println("solution exists : " + solutionExists);

        solutionExists = new SubsetSum().DoesASolutionExistWithDpMemoization(arr, 4, 11);
        System.out.println("solution exists : " + solutionExists);
    }
}
