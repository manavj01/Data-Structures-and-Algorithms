package com.dsa.striver30daysSheet.d20_BinarySearchTree1;

public class ConstructBinarySearchTreeFromPreorder {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int lo = 0;
        int hi = preorder.length - 1;
        TreeNode root = solve(preorder, lo, hi);

        return root;
    }

    public TreeNode solve(int[] preorder, int lo, int hi) {
        if (lo == hi) {
            return new TreeNode(preorder[lo]);
        }
        if (lo > hi) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[lo]);

        int i = lo + 1;
        for (; i <= hi; i++) {
            if (preorder[lo] < preorder[i]) {
                break;
            }
        }

        root.left = solve(preorder, lo + 1, i - 1);
        root.right = solve(preorder, i, hi);

        return root;
    }
}
