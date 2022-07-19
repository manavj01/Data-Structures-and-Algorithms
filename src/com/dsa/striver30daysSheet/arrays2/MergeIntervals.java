package com.dsa.striver30daysSheet.arrays2;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 3}, {4, 5}};
        int[][] ans = merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval() {
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public int compareTo(Interval o) {
            return this.end - o.end;
        }
    }

    public static int[][] merge(int[][] intervals) {
        Interval[] arr = new Interval[intervals.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Interval(intervals[i][0], intervals[i][1]);

        }
        Arrays.sort(arr);

        Stack<Interval> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                st.push(arr[0]);
            } else {
                Interval top = st.peek();
                if (arr[i].start > top.end) {
                    st.push(arr[i]);
                } else {
                    top.end = Math.max(top.end,arr[i].end);
                }
            }
        }
        int[][] ret = new int[st.size()][2];
        Stack<Interval> rst = new Stack<>();
        while (!st.isEmpty()) rst.add(st.pop());
       int idx=0;
        while (rst.size()>0){
            Interval r = rst.pop();
            ret[idx][0] = r.start;
            ret[idx][1] = r.end;
            idx++;
        }


        return ret;
    }
}
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i].start + "-" + arr[i].end);
//        }
