package com.dsa.stackAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementToTheRIght {

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve2(a);
        display(nge);
    }

    // ex1 - 2 5 9 3 1 12 6 8 7 -> 5 9 12 12 12 -1 8 -1 -1
    // exp2 - 5 3 8 -2 7 -> 8 8 -1 7 -1

    public static int[] solve(int[] arr) {
        int[] nge = new int[arr.length];

        // ex1 - 9 2 5 9 3 1 12 6 8 7 -> 5 9 12 12 12 -1 8 -1 -1
        // exp2 - 5 3 8 -2 7 -> 8 8 -1 7 -1
        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            // - a + (pops-> answer -> pushes)
            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return nge;
    }

    // Next greater element to the right -> iterate from left side
    public static int[] solve2(int[] arr) {
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }

        return nge;
    }
}
