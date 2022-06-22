/***
 *
 * This problem was recently asked by Google.
 *
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */

package com.akm.intready.daily_coding_problem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ListOfNosGoogle {
    public static boolean check_nos_simple(int arr[], int nos)
    {
        for(int i=0; i < arr.length-1; i++)
        {
            System.out.println("");
            for(int j=i+1; j < arr.length; j++)
            {
                System.out.print("i-"+i+" j-"+j+",");
                if(nos == arr[i]+arr[j])
                    return true;
            }
        }

        return false;
    }

    public static boolean check_nos_by_sorting(int arr[], int nos)
    {
        Arrays.sort(arr);
        for(int i=0; i < arr.length-1; i++)
        {
            System.out.println("");
            for(int j=i+1; j < arr.length; j++)
            {
                System.out.print(" i-"+i+" j-"+j+",");
                if (nos == arr[i]+arr[j])
                    return true;
                if(nos > arr[i]+arr[j])
                    continue;
                else
                    return false;
            }
        }

        return false;
    }

    public static void main(String args[])
    {
        int arr[]={10, 15, 3, 8,2};
        //int arr[]={22,3,1,4445,2333,55,3,42342,10, 15, 3, 8,2};
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("\nans-"+ListOfNosGoogle.check_nos_simple(arr,17));
        System.out.println(dtf.format(now));
        System.out.println("\nans-"+ListOfNosGoogle.check_nos_by_sorting(arr,17));
        System.out.println(dtf.format(now));
    }
}
