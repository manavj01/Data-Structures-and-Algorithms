package com.dsa.leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString2 {
    public static void main(String[] args) {
        int n = 3;
        String s = "deeedbbcccbdaa";
        System.out.println(removeDuplicates(s, n));
    }

    public static String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!stk.isEmpty() && stk.peek().ch == ch) {
                stk.peek().count++;
            } else {
                stk.push(new Pair(ch, 1));
            }
            if (stk.peek().count == k) stk.pop();
        }

        while (!stk.isEmpty()) {
            Pair p = stk.pop();
            char ch = p.ch;
            int count = p.count;

            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
