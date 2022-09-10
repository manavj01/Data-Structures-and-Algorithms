package com.dsa.striver30daysSheet.d12_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 5, 9)));
        list.add(new ArrayList<>(Arrays.asList(45, 90)));
        list.add(new ArrayList<>(Arrays.asList(2, 6, 78, 100, 234)));

        System.out.println(mergeKSortedArrays(list, 3));

    }

    public static ArrayList<Integer> mergeKSortedArrays1(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (ArrayList<Integer> arr : kArrays) {
            que.addAll(arr);
        }

        while (!que.isEmpty()) {
            res.add(que.poll());
        }

        return res;
    }

    static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int val;

        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < kArrays.size(); i++) {
            Pair p = new Pair(i, 0, kArrays.get(i).get(0));
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            Pair tba = pq.poll();
            res.add(tba.val );
            tba.di++;

            if (tba.di < kArrays.get(tba.li).size()){
                tba.val = kArrays.get(tba.li).get(tba.di);
                pq.add(tba);
            }
        }


        return res;
    }
}
