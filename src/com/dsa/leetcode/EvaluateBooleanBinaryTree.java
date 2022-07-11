package com.dsa.leetcode;

public class EvaluateBooleanBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static boolean evaluateTree(TreeNode root) {
        if (root == null) return false;
        else if (root.left == null && root.right == null) return false;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2? left|right : left&right;

    }

}
