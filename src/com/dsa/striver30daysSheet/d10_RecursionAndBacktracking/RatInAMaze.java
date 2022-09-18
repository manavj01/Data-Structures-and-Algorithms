package com.dsa.striver30daysSheet.d10_RecursionAndBacktracking;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {
        int N = 4;
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(m, N));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        solve(m, n, 0, 0, "", res, visited);
        return res;
    }

    public static void solve(int[][] arr, int n, int i, int j, String psf, ArrayList<String> res, boolean[][] visited) {
        if (i < 0 || j < 0 || i == n || j == n || arr[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            res.add(psf);
            return;
        }
        visited[i][j] = true;
        solve(arr, n, i - 1, j, psf + "U", res, visited);
        solve(arr, n, i, j + 1, psf + "R", res, visited);
        solve(arr, n, i + 1, j, psf + "D", res, visited);
        solve(arr, n, i, j - 1, psf + "L", res, visited);
        visited[i][j] = false;
    }
}
