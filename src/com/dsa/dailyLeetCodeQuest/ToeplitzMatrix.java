package com.dsa.dailyLeetCodeQuest;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {36, 59, 71, 15, 26, 82, 87},
                {56, 36, 59, 71, 15, 26, 82},
                {15, 0, 36, 59, 71, 15, 26}
        };
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int[] a = matrix[0];

        for (int i = 1; i < n; ++i) {
            int ptr = 0;
            for (int j = i; j < m; ++j) {
                if (matrix[i][j] != a[ptr++]) return false;
            }
        }
        int size = 1;
        for (int x = n - 1; x > 0; x--) {
            int tbc = matrix[x][0];
            for (int z = x, y = 0; y < size; y++, z++) {
                if (matrix[z][y] != tbc) return false;
            }
            size++;
        }

        return true;
    }
}