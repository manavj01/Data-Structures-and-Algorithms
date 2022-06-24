package com.dsa.trees.genericTree;

import java.io.*;
import java.util.*;

public class GenericTreeIterator {
    public static class GenericTree implements Iterable<Integer> {
        Node root;

        GenericTree(Node root) {
            this.root = root;
        }

        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }

    public static class GTPreorderIterator implements Iterator<Integer> {
        Integer nVal;
        Stack<Pair> st;

        public GTPreorderIterator(Node root) {
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }

        public boolean hasNext() {
            if (nVal == null) return false;
            else return true;
        }

        public Integer next() {
            Integer fr = nVal;
            // moves nVal forward , if not possible sets it to null
            nVal = null;
            while (st.size() > 0) {
                Pair top = st.peek();
                if (top.state == -1) {
                    nVal = top.node.data;
                    top.state++;
                    break;
                } else if (top.state == top.node.children.size()) {
                    st.pop();
                } else {
                    Pair cp = new Pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;
                }
            }


            return fr;
        }
    }

    private static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        StringBuilder str = new StringBuilder(node.data + "-> ");
        for (Node child : node.children) {
            str.append(child.data).append(", ");
        }
        str.append(".");
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);

        GenericTree gt = new GenericTree(root);

        for (int val : gt) { // syntactical sugar dependent on Iterable
            System.out.println(val);
        }

//        Iterator<Integer> gti = gt.iterator();
//        while (gti.hasNext()) {
//            System.out.println(gti.next());
//        }
    }
}
