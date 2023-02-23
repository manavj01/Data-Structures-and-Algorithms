package com.dsa.striver30daysSheet.d8_GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().
                findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.parallelSort(points, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int arrow = 0;
        for (int[] point : points) {
            if (ans == 0 || point[0] > arrow) {
                ans++;
                arrow = point[1];
            }
        }
        return ans;
    }
}
