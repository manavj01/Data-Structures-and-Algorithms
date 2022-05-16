package com.dsa.stackAndQueues;

import java.io.*;
import java.util.*;

public class PrefixEvaluationAndConversion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Integer> vals = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = vals.pop();
                int v2 = vals.pop();
                int val = operation(v1, v2, ch);
                vals.push(val);

                String infv1 = infix.pop();
                String infv2 = infix.pop();
                String infval = "(" + infv1 + ch + infv2 + ")";
                infix.push(infval);

                String postv1 = postfix.pop();
                String postv2 = postfix.pop();
                String postval = postv1 + postv2 + ch;
                postfix.push(postval);
            } else {
                vals.push(ch - '0');
                postfix.push(ch + "");
                infix.push(ch + "");
            }
        }
        System.out.println("expression val = " + vals.pop());
        System.out.println("Infix expression = " + infix.pop());
        System.out.println("Postfix expression = " + postfix.pop());

    }

    public static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;

        } else if (op == '*') {
            return v1 * v2;

        } else {
            return v1 / v2;
        }
    }
}
