/**
 * Given an array of integers, find the first missing
 * positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that
 * does not exist in the array. The array can contain duplicates
 * and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2.
 * The input [1, 2, 0] should give 3.
 */
package com.akm.intready.daily_coding_problem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MissingPositiveIntegerStripe {
    public static int get_missing_integer_simple(int arr[])
    {
        //time complexity-nlogn - because of sort
        int ans=1;
        Arrays.sort(arr);
        for(int i=0; i < arr.length; i++)
        {
            if(arr[i] < ans)
                continue;
            if(arr[i] == ans)
                ans ++;
            if(arr[i] > ans)
                break;
        }

        return ans;
    }

    public static int swap_negatives(int arr[])
    {
        int j=0;
        for(int i=0; i < arr.length; i++)
        {
            if (arr[i] <=0 )
            {
                int temp=arr[j];
                arr[j] = arr[i];
                arr[i] =temp;
                j++;
            }
        }
        for(int i=0; i < arr.length; i++)
        {
            System.out.print(" "+arr[i]);
        }
        return j;
    }

    public static int get_missing_integer(int arr[])
    {
        //time complexity-O(n) and O(1)
        int ans=1;
        int size=swap_negatives(arr);
        int[] new_arr=new int[arr.length-size];
        int j=0;
        System.out.println();
        for(int i=size; i < arr.length; i++)
        {
            new_arr[j] = arr[i];
            j++;
        }

        System.out.println();
        for(int i=0; i < new_arr.length; i++) {
            System.out.print(" " + new_arr[i]);
        }
        size=j;
        System.out.println("\nbefore- size"+size);
        for (int i = 0; i < size; i++) {
            int x = Math.abs(new_arr[i]);
            System.out.println("x"+x);
            if (x - 1 < size && new_arr[x - 1] > 0)
            {
                System.out.println("x-1="+new_arr[x - 1]);
                new_arr[x - 1] = -new_arr[x - 1];
            }
        }
        System.out.println("\nfinal");
        for(int i=0; i < new_arr.length; i++) {
            System.out.print(" " + new_arr[i]);
        }
        // Return the first index value at which
        // is positive
        for (int i = 0; i < size; i++)
            if (new_arr[i] > 0)
                return i + 1; // 1 is added because indexes
        // start from 0

        return size + 1;
    }

    public static void main(String args[])
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        //int arr[]={3, 4, -1, 1};
        int arr[]={10, 7, -1, 3, 1,2};
        //int arr[]={1, 2, 0};
        //int arr[]={2, 0, -1, 3};
        //System.out.println("Ans-"+MissingPositiveIntegerStripe.get_missing_integer_simple(arr));

        System.out.println("\n"+dtf.format(now));

        System.out.println("Ans-"+MissingPositiveIntegerStripe.get_missing_integer(arr));

        System.out.println("\n"+dtf.format(now));
    }
}
