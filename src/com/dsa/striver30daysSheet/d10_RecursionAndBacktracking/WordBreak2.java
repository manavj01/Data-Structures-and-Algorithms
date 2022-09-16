package com.dsa.striver30daysSheet.d10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] dict = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<>(List.of(dict));
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> list = new ArrayList<>();

        solve(wordDict, list, s, "");

        return list;
    }

    public static void solve(List<String> wordDict, ArrayList<String> list, String str, String ans) {
        if (str.length() == 0) {
            list.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (wordDict.contains(left)) {
                String right = str.substring(i + 1);
                solve(wordDict, list, right, ans + left + " ");
            }
        }
    }
}
