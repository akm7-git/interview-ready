/**
 * This problem was asked by Facebook.
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an
 * encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it
 * could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable.
 * For example, '001' is not allowed.
 */

package com.akm.intready.daily_coding_problem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class DecodeMessageFacebook {

    public static int decode_message_simple(char[] digits, int n) {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if (digits[0] == '0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        for (int i = 0; i < count.length; i++) {
            System.out.print(" " + count[i]);
        }
        return count[n];
    }
    public static int decode_message(char[] digits, int n)
    {
        int count[]=new int[n+1];
        count[0]=1;
        count[1]=1;
        if (count[0] == '0')
            return 0;
        for (int i=2; i<=n; i++)
        {
            if(digits[i-1] > '0')
            {
                count[i] = count[i-1];
            }
            if (digits[i-2] == '1' || digits[i-2] =='2'
                    && digits[i-1] < '7')
            {
                count[i]+=count[i-2];
            }
        }
        return count[n];
    }

    public static void main(String args[])
    {

        int msg=111;
        String msgStr=String.valueOf(msg);
        char[] digits = msgStr.toCharArray();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("\nans-"+DecodeMessageFacebook.
                decode_message_simple(digits, digits.length));
        System.out.println("\nans-"+DecodeMessageFacebook.
                decode_message(digits, digits.length));
        System.out.println(dtf.format(now));

    }
}
