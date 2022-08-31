package com.dsa.striver30daysSheet.d10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, res, 0);
        return res;
    }

    public void solve(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) ds.add(num);
            res.add(ds);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            solve(nums, res, index + 1);
            swap(nums, i, index);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        solve2(nums, ds, res, freq);
        return res;
    }

    public void solve2(int[] nums, List<Integer> ds, List<List<Integer>> res, boolean[] freq) {
        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                solve2(nums, ds, res, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}
