package com.dsa.hashmapsAndHeaps;

import java.io.*;
import java.util.*;

public class PriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue(int[] arr) {
            data = new ArrayList<>();
            for (int val : arr) {
                data.add(val);
            }
            for (int i = data.size() / 2 - 1; i >= 0; i--) {
                downheapify(i);
            }
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int i) {
            int pi = (i - 1) / 2;
            if (data.get(i) < data.get(pi)) {
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;

        }

        private void downheapify(Integer pi) {
            int mini = pi;
            int lci = 2 * pi + 1;
            if (lci < data.size() && data.get(lci) < data.get(mini)) {
                mini = lci;
            }
            int rci = 2 * pi + 2;
            if (rci < data.size() && data.get(rci) < data.get(mini)) {
                mini = rci;
            }
            if (mini != pi) {
                swap(pi, mini);
                downheapify(mini);
            }
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {10, 2, 17, 3, 18, 9, 22};
        PriorityQueue qu = new PriorityQueue(arr);

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
