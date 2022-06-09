package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class PaintHouse2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int h = scn.nextInt();
        int c = scn.nextInt();
        long[][] arr = new long[h][c];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        long[][] dp = new long[h][c];

        long least = Integer.MAX_VALUE;
        long sleast = Integer.MAX_VALUE;

        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];
            } else if (arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
            dp[0][j] = arr[0][j];
        }

        // Approach 1   (n cube)
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                long min = Integer.MAX_VALUE;
//
//                for (int k = 0; k < dp[0].length; k++){
//                    if (k != j){
//                        if (dp[i-1][k] < min){
//                            min = dp[i-1][k];
//                        }
//                    }
//                }
//                dp[i][j] = arr[i][j] + min;
//            }
//        }
        // approach 2  (n square)

        for (int i = 1; i < dp.length; i++) {
            long nleast = Integer.MAX_VALUE;
            long nsleast = Integer.MAX_VALUE;

            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = sleast + arr[i][j];
                } else {
                    dp[i][j] = least + arr[i][j];
                }
                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);


    }
}
