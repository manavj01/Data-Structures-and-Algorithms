package com.dsa.striver30daysSheet.d18_BinaryTree2;

public class CheckForBalancedTree {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(2);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode node) {
        return isBalancedHelper(node) != -1;

    }
    public static int isBalancedHelper(TreeNode root){
        if (root == null) return 0;

        int left = isBalancedHelper(root.left);
        if (left == -1) return -1;
        int right = isBalancedHelper(root.right);
        if (right == -1) return -1;

        if (Math.abs(right-left) > 1) return -1;

        return Math.max(left,right)+1;
    }
}
