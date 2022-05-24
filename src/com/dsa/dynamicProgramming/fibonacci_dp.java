package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class fibonacci_dp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] qb = new int[n + 1];
        int ans = fib(n, qb);
        System.out.println(ans);
    }

    public static int fib(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int fibnm1 = fib(n - 1, qb);
        int fibnm2 = fib(n - 2, qb);
        int fibn = fibnm1 + fibnm2;

        qb[n] = fibn;
        return fibn;
    }
}
