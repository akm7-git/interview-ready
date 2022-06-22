package com.akm.intready.array;

public class FindDuplicate {

    public int findDuplicateInNaturalContinuousNumbers(int... nos) {
        int length = nos.length;
        int sum =0;
        if (nos[length - 1] >= nos[length - 2]) {
            System.out.println("Highest no in the array resides in the last index");
            sum = nos[length - 1];
        }
        else {
            sum = nos[length-2];
        }
            sum = (sum *( sum + 1)) / 2; // sum of n natural no : [(n*n+1)/2]
            System.out.println("Total expected sum of natural n no is : " + sum);
            int actual = 0;
            for (int n : nos) {
                actual = actual + n;
            }
           return actual - sum;
        }


    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        //sequence of natural n no with a single duplicate, duplicate no can at any index
        int dup = solution.findDuplicateInNaturalContinuousNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 7, 10);
        System.out.println("Duplicate no is : " + dup);
    }
}
