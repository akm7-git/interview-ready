package com.akm.intready.misc;

public class PalindromeNo {

    public boolean isPalindrome(int n) {
        int cno = n;
        int sum = 0;
        while (cno > 0) {
            int rem = cno % 10;
            sum = sum * 10 + rem;
            cno = cno / 10;
        }

        if (sum == n) {
            System.out.println("No : " + n + " is a palindrome");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean isPalindrome = new PalindromeNo().isPalindrome(7127);
        System.out.println("is palindrome : " + isPalindrome);
    }
}
