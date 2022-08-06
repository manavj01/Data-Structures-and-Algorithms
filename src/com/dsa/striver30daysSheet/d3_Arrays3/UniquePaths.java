package com.dsa.striver30daysSheet.d3_Arrays3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        System.out.println(uniquePaths(n, m));
    }

    public static int uniquePaths(int n, int m) {
        int N = n + m - 2;
        int r = n - 1;
//        or
//        int r = m-1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }

    static int c = 0;

    public static int uniquePaths1(int n, int m) {
        boolean[][] arr = new boolean[n][m];
        int sr = 0, sc = 0;
        uniquePaths1Helper(arr, sr, sc);
        return c;
    }

    public static void uniquePaths1Helper(boolean[][] arr, int sr, int sc) {
        if (sr == arr.length || sc == arr[0].length || arr[sr][sc]) {
            return;
        }

        if (sc == arr[0].length - 1 && sr == arr.length - 1) {
            c++;
            return;
        }

        arr[sr][sc] = true;
        uniquePaths1Helper(arr, sr, sc + 1);
        uniquePaths1Helper(arr, sr + 1, sc);
        arr[sr][sc] = false;
    }

    public static int uniquePaths2(int n, int m) {
        int i = 0, j = 0;
        return uniquePaths2Helper(i, j, n, m);
    }

    public static int uniquePaths2Helper(int i, int j, int n, int m) {
        if (i == (n - 1) && j == (m - 1)) {
            return 1;
        }
        if (i >= n || j >= m) {
            return 0;
        } else return uniquePaths2Helper(i + 1, j, n, m) + uniquePaths2Helper(i, j + 1, n, m);

    }

    public static int uniquePaths3(int n, int m) {
        int[][] dp = new int[n][m];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return uniquePaths3Helper(0, 0, n, m, dp);
    }

    public static int uniquePaths3Helper(int i, int j, int n, int m, int[][] dp) {
        if (i == (n - 1) && j == (m - 1)) {
            return 1;
        }

        if (i >= n || j >= m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            return dp[i][j] = uniquePaths3Helper(i + 1, j, n, m, dp) + uniquePaths3Helper(i, j + 1, n, m, dp);
        }
    }
}
