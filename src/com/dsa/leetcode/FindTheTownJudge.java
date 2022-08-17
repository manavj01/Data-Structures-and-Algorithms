package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = new int[][]{
                {1,3},{2,3},{3,1}
        };
        System.out.println(findJudge(n,trust));
    }
    public static int findJudge(int n, int[][] trust) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list);

        int num = list.get(1);
        list.remove(num);
        System.out.println(list);
        return 0;
    }
}
