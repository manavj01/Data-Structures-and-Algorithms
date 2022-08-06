package com.dsa.leetcode;

public class MaximumNumberOfGroupsEnteringCompetition {

    public static void main(String[] args) {
        int[] nums = {10, 6, 12, 7, 3, 5};
        System.out.println(maximumGroups(nums));
    }

    public static int maximumGroups(int[] nums) {
        int n = nums.length;
        int i = 0, sum = 0;

        while (sum < n) {
            i++;
            sum = (i * (i + 1)) / 2;
            if (sum == n) return i;
        }
        return i - i; // i must have gone one step further, so return i-1
    }
}
