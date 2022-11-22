package com.dsa.striver30daysSheet.d19_BinaryTree3;

public class CheckForChildrenSumProperty {
    public static void main(String[] args) {

    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void changeTree(Node root) {
        int childSum = 0;
        if (root == null) return;
        if (root.left != null) {
            childSum += root.left.data;
        }
        if (root.right != null) {
            childSum += root.right.data;
        }

        if (childSum > root.data) {
            root.data = childSum;
        } else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int totalSum = 0;

        if (root.left != null) totalSum += root.left.data;
        if (root.right != null) totalSum += root.right.data;
        if (root.left != null || root.right != null) root.data = totalSum;


    }
}
