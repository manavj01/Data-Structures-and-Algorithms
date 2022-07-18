package com.dsa.striver30daysSheet.arrays2;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        int[][] matrix = {{2, 29, 20, 26, 16, 28}, {12, 27, 9, 25, 13, 21}, {32, 33, 32, 2, 28, 14}, {13, 14, 32, 27, 22, 26}, {33, 1, 20, 7, 21, 7}, {4, 24, 1, 6, 32, 34}};

        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-----------------");
        rotate1(matrix);
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static class Pair {
        int x;
        int y;

        Pair() {
        }

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void rotate(int[][] matrix) {
        Pair i = new Pair(0, 0);
        Pair j = new Pair(0, matrix.length - 1);
        Pair k = new Pair(matrix.length - 1, matrix.length - 1);
        Pair l = new Pair(matrix.length - 1, 0);
        int n = matrix.length - 1;
        for (int z = 0; z < matrix.length / 2; z++) {
            int idx = 0;
            Pair id = new Pair(i.x, i.y);
            Pair jd = new Pair(j.x, j.y);
            Pair kd = new Pair(k.x, k.y);
            Pair ld = new Pair(l.x, l.y);
            while (idx < n) {
                int temp = matrix[l.x][l.y];
                matrix[l.x][l.y] = matrix[k.x][k.y];
                matrix[k.x][k.y] = matrix[j.x][j.y];
                matrix[j.x][j.y] = matrix[i.x][i.y];
                matrix[i.x][i.y] = temp;
                l.x--;
                k.y--;
                j.x++;
                i.y++;
                idx++;
            }
            n = n - 2;
            i = id;
            j = jd;
            k = kd;
            l = ld;

            i.x++;
            i.y++;

            j.x++;
            j.y--;

            k.x--;
            k.y--;

            l.x--;
            l.y++;
        }
    }

    public static void rotate1(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while (s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

