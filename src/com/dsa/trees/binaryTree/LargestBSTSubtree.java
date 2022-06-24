package com.dsa.trees.binaryTree;

import java.io.IOException;
import java.util.Stack;

public class LargestBSTSubtree {
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

    public static class BalPair {
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;

    }
    public static BalPair isBal(Node node){
        if (node == null){
            BalPair bp = new BalPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            bp.root = null;
            bp.size=0;
            return bp;
        }

        BalPair lp = isBal(node.left);
        BalPair rp = isBal(node.right);

        BalPair mp = new BalPair();
        mp.isBST = lp.isBST && rp.isBST && (node.data > lp.max && node.data < rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max,rp.max));

        if (mp.isBST){
            mp.root = node;
            mp.size = lp.size + rp.size+1;
        }else if(lp.size > rp.size){
            mp.root = lp.root;
            mp.size = lp.size;
        }else{
            mp.root = rp.root;
            mp.size = rp.size;
        }

        return mp;
    }

    public static void main(String[] args) throws IOException {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr1 = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr2 = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        Integer[] arr3 = {50, 50, 25, 25, 12, 12, null, null, null, null, 37, 37, 30, 30, null, null, null, null, null, null, 75, 75, 62, 62, null, null, 70, 70, null, null, null, null, 87, 87, null, null, null};
        Integer[] arr4 = {2,1,null,null,3,null,null};
        Integer[] arr5 ={4,2,3,null,null,5,null,null,9,null,7,null,null};
        Integer[] arr6 = {5,1,null,null,4,3,null,null,6,null,null};
        Integer[] arr7 = {2,2,null,null,2,null,null};
        Integer[] arr8 = {8,11,10,9,null,null,4,null,null,null,1,1,null,null,6,null,null};
        Node root = construct(arr8);

        BalPair res =  isBal(root);
        System.out.println(res.root.data + "@" + res.size);
    }
}
