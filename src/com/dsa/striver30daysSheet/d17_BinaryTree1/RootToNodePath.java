package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.ArrayList;

public class RootToNodePath {
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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(solve(root, 5));
    }

    public static ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(A, B, arr);
        return arr;
    }

    public static boolean dfs(TreeNode root, int B, ArrayList<Integer> arr) {
//        if (root == null) {
//            return false;
//        }
//        if (root.val == B) {
//            arr.add(B);
//            return true;
//        }
//
//        arr.add(root.val);
//        boolean left = dfs(root.left, B, arr);
//        boolean right = dfs(root.right, B, arr);
//
//        if (left || right){
//            return true;
//        }else{
//            arr.remove(arr.size() - 1);
//            return false;
//        }
        if (root == null)
            return false;

        // push the node's value in 'arr'
        arr.add(root.val);

        // if it is the required node
        // return true
        if (root.val == B)
            return true;

        // else check whether the required node lies
        // in the left subtree or right subtree of
        // the current node
        if (dfs(root.left,  B,arr) ||
                dfs(root.right, B,arr))
            return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'arr'and then return false
        arr.remove(arr.size() - 1);
        return false;
    }
}