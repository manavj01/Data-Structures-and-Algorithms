package com.dsa.patterns;

import java.util.Scanner;

public class Pattern1 {

    // pattern 1
    // *
    // * *
    // * * *
    // * * * *
    // * * * * *

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        // for (int i = n; i > 0; i--) {
        // for (int j = i; j <= n; j++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }
        // }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
