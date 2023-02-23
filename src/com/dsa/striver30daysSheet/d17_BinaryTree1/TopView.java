package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TopView {
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
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);

        System.out.println(topView(root));
    }

    static class Pair {
        Node node;
        int vd;

        Pair(Node node, int vd) {
            this.node = node;
            this.vd = vd;
        }
    }

    public static ArrayList<Integer> topView(Node root) {

        ArrayDeque<Pair> que = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        que.add(new Pair(root, 0));

        while (!que.isEmpty()) {
            Pair p = que.removeFirst();
            Node temp = p.node;
            int vd = p.vd;
            if (!map.containsKey(vd)) {
                map.put(vd, temp.data);
            }
            if (temp.left != null) {
                que.addLast(new Pair(temp.left, vd - 1));
            }
            if (temp.right != null) {
                que.addLast(new Pair(temp.right, vd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }
}
