package com.dsa.stackAndQueues;

import java.util.*;
import java.io.*;

public class MinimumStack1 {
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }


        int size() {
            // write your code here
            return allData.size();
        }

        void push(int val) {
            allData.push(val);

            if (minData.size() == 0 || val <= minData.peek()) {
                minData.push(val);
            }

        }

        int pop() {
            int ret = allData.pop();
            if (ret == minData.peek()) {
                minData.pop();
            }
            return ret;
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return allData.peek();
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return minData.peek();
            }
        }
    }

    //    push 10
//    push 20
//    push 5
//    push 8
//    push 2
//    push 4
//    push 11
//    top
//    min
//    pop
//    top
//    min
//    pop
//    top
//    min
//    pop
//    top
//    min
//    pop
//    top
//    min
//    pop
//    top
//    min
//    pop
//    top
//    min
//    pop
//    quit
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
