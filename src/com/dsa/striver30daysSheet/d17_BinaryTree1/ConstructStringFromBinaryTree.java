package com.dsa.striver30daysSheet.d17_BinaryTree1;

public class ConstructStringFromBinaryTree {
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
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        visit(root, builder);
        return builder.toString();
    }

    static void visit(TreeNode node, StringBuilder str) {
        str.append(node.val);

        if (node.left == null && node.right == null) return;

        if (node.left != null) {
            str.append("(");
            visit(node.left, str);
            str.append(")");
        } else {
            str.append("()");
        }

        if (node.right != null) {
            str.append("(");
            visit(node.right, str);
            str.append(")");
        }
    }
}
