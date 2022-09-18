package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {
    static class TreeNode {
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
        System.out.println(IterativeTraversals(root));

    }

    static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.state = level;
        }
    }

    public static List<List<Integer>> IterativeTraversals(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> In = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        Pair rootPair = new Pair(root, 1);
        stack.push(rootPair);

        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                pre.add(top.node.val);
                top.state++;
                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    stack.push(lp);
                }
            } else if (top.state == 2) {
                In.add(top.node.val);
                top.state++;
                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    stack.push(rp);
                }
            } else {
                post.add(top.node.val);
                stack.pop();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(pre));
        res.add(new ArrayList<>(In));
        res.add(new ArrayList<>(post));
        return res;
    }

    public static List<Integer> iterative2ndApproach(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
