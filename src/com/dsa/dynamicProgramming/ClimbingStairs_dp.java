package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs_dp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] qb = new int[n + 1];
//        int cp = countPath(n, qb);
        int cp = countPathtab(n);
        System.out.println(cp);
    }

    public static int countPath(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        int nm1 = countPath(n - 1, qb);
        int nm2 = countPath(n - 2, qb);
        int nm3 = countPath(n - 3, qb);
        int cp = nm1 + nm2 + nm3;

        qb[n] = cp;
        return cp;
    }

    public static int countPathtab(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {

            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

            }
        }
        return dp[n];
    }
}
