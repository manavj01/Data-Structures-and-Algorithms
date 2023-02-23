package com.dsa.striver30daysSheet.d18_BinaryTree2;

import java.util.ArrayDeque;

public class Height {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }
//     bfs
     public int maxDepth1(TreeNode root) {
         if(root == null) return 0;
         ArrayDeque<TreeNode> dque = new ArrayDeque<>();
         dque.addLast(root);
         int level =0;
         while(!dque.isEmpty()){
             int size = dque.size();

             for(int i=0; i<size; i++){
                 TreeNode parent = dque.pollFirst();

                 if(parent.left != null){
                     dque.addLast(parent.left);
                 }
                 if(parent.right != null){
                     dque.addLast(parent.right);
                 }
             }
             level++;
         }


         return level;
     }
}
