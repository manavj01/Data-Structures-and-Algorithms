package com.dsa.striver30daysSheet.d3_Arrays3;

public class SearchInA2DMatrix2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(arr, target));
    }


    public static boolean searchMatrix1(int[][] arr, int target) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (target >= arr[i][0]) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (target == arr[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] > target) {
                j--;
            } else if (arr[i][j] < target) {
                i++;
            }
        }

        return false;
    }


}
