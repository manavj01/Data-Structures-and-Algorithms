package com.dsa.slidingWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};//{1, -1};
        int k = 3;//3;
        int[] res = maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] max = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        while (j < nums.length) {
            pq.add(nums[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max[idx++] = pq.peek();
                pq.remove(nums[i]);
                i++;
                j++;
            }
        }
        return max;
    }// gives TLE on big inputs

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to result (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(d->d).toArray();
    }
}
