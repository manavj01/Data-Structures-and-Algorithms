package com.dsa.striver30daysSheet;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
