/**
 * Given an array of integers, return a new array such that each element
 * at index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */

package com.akm.intready.daily_coding_problem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArrayOfIntegersUber {
    public static int[] get_new_product_array_simple(int arr[])
    {
        //time complexity- n2
        int[] new_arr=new int[arr.length];
        for(int i=0; i < arr.length; i++)
        {
            System.out.println("");
            int product=1;
            for(int j=0; j < arr.length; j++)
            {
                if (i==j)
                    continue;
                System.out.print("i-"+i+" j-"+j+",");
                product *= arr[j];
            }
            new_arr[i]=product;
        }
        System.out.print("\nNew array-");
        for(int j=0; j < new_arr.length; j++)
        {
            System.out.print(" "+new_arr[j]+",");
        }
        return new_arr;
    }

    public static int[] get_new_product_array(int arr[])
    {
        //time complexity- n
        int[] new_arr=new int[arr.length];
        int total_product=1;
        for(int j=0; j < new_arr.length; j++)
        {
            total_product *= arr[j];
        }
        for(int i=0; i < arr.length; i++)
        {
            new_arr[i] = total_product/arr[i];
        }
        System.out.print("\nNew array-");
        for(int j=0; j < new_arr.length; j++)
        {
            System.out.print(" "+new_arr[j]+",");
        }
        return new_arr;
    }

    public static void main(String args[])
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        int arr[]={1, 2, 3, 4, 5};
        //int arr[]={2, 3, 6};
        //int arr[]={3, 2, 1};
        ArrayOfIntegersUber.get_new_product_array_simple(arr);

        System.out.println("\n"+dtf.format(now));

        ArrayOfIntegersUber.get_new_product_array(arr);

        System.out.println("\n"+dtf.format(now));
    }
}
