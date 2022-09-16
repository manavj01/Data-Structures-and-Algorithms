package com.dsa.striver30daysSheet.d10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreak1 {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] dict = {"leet", "code"};
        List<String> wordDict = new ArrayList<>(List.of(dict));
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLength = 0;
        for (String word : wordDict)
            maxLength = Math.max(maxLength, word.length());

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {

                if (i - j > maxLength)
                    continue;

                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String w2Check = s.substring(j, i + 1);
                if (wordDict.contains(w2Check)) {
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i] += 1;
                    }
                }
            }
        }
        return dp[s.length() - 1] > 0;
    }
}
