package com.dsa.twodarrays;

public class SearchInA2dArray {
    public static void binarySearch(int[][] arr, int searchKeyword) {
        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (searchKeyword == arr[i][j]) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if (searchKeyword < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}
