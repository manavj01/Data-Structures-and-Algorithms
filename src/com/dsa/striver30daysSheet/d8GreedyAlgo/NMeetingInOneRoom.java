package com.dsa.striver30daysSheet.d8GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NMeetingInOneRoom {
    public static void main(String[] args) {
        int[] start = new int[]{75, 50, 43, 8, 11, 27, 50, 77};
        int[] end = new int[]{112, 114, 81, 93, 54, 35, 73, 160};
        int n = 8;
        System.out.println(maxMeetings(start, end, n));

    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public int compareTo(Pair o) {
            return this.end - o.end;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(start[i], end[i]));
        }

        int c = 1;
        int ed = pq.poll().end;

        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            if (p.start > ed) {
                c++;
                ed = p.end;
            }
        }
        return c;
    }

    // aproach 2
    class meeting {
        int start;
        int end;
        int pos;

        meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<meeting> {
        @Override
        public int compare(meeting o1, meeting o2) {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if (o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

    void maxMeetings1(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i + 1));

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

}

