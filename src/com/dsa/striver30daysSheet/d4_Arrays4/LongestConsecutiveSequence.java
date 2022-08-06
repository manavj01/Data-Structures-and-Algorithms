package com.dsa.striver30daysSheet.d4_Arrays4;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
//        int[] arr = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Instant start = Instant.now();
        System.out.println(longestConsecutive(arr));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println(timeElapsed.getNano());
    }

    public static int longestConsecutive1(int[] A) {
        Arrays.sort(A);
        int c = 1;
        int maxc = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            int a = A[i - 1];
            int b = A[i];
            if (a == b) {
                continue;
            } else if (a + 1 == b) {
                c++;
            } else {
                c = 1;
            }
            maxc = Math.max(c, maxc);
        }

        return maxc == Integer.MIN_VALUE ? 1 : maxc;
    }

    public static int longestConsecutive(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int a : A) {
            set.add(a);
        }
        int longestStreak = 0;
        for (int num : A) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }
}
