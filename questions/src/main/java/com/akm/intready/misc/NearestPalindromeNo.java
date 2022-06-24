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

    public static void main(String[] args) {
        new NearestPalindromeNo().getNearestpalindromeNo(135942);
    }
}
