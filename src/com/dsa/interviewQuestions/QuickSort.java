package com.dsa.interviewQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
//        8 5 1 3 7 2 9 6
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = arr[hi];
        int pivotIdx = partition(arr, pivot, lo, hi);

        quickSort(arr, lo, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, hi);

    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo, j = lo;

        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else i++;
        }

        return j - 1;
    }

    public static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
