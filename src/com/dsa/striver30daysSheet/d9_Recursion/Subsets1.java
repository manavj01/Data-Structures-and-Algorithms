package com.dsa.striver30daysSheet.d9_Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets1 {
    static {
        String url = "https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)";
    }

    public static void main(String[] args) {
        int N = 2;
        Integer[] a = new Integer[]{2, 3};
        ArrayList<Integer> arr = new ArrayList<>(List.of(a));
        System.out.println(new Subsets1().subsetSums(arr, N));
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> res = new ArrayList<>();
        solve(0, 0, res, arr, N);
        Collections.sort(res);
        return res;
    }

    public void solve(int idx, int sum, ArrayList<Integer> res, ArrayList<Integer> arr, int N) {
        if (idx == N) {
            res.add(sum);
            return;
        }
        // pick the element
        solve(idx + 1, sum + arr.get(idx), res, arr, N);
        // Do-not pick the element
        solve(idx + 1, sum, res, arr, N);
    }
}
