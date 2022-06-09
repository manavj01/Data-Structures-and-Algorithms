package com.dsa.hashmapsAndHeaps;

import java.io.*;
import java.util.*;

public class MergeKSortedList {
    public static class Pair implements Comparable<Pair> {
        // In this, we use Lists of Lists which means
        // eg - 1 or more lists that contains 1 or more lists
        int li; // list index
        int di; // data index
        int val; // val of the given list's data index

        //constructor
        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        // compareTo function from Comparable interface
        public int compareTo(Pair o) {
            return this.val - o.val;
        }

    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        // An arraylist of integer type, rv is defined
        ArrayList<Integer> rv = new ArrayList<>();
        // Priority Queue , pq of type Pair is defined
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Adding first element of all lists in pq
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        // Running a while loop until pq empties out
        while (pq.size() > 0) {
            // A pair is removed from pq and stored in p
            Pair p = pq.remove();
            //Removed pair's i.e p's data is added to rv
            rv.add(p.val);
            //updating p's data index for further use
            p.di++;

            // if updated p's data index is within the range of the given lists
            // size then we extract the incremented value and update our pair p
            if (p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                // adding the updated pair back in the pq
                pq.add(p);
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
