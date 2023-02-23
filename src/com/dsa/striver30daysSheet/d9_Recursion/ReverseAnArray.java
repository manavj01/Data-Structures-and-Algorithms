package com.dsa.striver30daysSheet.d9_Recursion;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        reverseArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseArray(int[] nums) {

        solve(nums, nums.length - 1, 0);
    }

    public static void solve(int[] nums, int idx, int recurIdx) {
        if (recurIdx >idx) {
            return;
        }
        if (idx > recurIdx) swap(nums, idx, recurIdx);
        solve(nums, idx - 1, recurIdx + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
