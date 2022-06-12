package com.dsa.leetcode;

import java.lang.reflect.Array;

public class vowelReverse {
    public static void main(String[] args) {
        String s = "aA";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        char[] charr = s.toCharArray();

        while (i <= j) {
            if ( (isvowel(charr[i])) && (!isvowel(charr[j])) ) {
                j--;
            } else if (!(isvowel(charr[i])) && (isvowel(charr[j]))) {
                i++;
            } else if (!(isvowel(charr[i])) && (!isvowel(charr[j]))) {
                i++;
                j--;
            } else if ((isvowel(charr[i])) && (isvowel(charr[j]))) {
                char temp = charr[i];
                charr[i] = charr[j];
                charr[j] = temp;
                i++;
                j--;
            }
        }
        String rt = String.valueOf(charr);
        return rt;

    }

    public static boolean isvowel(char v) {
        if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U'){
            return true;
        }
            return false;
    }

//    public static String swap(int si, int ei, String s) {
//
////        char[] charr = s.toCharArray();
//
//
//
//    }
}
