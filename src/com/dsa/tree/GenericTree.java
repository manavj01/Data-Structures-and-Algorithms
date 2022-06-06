package com.dsa.tree;

import java.io.*;
import java.util.*;

public class GenericTree {
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // d(10) -> 10 will print itself and its family
    // d(20) , d(30) , d(40) will print themselves and their families
    // d(10) = s(10) + d(20) + d(30) + d(40)
    public static void display(Node node) {
        String str = node.data + "-> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }


    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;
        for (Node child : node.children) {
            int cs = size(child);
            s = s + cs;
        }
        s = s + 1;

        return s;
    }

    public static int max(Node node) {
        int maximum = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int cm = max(child);
            maximum = Math.max(cm, maximum);
        }
        maximum = Math.max(node.data, maximum);
        return maximum;
    }

    public static int height(Node node) {
        int hgt = -1;
        for (Node child : node.children) {
            int heightofchild = height(child);
            hgt = Math.max(heightofchild,hgt);
        }
        hgt++;
        return hgt;
    }


}
