package com.dsa.twodarrays;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 6, 5, 4};
        arr = mergerSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergerSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }

        int mid = (lo + hi) / 2;
        int[] fsh = mergerSort(arr, lo, mid);
        int[] ssh = mergerSort(arr, mid + 1, hi);

        return mergeTwoSortedArrays(fsh, ssh);
    }

    public static int[] mergeTwoSortedArrays(int[] left, int[] right) {
        int[] mergeArray = new int[left.length + right.length];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < left.length && idx2 < right.length) {
            if (left[idx1] <= right[idx2]) {
                mergeArray[idx++] = left[idx1++];
            } else {
                mergeArray[idx++] = right[idx2++];
            }
        }
        while (idx1 < left.length) {
            mergeArray[idx++] = left[idx1++];
        }
        while (idx2 < right.length) {
            mergeArray[idx++] = right[idx2++];
        }
        return mergeArray;
    }
}
