package com.dsa.striver30daysSheet.d13_StacksAndQueues1;

import java.util.Stack;

public class ImplementQueuesUsingStacks {
    static class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.size() == 0 && output.size() == 0;
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println("popping ->" + obj.pop());
        obj.push(5);
        System.out.println("popping ->" + obj.pop());
        System.out.println("popping ->" + obj.pop());
        System.out.println("popping ->" + obj.pop());
        System.out.println("popping ->" + obj.pop());

    }
}
