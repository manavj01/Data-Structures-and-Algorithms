package com.dsa.trees.binarySearchTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class TargetSumPair {
    public static class Node {
        Integer data;
        Node left;
        Node right;

        Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        // node self work
        if (node == null) {
            return;
        }
        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node construct(int[] arr, Integer lo, Integer hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;

        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);

        Node node = new Node(data, lc, rc);

        return node;
    }

    public static void targetSumPair(Node node, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        targetSumPairHelper(node, list);

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            int val1 = list.get(i);
            int val2 = list.get(j);
            if (val1 + val2 == target) {
                System.out.println(val1 + " " + val2);
                i++;
                j--;
            } else if (val1 + val2 < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    public static void targetSumPairHelper(Node root, ArrayList<Integer> list) {

        if (root == null) return;

        targetSumPairHelper(root.left, list);
        list.add(root.data);
        targetSumPairHelper(root.right, list);

    }

    public static class ITPair {
        Node node;
        int state = 0;

        ITPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void bestApproach(Node node, int tar) {

        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();

        ls.push(new ITPair(node, 0));
        rs.push(new ITPair(node, 0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while (left.data < right.data) {
            if (left.data + right.data < tar) {
                left = getNextFromNormalInorder(ls);

            } else if (left.data + right.data > tar) {
                right = getNextFromReverseInorder(rs);
            } else {
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }

    }

    public static Node getNextFromNormalInorder(Stack<ITPair> st) {

        while (st.size() > 0) {
            ITPair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;

            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        return null;
    }

    public static Node getNextFromReverseInorder(Stack<ITPair> st) {

        while (!st.isEmpty()) {
            ITPair top = st.peek();
            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;

            } else if (top.state == 1) {
                if (top.node.left != null) {
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {12, 25, 40, 50, 60, 75, 87};
//        Integer[] arr1 = {12, 25, 37, , 50, null, null, 62, 75, null, null, 87, null, null};
        Node root = construct(arr, 0, arr.length - 1);
//        display(root);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("inp");
        int data = Integer.parseInt(br.readLine());
//        int data2 = Integer.parseInt(br.readLine());


//        targetSumPair(root, data);
        bestApproach(root, data);
    }
}
