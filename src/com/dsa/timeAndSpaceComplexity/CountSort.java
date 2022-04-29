package com.dsa.timeAndSpaceComplexity;

import java.util.Scanner;

public class CountSort {
    public static void countSort(int[] arr, int min, int max) {
        int range = max - min ;
        int[] farr = new int[range];

        for (int i =0; i< arr.length; i++){
            int idx = arr[i]-min;
            farr[idx]++;
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

        countSort(arr,min,max);
        print(arr);
    }

}
