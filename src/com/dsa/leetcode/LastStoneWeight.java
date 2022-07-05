package com.dsa.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while ((pq.size() != 1) && (!pq.isEmpty())) {
            int l = pq.poll();
            int s = pq.poll();

            if (l != s) {
                pq.add(l - s);
            }

        }

        return pq.peek() == null ? 0 : pq.poll();

    }
}
