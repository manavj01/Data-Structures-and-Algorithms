package com.dsa.dailyLeetCodeQuest;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
//        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();


        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // System.out.println(map);
        ArrayList<String>[] freq = new ArrayList[map.size() + 1];


        for (String word : map.keySet()) {
            int idx = map.get(word);
            if (freq[idx] == null) {
                freq[idx] = new ArrayList<>();
            }
            freq[idx].add(word);
        }
        List<String> res = new ArrayList<>();
        for (int z = 0; z < k; z++) {
            res.add("");
        }
//        System.out.println(Arrays.toString(freq));

        int size = freq.length - 1;
        while (size > 0) {
            if (freq[size] == null) {
                size--;
                continue;
            }
            Collections.sort(freq[size]);
//            freq[size].sort();

            for (int j = 0; j < freq[size].size(); j++) {
                res.set(k-1, freq[size].get(j));
                k--;
                if (k <= 0) return res;
            }
            size--;
        }
        Collections.reverse(res);
        return res;
    }
}
