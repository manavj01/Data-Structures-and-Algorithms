package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {3, 2}, {2, 3}}, items2 = {{2, 1}, {3, 2}, {1, 3}};
        System.out.println(mergeSimilarItems(items1, items2));
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] item : items1) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], item[1]);
            } else map.put(item[0], map.get(item[0]) + item[1]);
        }
        for (int[] item : items2) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], item[1]);
            } else map.put(item[0], map.get(item[0]) + item[1]);
        }

        for (int key : map.keySet()) {
            List<Integer> weights = new ArrayList<>();
            weights.add(key);
            weights.add(map.get(key));
            res.add(weights);
        }
        return res;
    }
}
