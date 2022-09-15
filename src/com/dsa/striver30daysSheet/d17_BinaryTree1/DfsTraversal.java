package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsTraversal {
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

    public List<Integer> dfs(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        DFSInorderHelp(root, list);
        return list;

    }

    public static void DFSInorderHelp(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            DFSInorderHelp(root.left, list);
            list.add(root.val);
            DFSInorderHelp(root.right, list);
        }
    }

    public static void DFSPreorderHelp(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            DFSInorderHelp(root.left, list);
            DFSInorderHelp(root.right, list);
        }
    }

    public static void DFSPostorderHelp(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            DFSInorderHelp(root.left, list);
            DFSInorderHelp(root.right, list);
            list.add(root.val);
        }
    }



}
