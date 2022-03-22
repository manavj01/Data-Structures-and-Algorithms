package com.dsa.timeAndSpaceComplexity;

import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr) {


        for (int i=0; i<arr.length;i++){
            int min =i;
            for (int j=i+1;j< arr.length;j++){
                if (isSmaller(arr,j,min)){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
    }

    // used for swapping ith and jth elements of array
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
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        selectionSort(arr);
        print(arr);
    }

}
