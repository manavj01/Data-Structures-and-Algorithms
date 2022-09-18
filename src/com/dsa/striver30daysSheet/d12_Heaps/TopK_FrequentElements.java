package com.dsa.striver30daysSheet.d12_Heaps;

import java.util.*;

public class TopK_FrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{1, 2};
        int k = 2;
        System.out.println(Arrays.toString(new TopK_FrequentElements().topKFrequent(nums, k)));
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int times;

        Pair(int val, int times) {
            this.val = val;
            this.times = times;
        }

        public int compareTo(Pair o) {
            return o.times - this.times;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int times = entry.getValue();
            if (bucket[times] == null) {
                bucket[times] = new ArrayList<>();
            }
            bucket[times].add(num);
        }
        for (int i = nums.length; i > 0; i--) {
            if (bucket[i] != null) {
                for (int a : bucket[i])
                    res[--k] = a;
            }
            if (k == 0) break;
        }

        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            Pair p = new Pair(key, map.get(key));
            pq.add(p);
        }
        int[] res = new int[k];
        int idx = 0;

        while (k-- > 0) {
            res[idx++] = pq.remove().val;
        }

        return res;
    }
}
