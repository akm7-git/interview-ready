package com.akm.intready.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingSmallestPositiveInteger {


    public int findMissingSmallestPositiveInteger(Integer [] nos) {
        int result = 1;
        if (null == nos || nos.length == 0) {
            throw new RuntimeException("input is invalid, please pass an valid range of integers array");
        }
        List<Integer> noList = Arrays.asList(nos);
        int maxNo = Integer.MIN_VALUE;
        int minNo = Integer.MAX_VALUE;
        for (int n : nos) {
            if (n < minNo && n>0) {
                minNo = n;
            }
            if (n > maxNo && n>0) {
                maxNo = n;
            }
        }

        if (minNo > 1) {
            return result;
        }
        for (int i = 2; i < maxNo; i++) {
            if (!noList.contains(i)) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-3,-2, 0, 1 ,2, 3, 5};
        Integer[] arr1 = new Integer[]{-3,-2, 0, 3 ,3, 5};
        MissingSmallestPositiveInteger solution = new MissingSmallestPositiveInteger();
        int res =solution.findMissingSmallestPositiveInteger(arr);
        System.out.println("missing no is : "+ res);

        res =solution.findMissingSmallestPositiveInteger(arr1);
        System.out.println("missing no is : "+ res);
    }
}
