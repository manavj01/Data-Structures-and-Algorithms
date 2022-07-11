package com.dsa.slidingWindow;

import java.util.Collections;

public class MaximumSubarray {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
       int i =5,j=10;
        i=i^j^(j=i);// xor swapping
        i = i+(j-(j=i)); // ops swapping
        System.out.println(i+" "+j);
        int[] nums = new int[]{5, 4, -1, 7, 8};

        int ans = maxSubArray(nums);
        System.out.println(ans);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
