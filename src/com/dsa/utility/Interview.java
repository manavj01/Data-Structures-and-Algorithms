package com.dsa.utility;

import java.util.Arrays;
import java.util.Scanner;

public class Interview {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == 'X') {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = str.charAt(j) - '0';
                }
            }
        }
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
//        System.out.println(solve(matrix));

    }

//    public static String solve(char[][] matrix) {
//        int n = matrix.length;
//        int nd = (n * n) - (n * 2 - 1);
//        char ch = matrix[0][0];
//        char vh = matrix[1][0];
//        if (ch == vh ) return "NO";
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == j && ch != matrix[i][j]) {
//                    return "NO";
//                }
//                if (i + j == n - 1 && ch != matrix[i][j]) {
//                    return "NO";
//                }
//
//                if (i != j && i + j != n - 1) {
//                    if (matrix[i][j] != vh) {
//                        return "NO";
//                    }
//                }
//            }
//        }
//
//        return "YES";
//    }


}