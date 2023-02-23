package com.dsa.dailyLeetCodeQuest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        TheNumberOfWeakCharactersInTheGame obj = new TheNumberOfWeakCharactersInTheGame();
        TheNumberOfWeakCharactersInTheGame.Solution innerobj = new TheNumberOfWeakCharactersInTheGame.Solution();
        System.out.println(innerobj.numberOfWeakCharacters(nums));
    }

    // Time complexity: O(NlogN) - The time for sorting O(NLongN) + time for iterating over the list O(logN)
    // Space complexity: O(logN) - the space it takes for sorting
    static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            // Sort in ascending order of attack,
            // If attack is same sort in descending order of defense
            Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);
            for (int[] a : properties){
                System.out.println(Arrays.toString(a));
            }
            int weakCharacters = 0;
            int maxDefense = 0;
            for (int i = properties.length - 1; i >= 0; i--) {
                // Compare the current defense with the maximum achieved so far
                if (properties[i][1] < maxDefense) {
                    weakCharacters++;
                } else {
                    maxDefense = properties[i][1];
                }
            }

            return weakCharacters;
        }
    }
}