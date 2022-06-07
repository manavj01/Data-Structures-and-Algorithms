package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class CountAplusBplusCplus {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = 2 * a + 1;
            } else if (str.charAt(i) == 'b') {
                ab = 2 * ab + a;
            } else {
                abc = 2 * abc + ab;
            }
        }
        System.out.println(abc);

    }
}
