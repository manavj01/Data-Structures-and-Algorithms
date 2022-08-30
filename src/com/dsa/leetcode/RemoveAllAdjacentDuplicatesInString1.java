package com.dsa.leetcode;

import java.util.*;

public class RemoveAllAdjacentDuplicatesInString1 {
    public static void main(String[] args) {
        String s = "abbbaca"; // inaapauuaut

        // approach 1 -> optimal
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        System.out.println(new String(res, 0, i));

        // approach 2 -> stacks (O)N

        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) {
                while (!dq.isEmpty() && dq.peekLast() == c) dq.pollLast();
            } else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
