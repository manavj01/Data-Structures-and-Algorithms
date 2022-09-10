package com.dsa.striver30daysSheet.d13_StacksAndQueues1;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    static class MyStack1 {
        Queue<Integer> stack1;
        Queue<Integer> stack2;

        public MyStack1() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            stack1.add(x);
        }

        public int pop() {
            while (stack1.size() != 1) {
                stack2.add(stack1.poll());
            }
            int ret = stack1.poll();
            for (int i = stack2.size() - 1; i >= 0; i--) {
                stack1.add(stack2.poll());
            }
            return ret;
        }

        public int top() {
//            int len = stack1.size();
            for (int i = stack1.size() - 1; i > 0; i--) {
                stack2.add(stack1.poll());
            }
            int ret = stack1.peek();
            stack2.add(stack1.poll());
            for (int i = stack2.size() - 1; i >= 0; i--) {
                stack1.add(stack2.poll());
            }
            return ret;
        }

        public boolean empty() {
            if (stack1.size() != 0) {
                return false;
            }
            return true;
        }
    }

    static class MyStack {
        Queue<Integer> stack;

        public MyStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            int s = stack.size();
            stack.add(x);
            for (int i = 0; i < s; i++) {
                int y = stack.remove();
                stack.add(y);
            }
        }

        public int pop() {
            return stack.remove();
        }

        public int top() {

            return stack.peek();
        }

        public boolean empty() {
            return stack.size() == 0;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
