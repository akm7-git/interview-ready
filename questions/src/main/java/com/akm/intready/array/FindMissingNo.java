package com.akm.intready.array;

public class FindMissingNo {

    public int findMissingInNaturalContinuousNumbers(int... nos) {
        int length = nos.length;
        int sum = 0;

        System.out.println("Highest no in the array resides in the last index");
        sum = nos[length - 1];

        sum = (sum * (sum + 1)) / 2; // sum of n natural no : [(n*n+1)/2]
        System.out.println("Total expected sum of natural n no is : " + sum);
        int actual = 0;
        for (int n : nos) {
            actual = actual + n;
        }
        System.out.println("actual sum is : " + actual);
        return sum - actual;
    }


    public static void main(String[] args) {
        FindMissingNo solution = new FindMissingNo();
        //sequence of natural n no with a single no missing, missing no can at any index except last.
        int dup = solution.findMissingInNaturalContinuousNumbers(1, 2, 3, 4, 5, 6, 7, 9, 10);
        System.out.println("Missing no is : " + dup);
    }
}
