package com.dsa.striver30daysSheet.d2_Arrays2;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptrN2 = n - 1;
        int ptrN1 = m - 1;
        int idx = nums1.length - 1;

        while (ptrN1 >= 0 && ptrN2 >= 0) {
            nums1[idx--] = (nums1[ptrN1] > nums2[ptrN2])
                    ? nums1[ptrN1--]
                    : nums2[ptrN2--];

        }

        while (ptrN2 >= 0) {
            nums1[idx--] = nums2[ptrN2--];
        }


    }
}
