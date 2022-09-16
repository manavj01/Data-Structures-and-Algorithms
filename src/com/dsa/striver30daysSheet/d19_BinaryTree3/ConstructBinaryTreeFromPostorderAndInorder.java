package com.dsa.striver30daysSheet.d19_BinaryTree3;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorder {
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

    public static void main(String[] args) {
        int[] postorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new ConstructBinaryTreeFromPostorderAndInorder().buildTree(postorder, inorder);

    }

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null) return null;
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1,
                inMap);
    }

    public TreeNode helper(int[] postorder, int postS, int postE, int[] inorder, int inS, int inE, Map<Integer, Integer> inMap) {
        if (postS > postE || inS > inE) return null;

        TreeNode root = new TreeNode(postorder[postE]);

        int inorderRootIndex = inMap.get(postorder[postE]);
        int numsLeft = inorderRootIndex - inS;

        root.left = helper(postorder, postS, postS + numsLeft-1,
                inorder, inS, inorderRootIndex - 1, inMap);
        root.right = helper(postorder, postS + numsLeft , postE-1,
                inorder, inorderRootIndex + 1, inE, inMap);

        return root;
    }
}
