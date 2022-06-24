package com.dsa.trees.genericTree;

import java.io.*;
import java.util.*;

public class GenericTreeMultiSolver {

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

    static int size;
    static int min;
    static int max;
    static int height;

    //  these variables are declared outside so they are in heap
// these variables are stored in stack because they are passed as
// parameters in the method
    public static void multisolver(Node node, int depth) {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        for (Node child : node.children) {
            multisolver(child, depth + 1);
        }
    }

    static Node predecessor;
    static Node successor;
    static int state;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
        }
        for (Node child : node.children) {
            predecessorAndSuccessor(child, data);
        }
    }

    static int ceil; // smallest among larger
    static int floor; // largest among smaller

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }

        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static void floorAndCeil(Node node, int data) {
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }

        for (Node child : node.children) {
            floorAndCeil(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            floorAndCeil(node, factor);  // will set floor
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;

    }

    static int msn = 0;
    static int ms = Integer.MIN_VALUE;

    static int retSumAndCalculateMSST(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            int cSum = retSumAndCalculateMSST(child);
            sum += cSum;
        }
        sum += node.data;
        if (sum > ms) {
            msn = node.data;
            ms = sum;
        }
        return sum;
    }

    static int dia = 0;

    static int calculateDiaReturnHeight(Node node) {
        int dch = -1;
        int sdch = -1;

        for (Node child : node.children) {
            int ch = calculateDiaReturnHeight(child);
            if (ch > dch) {
                sdch = dch;
                dch = ch;
            } else if (ch > sdch) {
                sdch = ch;
            }
        }
        int candidate = dch + sdch + 2;

        if (candidate > dia) {
            dia = candidate;
        }
        dch += 1;
        return dch;
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreAndPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == -1) {
                pre.append(top.node.data).append(" ");
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post.append(top.node.data).append(" ");
                st.pop();
            } else {
                Pair cp = new Pair(top.node.children.get(top.state), -1);
                st.push(cp);
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);
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
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
//        multisolver(root, 0);


//        int data = Integer.parseInt(br.readLine());
//        q - predecessorAndSuccessor
//        predecessor = null;
//        successor = null;
//        state = 0;
////        predecessorAndSuccessor(root, data);
//        if (predecessor == null) {
//            System.out.println("Predecessor = Not found");
//        } else {
//            System.out.println("Predecessor = " + predecessor.data);
//        }
//
//        if (successor == null) {
//            System.out.println("Successor = Not found");
//        } else {
//            System.out.println("Successor = " + successor.data);
//        }

        // q - ceil and floor
//        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
//        ceilAndFloor(root, data);
//        System.out.println("CEIL = " + ceil);
//        System.out.println("FLOOR = " + floor);
//        int kthLargest = kthLargest(root, data);
//        System.out.println(kthLargest);
//
//        retSumAndCalculateMSST(root);
//        System.out.println(msn + "@" + ms);

//        calculateDiaReturnHeight(root);
//        System.out.println(dia);

        IterativePreAndPostOrder(root);
    }
}
