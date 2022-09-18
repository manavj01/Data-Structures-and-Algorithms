package com.dsa.striver30daysSheet.d14_StackAndQueues2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        System.out.println(prevSmaller(arr));
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int min = A.get(0);
        Stack<Integer> stack = new Stack<>();
        stack.push(min);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);

        for (int i = 1; i < A.size(); i++) {

            if (stack.peek() < A.get(i)) {
                res.add(stack.peek());
            } else {
                while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    res.add(stack.peek());
                } else {
                    res.add(-1);
                }
            }
            stack.push(A.get(i));
        }

        return res;
    }
}
