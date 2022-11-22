package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.*;

public class BottomView {
    static class Node {
        Node left;
        Node right;
        int hd;
        int data;

        Node(int data) {
            this.data = data;
            this.hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        System.out.println(bottomView(root));
    }

    public static ArrayList<Integer> bottomView(Node root) {
        if (root == null) return new ArrayList<>();

        ArrayDeque<Node> que = new ArrayDeque<>();
        Map<Integer,Integer> map = new TreeMap<>();
        root.hd = 0;
        que.add(root);

        while (!que.isEmpty()){

            Node temp = que.removeFirst();
            int hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null){
                temp.left.hd = hd-1;
                que.addLast(temp.left);
            }
            if (temp.right != null){
                temp.right.hd= hd+1;
                que.addLast(temp.right);
            }
        }

        return new ArrayList<>(map.values());
    }
}
