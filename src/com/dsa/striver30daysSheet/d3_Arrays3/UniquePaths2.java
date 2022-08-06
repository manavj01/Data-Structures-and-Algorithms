package com.dsa.striver30daysSheet.d3_Arrays3;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obs = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obs));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j - 1] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }


    public int uniquePathsWithObstaclesDP(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = -2;
                }
            }
        }
        if (arr[n - 1][m - 1] == 1) {
            return 0;
        }

        return uniquePathsWithObstaclesDPHelper(0, 0, n, m, dp);
    }

    public static int uniquePathsWithObstaclesDPHelper(int i, int j, int n, int m, int[][] dp) {
        if (i == (n - 1) && j == (m - 1)) {
            return 1;
        }

        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] == -2) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            return dp[i][j] = uniquePathsWithObstaclesDPHelper(i + 1, j, n, m, dp) + uniquePathsWithObstaclesDPHelper(i, j + 1, n, m, dp);
        }
    }
}
