package com.dsa.striver30daysSheet.d9_Recursion;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0, res);
        return res;
    }

    public void solve(int[] s, int index, List<List<Integer>> res) {
        if (index == s.length) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int j : s) {
                al.add(j);
            }
            res.add(new ArrayList<>(al));
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            solve(s, index + 1, res);
            swap(s, i, index);

        }
    }

    public void swap(int[] s, int i, int j) {
        int ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}
