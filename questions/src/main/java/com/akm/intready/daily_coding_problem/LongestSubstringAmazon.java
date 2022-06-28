/**
 * Given an integer k and a string s, find the length of the
 * longest substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest
 * substring with k distinct characters is "bcb".
 */

package com.akm.intready.daily_coding_problem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringAmazon {

    private static String find_longest_substring_simple(String str, int k) {
        int i=0;
        String maxSubstring="";
        while(i < str.length())
        {
            int j=i;
            int count=0;
            String newStr="";
            Set<Character> charSet=new HashSet<>();
            while(j<str.length())
            {
                char c=str.charAt(j);
                if(!charSet.contains(c))
                {
                    count++;
                    charSet.add(c);
                }
                if (count > k)
                {
                    break;
                }
                j++;
                newStr=newStr+c;
            }
            if (newStr.length() > maxSubstring.length())
            {
                maxSubstring=newStr;
            }
            i++;
        }

        return maxSubstring;
    }

    private static String find_longest_substring_similar(String str, int k) {

        String maxSubstring="";
        for(int i=0;i < str.length(); i++)
        {
            int count=0;
            String newStr="";
            Set<Character> charSet=new HashSet<>();
            for(int j=i; j<str.length();j++)
            {
                char c=str.charAt(j);
                if(!charSet.contains(c))
                {
                    count++;
                    charSet.add(c);
                }
                if (count > k)
                {
                    break;
                }
                newStr=newStr+c;
            }
            if (newStr.length() > maxSubstring.length())
            {
                maxSubstring=newStr;
            }
        }

        return maxSubstring;
    }

    final static int MAX_CHARS = 26;

    // This function calculates number
    // of unique characters
    // using a associative array
    // count[]. Returns true if
    // no. of characters are less
    // than required else returns
    // false.
    static boolean isValid(int count[],
                           int k)
    {
        int val = 0;
        for (int i = 0; i < MAX_CHARS; i++)
        {
            if (count[i] > 0)
            {
                val++;
            }
        }

        // Return true if k is greater
        // than or equal to val
        return (k >= val);
    }

    private static String find_longest_substring_by_window(String s, int k) {
        int u = 0;
        int n = s.length();

        // Associative array to store
        // the count of characters
        int count[] = new int[MAX_CHARS];
        Arrays.fill(count, 0);
        // Traverse the string, Fills
        // the associative array
        // count[] and count number
        // of unique characters
        for (int i = 0; i < n; i++)
        {
            if (count[s.charAt(i) - 'a'] == 0)
            {
                u++;
            }
            count[s.charAt(i) - 'a']++;
        }

        // If there are not enough
        // unique characters, show
        // an error message.
        if (u < k) {
            System.out.print("Not enough unique characters");
            return null;
        }

        // Otherwise take a window with
        // first element in it.
        // start and end variables.
        int curr_start = 0, curr_end = 0;

        // Also initialize values for
        // result longest window
        int max_window_size = 1;
        int max_window_start = 0;

        // Initialize associative
        // array count[] with zero
        Arrays.fill(count, 0);

        // put the first character
        count[s.charAt(0) - 'a']++;

        // Start from the second character and add
        // characters in window according to above
        // explanation
        for (int i = 1; i < n; i++) {
            // Add the character 's[i]'
            // to current window
            count[s.charAt(i) - 'a']++;
            curr_end++;

            // If there are more than k
            // unique characters in
            // current window, remove from left side
            while (!isValid(count, k)) {
                count[s.charAt(curr_start) - 'a']--;
                curr_start++;
            }

            // Update the max window size if required
            if (curr_end - curr_start + 1 > max_window_size)
            {
                max_window_size = curr_end - curr_start + 1;
                max_window_start = curr_start;
            }
        }

        System.out.println("Max substring is : "
                                   + s.substring(max_window_start,
                                                 max_window_start + max_window_size)
                                   + " with length " + max_window_size);
        return s.substring(max_window_start,
                           max_window_start + max_window_size);
    }

    public static void main(String[] args) {
        //String str="abcba";
        String str="aabacbebebe";
        int k=3;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("\nans-"+ LongestSubstringAmazon.
                find_longest_substring_simple(str, k));
        System.out.println("\nans-"+ LongestSubstringAmazon.
                find_longest_substring_similar(str, k));
        System.out.println(dtf.format(now));

        System.out.println("\nans-"+ LongestSubstringAmazon.
                find_longest_substring_by_window(str, k));
        System.out.println(dtf.format(now));
    }

}
