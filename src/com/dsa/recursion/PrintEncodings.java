package com.dsa.recursion;

import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char alphabet = (char) ('a' + chv - 1);
                System.out.println(asf + alphabet);
            }
        } else {
            char ch = str.charAt(0);
            String ros = str.substring(1);

            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char alphabet = (char) ('a' + chv - 1);
                printEncodings(ros, asf + alphabet);
            }
            String ch12 = str.substring(0, 2);
            String ros12 = str.substring(2);

            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char alphabet12 = (char) ('a' + ch12v - 1);
                printEncodings(ros12, asf + alphabet12);
            }


        }
    }
}
