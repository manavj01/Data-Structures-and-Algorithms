package com.dsa.striver30daysSheet.d9_Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        solve(s, res, new ArrayList<String>());

        return res;
    }

    public void solve(String s, List<List<String>> res, ArrayList<String> ans) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            String ros = s.substring(i + 1);
            if (isPalindrome(prefix)) {
                ans.add(prefix);
                solve(ros, res, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if (left != right) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
