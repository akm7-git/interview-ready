package com.akm.intready.misc;

public class NearestPalindromeNo {

    public int getNearestpalindromeNo(int n) {
        int rev = -1;
        for (int i = n; i < 2 * n; i++) {
            rev = Integer.parseInt(new StringBuffer(i + "").reverse().toString());
            if (rev == i) {
                System.out.println("Nearest palindrome of " + n + " is : " + rev);
                break;
            }
        }
        return rev;
    }

    public int getNearestPalindromeNoWithoutUsingFunction(int n) {

        PalindromeNo pn = new PalindromeNo();
        for (int i = n; i < 2 * n; i++) {
            if (pn.isPalindrome(i)) {
                System.out.println("Found a palindrome no");
                return i;
            }
        }
        return -1;
    }

    public int getNearestPalindromeRecursive(int n) {

        PalindromeNo pn = new PalindromeNo();
        if (pn.isPalindrome(n)) {
            System.out.println("Nearest palindrome is " + n);
            return n;
        }
        return getNearestPalindromeRecursive(n + 1);
    }

    public static void main(String[] args) {
        System.out.println("####### Approach-1: solution for nearest palindrome using inbuilt function #####");
        new NearestPalindromeNo().getNearestpalindromeNo(171);
        System.out.println("####### Approach-2: solution for nearest palindrome without using inbuilt function #####");
        new NearestPalindromeNo().getNearestPalindromeNoWithoutUsingFunction(171);
        System.out.println("####### Approach-3: recursive solution for nearest palindrome #####");
        new NearestPalindromeNo().getNearestPalindromeRecursive(171);
    }
}
