package com.dsa.striver30daysSheet.d20_BinarySearchTree1;

public class ValidateBinarySearchTree {
    public class TreeNode {
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

    public static class Pair {
        long x = Long.MIN_VALUE;
        long y = Long.MAX_VALUE;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        Pair() {
        }
    }

    public boolean isValidBST(TreeNode root) {
        Pair rtp = new Pair();
        return solve(root, rtp);
    }

    public boolean solve(TreeNode root, Pair rtp) {
        if (root == null) return true;

        if (root.val <= rtp.x || root.val >= rtp.y) {
            return false;
        }

        boolean left = solve(root.left, new Pair(rtp.x, root.val));
        boolean right = solve(root.right, new Pair(root.val, rtp.y));

        return left && right;
    }
}
