package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class PaintFence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int same = k;
        int diff = k * (k - 1);
        int total = same + diff;
        for (int i = 3; i <= n; i++) {
            int nsame = diff;
            int ndiff = total * (k - 1);
            int ntotal = nsame + ndiff;

            same = nsame;
            diff = ndiff;
            total = ntotal;
        }
        System.out.println(total);


    }
}
