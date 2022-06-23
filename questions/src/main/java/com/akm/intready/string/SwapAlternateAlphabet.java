package com.akm.intready.string;

public class SwapAlternateAlphabet {

    public String getSwappedString(String str) {
        String result = "";
        for (int i = 0, j = 1; i < str.length() || j < str.length(); i += 2, j += 2) {
            if (j < str.length())
                result = result + str.charAt(j);
            if (i < str.length())
                result = result + str.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "alokmishra";
        String res = new SwapAlternateAlphabet().getSwappedString(str);

        System.out.println(str + " after swapping alternate char : " + res);
    }
}
