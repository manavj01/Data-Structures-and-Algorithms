package com.dsa.striver30daysSheet.d9_Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 17));
    }

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }

    // not optimal -> approach backtracking
    public String getPermutation1(int n, int k) {
        StringBuilder s = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        solve(s.toString().toCharArray(), 0, res);
        Collections.sort(res);

        return res.get(k - 1);
    }

    public void solve(char[] s, int index, ArrayList<String> al) {
        if (index == s.length) {
            String str = Arrays.toString(s);
            al.add(str);
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            solve(s, index + 1, al);
            swap(s, i, index);

        }
    }

    public void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}
