package com.dsa.striver30daysSheet.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 4, 2};
//        int[] nums = {3,2,1};
//        int[] nums = {1,2,3};
//        int[] nums = {1,1,5};
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] A) {
        if (A == null || A.length <= 1) return;

        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = A.length - 1;
            while (A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
    }

    public static void reverse(int[] arr, int si, int ei) {
        while (si <= ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }

    public static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }
}
