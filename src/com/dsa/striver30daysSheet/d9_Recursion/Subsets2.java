package com.dsa.striver30daysSheet.d9_Recursion;

import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
//        int[] nums = new int[]{5, 2, 1};
        System.out.println(new Subsets2().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void solve(List<List<Integer>> res, List<Integer> temp, int[] nums, int idx) {
        res.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) continue; // skip duplicates
            temp.add(nums[i]);
            solve(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
