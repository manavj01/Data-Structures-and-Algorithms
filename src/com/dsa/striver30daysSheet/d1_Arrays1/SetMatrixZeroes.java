package com.dsa.striver30daysSheet.d1_Arrays1;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void optimal(int[][] matrix) {
        int col0 = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++ ){
                if(matrix[i][j] == 0){
                    matrix[i][0]=0;
                    if( j!= 0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }

                }
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++ ){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int j=0; j<m;j++){
                matrix[0][j] =0;
            }
        }
        if(col0 == 0){
            for(int i=0; i<n; i++){
                matrix[i][0] =0;
            }
        }

    }
    public static void setZeroes(int[][] matrix) {

        ArrayList<Pair> arr = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Pair ele = new Pair(i, j);
                    arr.add(ele);
                }
            }
        }

        for (Pair pair : arr) {
            int row = pair.row;
            int col = pair.col;

            for (int c = 0; c < matrix[0].length; c++) {
                matrix[row][c] = 0;
            }
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][col] = 0;
            }
        }

    }


    public static void setZeroes1(int[][] matrix) {
        int clm0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) clm0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (clm0 == 0) matrix[i][0] = 0;
        }


    }
    public static void setZeros2(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    row[i]=-1;
                    col[j]=-1;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(row[i] == -1){
                makeRowZero(matrix,i);
            }
        }
        for(int j=0; j<m; j++){
            if(col[j] == -1){
                makeColZero(matrix,j);
            }
        }

    }
    public static void makeRowZero(int[][] matrix, int i ){
        for(int j=0; j<matrix[0].length;j++){
            matrix[i][j] = 0;
        }
    }
    public static void makeColZero(int[][] matrix, int j ){
        for(int i=0; i<matrix.length;i++){
            matrix[i][j] = 0;
        }
    }

}

