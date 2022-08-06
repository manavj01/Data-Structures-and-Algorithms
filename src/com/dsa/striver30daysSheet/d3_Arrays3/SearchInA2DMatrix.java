package com.dsa.striver30daysSheet.d3_Arrays3;

public class SearchInA2DMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
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

        int lo = 0;
        int hi = (n * m) - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid / m][mid % m] == target) {
                return true;
            } else if (arr[mid / m][mid % m] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;

    }
}
