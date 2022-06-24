package com.dsa.strings_StringBuilder_ArrayList;

import java.util.*;

public class StringPermutation {
    public static void solution(String str) {

        int n = str.length();
        int f = fact(n);

        for (int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(str);

            int temp = i;
            for (int div = n; div >= 1; div--) {
                int q = temp / div;
                int rem = temp % div;
                System.out.println(sb.charAt(rem));
                sb.deleteCharAt(rem);
                temp = q;
            }
            System.out.println();
        }
    }

    private static int fact(int n) {
        int a = 1;
        int t = n;
        while (t != 0) {
            a = a * t;
            t--;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}
