package com.dsa.stringstringbuilderarraylist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String t = scn.next();
        /**
         * Palindromic Substring
         */
//        PalindromicSubstrings.solution(s);

        /**
         * String Compression
         */
//        String s1 = StringCompression.compression1(s);
//        System.out.println(s1);
//        String s2 = StringCompression.compression2(s);
//        System.out.println(s2);

        /**
         * Toggle Case
         */

        String s1 = ToggleCase.toggleCase(t);
        System.out.println(s1);
    }
}
