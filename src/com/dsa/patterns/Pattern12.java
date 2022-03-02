package com.dsa.patterns;

import java.util.Scanner;

public class Pattern12 {

    // pattern 12
    // 0
    // 1 1
    // 2 3 5
    // 8 13 21
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + "\t");
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
        }
    }
}
