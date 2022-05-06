package com.dsa.stackAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();

        //1 - [(a + b) + {(c + d) * (e / f)}] -> true
        //2 - [(a + b) + {(c + d) * (e / f)]} -> false
        //3 - [(a + b) + {(c + d) * (e / f)} -> false
        //4 - ([(a + b) + {(c + d) * (e / f)}] -> false
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                boolean flag = handleClosing(st, '(');
                if (!flag) {
                    System.out.println(false);
                    return;
                }
            } else if (ch == '}') {
                boolean flag = handleClosing(st, '{');
                if (!flag) {
                    System.out.println(false);
                    return;
                }
            } else if (ch == ']') {
                boolean flag = handleClosing(st, '[');
                if (!flag) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(st.size() == 0);
    }

    public static boolean handleClosing(Stack<Character> st, char correspondingOpeningChar) {
        if (st.size() == 0) {
            return false;
        } else if (st.peek() != correspondingOpeningChar) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}
