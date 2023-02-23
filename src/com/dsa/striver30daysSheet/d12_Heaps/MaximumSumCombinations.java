package com.dsa.striver30daysSheet.d12_Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaximumSumCombinations {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(1);
        A.add(4);
        A.add(2);
        A.add(3);
        B.add(2);
        B.add(5);
        B.add(1);
        B.add(6);
        System.out.println(solve(A, B, 4));

    }

    static class pair {
        int a, b, sum;

        public pair(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    // 4 3  2 1 ->4
//    6 5 2 1
    public static ArrayList<Integer> solve1(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int size = A.size();
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        HashSet<Integer> hs = new HashSet<>();
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        pq.add(new pair(0, 0, A.get(0) + B.get(0)));
        hs.add(0);
        while (C-- != 0) {
            pair pair1 = pq.poll();
            int sum = pair1.sum;
            int a = pair1.a;
            int b = pair1.b;
            ans.add(sum);
            if (b + 1 < size && !hs.contains((a) * size + (b + 1))) {
                hs.add(a * size + b + 1);
                pq.add(new pair(a, b + 1, A.get(a) + B.get(b + 1)));
            }
            if (a + 1 < size && !hs.contains((a + 1) * size + b)) {
                hs.add((a + 1) * size + b);
                pq.add(new pair(a + 1, b, A.get(a + 1) + B.get(b)));
            }

        }
        return ans;
    }

    static class Pair {
        int a, b, sum;

        public Pair(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int size = A.size();
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());

        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        que.add(new Pair(0, 0, A.get(0) + B.get(0)));

        ArrayList<Integer> result = new ArrayList<>();

        while (C-- > 0) {
            Pair p = que.poll();

            int i = p.a;
            int j = p.b;
            int sum = p.sum;

            result.add(sum);

            if (j + 1 < size && !set.contains((i * size) + j + 1)) {
                set.add(i * size + j+1);
                que.add(new Pair(i, j + 1, A.get(i) + B.get(j + 1)));
            }

            if (i + 1 < size && !set.contains((i + 1) * size + j)) {
                set.add((i + 1) * size + j);
                que.add(new Pair(i + 1, j, A.get(i + 1) + B.get(j)));
            }

        }

        return result;
    }

}
