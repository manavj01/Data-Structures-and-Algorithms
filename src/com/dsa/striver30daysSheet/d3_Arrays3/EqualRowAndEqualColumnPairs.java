package com.dsa.striver30daysSheet.d3_Arrays3;

import java.util.Arrays;

public class EqualRowAndEqualColumnPairs {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;

        int[][] trans = new int[n][n];
        transpose(grid, trans);

        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(grid[i], trans[j])) {
                    c++;
                }
            }
        }

        return c;
    }

    public static void transpose(int[][] grid, int[][] trans) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trans[i][j] = grid[j][i];
            }
        }
    }
}
