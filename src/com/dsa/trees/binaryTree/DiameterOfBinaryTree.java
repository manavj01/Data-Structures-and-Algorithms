package com.dsa.trees.binaryTree;

import java.io.IOException;
import java.util.Stack;

public class DiameterOfBinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
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

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);

        Stack<Pair> st = new Stack<>();

        Pair rtp = new Pair(root, 1);

        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;

            } else if (top.state == 2) {
//                idx++;
                if (arr[++idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;

            } else {
                st.pop();
            }
        }
        return root;
    }

    public static int height(Node node) {
        // write your code here
        if (node == null) {
            return -1;
        }
        // aproach 1
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;


// aproach 2
//        int h = Math.max(height(node.left),height(node.right));
//        return h + 1;
    }

    public static int diameter1(Node node){
        if (node == null) return 0;

        // maximum distance between two node of lhs
        int ld = diameter1(node.left) ;
        // maximum distance between two node of rhs
        int rd = diameter1(node.right) ;
        // maximum distance between left's deepest and right's deepest
        int f = height(node.left) + height(node.right) + 2;

        return Math.max(ld,Math.max(rd,f));
    }
    static class DiaPair{
        int ht;
        int dia;
    }
    public static DiaPair diameter2(Node node){
        if (node == null){
            DiaPair base = new DiaPair();
            base.ht = -1;
            base.dia = 0;
            return base;
        }

        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht,rp.ht)+1;

        int factEitherSide = lp.ht + rp.ht + 2;
        mp.dia = Math.max(factEitherSide,Math.max(lp.dia, rp.dia));

        return mp;
    }
    public static void main(String[] args) throws IOException {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr1 = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr2 = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        Integer[] arr3 = {50, 50, 25, 25, 12, 12, null, null, null, null, 37, 37, 30, 30, null, null, null, null, null, null, 75, 75, 62, 62, null, null, 70, 70, null, null, null, null, 87, 87, null, null, null};
        Integer[] arr4 ={10,20,40,null,null,60,null,null,30,null,null};
        Node root = construct(arr4);

        DiaPair dp =  diameter2(root);
        System.out.println(dp.dia);

//        display(root);
    }
}
