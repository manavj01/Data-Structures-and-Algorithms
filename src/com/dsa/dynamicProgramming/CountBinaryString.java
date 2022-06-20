package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class CountBinaryString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        //method 1 by arrays
//        int[] dp0 = new int[n + 1];
//        int[] dp1 = new int[n + 1];
//
//        dp0[1] = 1;
//        dp1[1] = 1;
//
//        for (int i = 2; i<= n ; i++){
//            dp1[i] = dp1[i-1] + dp0[i-1];
//            dp0[i] = dp1[i-1] ;
//        }
//        System.out.println(dp1[n] + dp0[n]);

        int oczeros = 1;
        int ocones = 1;

        for (int i = 2; i <= n; i++) {
            int nczeros = ocones;
            int ncones = ocones + oczeros;

            ocones = ncones;
            oczeros = nczeros;
        }
        System.out.println(ocones + oczeros);
    }
}
