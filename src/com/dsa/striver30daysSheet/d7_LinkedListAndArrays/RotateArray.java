package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int si, int ei) {

        while (si <= ei) {
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }

    public static void rotate1(int[] nums, int k) {
        int[] res = new int[nums.length];
        k = k % nums.length;
        int temp = nums.length - k;

        for (int i = 0; i < k; i++) {
            res[i] = nums[temp++];
        }
        int t = k;
        for (int i = 0; i < nums.length - k; i++) {
            res[t++] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);

    }
}


