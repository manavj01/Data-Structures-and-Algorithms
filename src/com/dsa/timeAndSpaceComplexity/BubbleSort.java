package com.dsa.timeAndSpaceComplexity;

import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (isSmaller(arr, j + 1, j)) {
                    swap(arr, j + 1, j);
                }
            }

        }
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        return arr[i] < arr[j];
    }

    public static void print(int[] arr) {
        System.out.print("[ ");
        for (int j : arr) {
            System.out.print(j + " ,");
        }
        System.out.print(" ]");

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr);
        print(arr);
    }
}
