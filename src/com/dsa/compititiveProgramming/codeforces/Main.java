package com.dsa.compititiveProgramming.codeforces;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine().trim());


//        while (t-- > 0) {
        String[] line1 = br.readLine().trim().split(" ");

        int n = Integer.parseInt(line1[0]);
//        int m = Integer.parseInt(line1[1]);
        String[][] line2 = new String[n][3];

        for (int i = 0; i < n; i++) {
            line2[i] = br.readLine().trim().split(" ");

        }

        long[][] mat = new long[n][3];

        for (int i = 0; i < line2.length; i++) {
            mat[i][0] = Integer.parseInt(line2[i][0]);
            mat[i][1] = Integer.parseInt(line2[i][1]);
            mat[i][2] = Integer.parseInt(line2[i][2]);
        }
        int sum = 0;
        for (long[] m : mat) {
            sum += (int)m[2];
        }
        long[][] dp = new long[n][sum + 1];
        for (long[] d : dp) Arrays.fill(d, -1);
//        System.out.println(min);
        long votes = 0;
        long ans = president(dp, mat, n - 1, 0, votes);
//        if (ans == -1 || ans == min){
//            System.out.println(0);
         System.out.println(ans);
//        System.out.println( == -1 ? 0 : president(dp, mat, n - 1, 0, 0));

    }

    static long president(long[][] dp, long[][] mat, int n, long seats, long votes) {
        if (n == -1) {
            if (seats >= dp[0].length / 2) {
                return votes;
            } else {
                return min;
            }
        }

        if (dp[n][(int)seats] != -1) return dp[n][(int)seats];

        if (mat[n][0] > mat[n][1]) {
//            seats += ;
            dp[n][(int)seats] = president(dp, mat, n - 1, seats + mat[n][2], votes);
        } else {
            long vtw = (mat[n][1] - mat[n][0]) / 2 + 1;
            dp[n][(int)seats] = min(president(dp, mat, n - 1, seats + mat[n][2], votes + vtw), president(dp, mat, n - 1, seats, votes));
        }
        return dp[n][(int)seats];
    }
    static long min(long a, long b){
        if (a < b) return a;
        else  return b;
    }

    static long min = 1;

    static {
        for (int i = 1; i <= 13; i++) {
            min *= 10;
        }
    }

}

