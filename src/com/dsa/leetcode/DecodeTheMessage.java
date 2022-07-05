package com.dsa.leetcode;

import java.util.HashMap;

public class DecodeTheMessage {
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";

        String message = "vkbs bs t suepuv";
        String ans = decodeMessage(key, message);
        System.out.println(ans);
    }

    public static String decodeMessage(String key, String message) {
        HashMap<Character, Character> hm = new HashMap<>();
        Character alp = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (!hm.containsKey(ch)) {
                if (!(ch == ' ')) {
                    hm.put(ch, alp);
                    alp++;
                }
            }
        }
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (ch == ' ') {
                str.append(" ");
            } else {
                str.append(hm.get(ch));
            }
        }

        return str.toString();
    }
}
