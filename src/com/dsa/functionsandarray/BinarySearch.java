package com.dsa.functionsandarray;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        int data = 90;

        int li = 0;
        int ri = arr.length - 1;

        while (li <= ri) {
            int mid = (li + ri) / 2;


            if (arr[mid] < data) {
                li = mid + 1;

            } else if (arr[mid] > data) {
                ri = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }

        }
        System.out.println(-1);
    }
}