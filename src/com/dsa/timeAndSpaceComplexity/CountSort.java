package com.dsa.timeAndSpaceComplexity;

import java.util.Scanner;

public class CountSort {
    public static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] farr = new int[range];
        int[] ans = new int[arr.length];

        // Make frequency array
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }
        // Convert it into prefix sum array
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        // stable sorting(filling ans array)
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            int idx = pos - 1;
            ans[idx] = val;
            farr[val - min]--;
        }
        // filling orignal array with the help of ans array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        countSort(arr, min, max);
        print(arr);
    }

}
