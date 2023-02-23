package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.LinkedList;

public class MaxWidthOfBinaryTree {
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
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(widthOfBinaryTree(root));
    }

    public static class pair {
        TreeNode node = null;
        int idx = 0;

        pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<pair> que = new LinkedList<>();
        int max = 0;

        que.addLast(new pair(root, 0));
        while (!que.isEmpty()) {
            int size = que.size();
            int lm = que.getFirst().idx;
            int rm = que.getFirst().idx;

            while (size-- > 0) {
                pair rp = que.removeFirst();
                rm = rp.idx;
                if (rp.node.left != null) que.addLast(new pair(rp.node.left, rp.idx * 2 + 1));
                if (rp.node.right != null) que.addLast(new pair(rp.node.right, rp.idx * 2 + 2));
            }
            max = Math.max(max, rm - lm + 1);
        }

        return max;
    }
}
