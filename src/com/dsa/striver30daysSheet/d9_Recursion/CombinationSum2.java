package com.dsa.striver30daysSheet.d9_Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new CombinationSum2().combinationSum(candidates, target));
    }

    // optimal
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    public void solve(int[] arr, int target, int idx, List<List<Integer>> res, ArrayList<Integer> ans) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) {
                break;
            }
            ans.add(arr[i]);
            solve(arr, target - arr[i], i + 1, res, ans);
            ans.remove(ans.size() - 1);
        }

    }

    // brute force
    public List<List<Integer>> combinationSumBruteForce(int[] candidates, int target) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        solveForBf(candidates, target, 0, 0, res, new ArrayList<>());
        System.out.println(res);
        return new ArrayList<>(res);
    }

    public void solveForBf(int[] arr, int target, int idx, int sum, HashSet<ArrayList<Integer>> res, ArrayList<Integer> ans) {
        if (idx == arr.length) {
            if (sum == target) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if (arr[idx] <= target - sum) {
            ans.add(arr[idx]);
            solveForBf(arr, target, idx + 1, sum + arr[idx], res, ans);
            ans.remove(ans.size() - 1);
        }
        solveForBf(arr, target, idx + 1, sum, res, ans);
    }
}
