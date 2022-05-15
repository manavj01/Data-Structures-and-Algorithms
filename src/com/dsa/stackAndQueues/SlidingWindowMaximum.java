package com.dsa.stackAndQueues;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        Stack<Integer> st = new Stack<>();

        int nge[] = new int[arr.length];


        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            // - a + (pops-> answer -> pushes)
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(nge));
        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            // enter the loop to find maximum of window starting at i
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            System.out.println(arr[j]);

        }

    }
}

//2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6
