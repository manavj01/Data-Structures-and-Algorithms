package com.dsa.stackAndQueues;

import java.io.*;
import java.util.*;

public class FindCelebrity {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then print "none"
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // if i knows j -> i is not a celebrity
                st.push(j);
            } else {
                // if i does not knows j -> j is not a celebrity
                st.push(i);
            }
        }

        int potential = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != potential) {
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potential);


    }
}
//4
//0000
//1011
//1101
//1110