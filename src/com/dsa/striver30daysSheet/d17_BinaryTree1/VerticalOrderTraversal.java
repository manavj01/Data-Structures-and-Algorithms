package com.dsa.striver30daysSheet.d17_BinaryTree1;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(verticalTraversal(root));
    }

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

    public static class vPair {
        TreeNode node;
        int vl;
        int hl;

        vPair(TreeNode node, int hl, int vl) {
            this.node = node;
            this.vl = vl;
            this.hl = hl;
        }

    }

    public static void width(TreeNode root, int hl, int[] width) {
        if (root == null) {
            return;
        }

        width[0] = Math.min(width[0], hl);
        width[1] = Math.max(width[1], hl);

        width(root.left, hl - 1, width);
        width(root.right, hl + 1, width);
    }

    public static List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<vPair> que = new LinkedList<>();

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        for (int i = 0; i < len; i++) res.add(new ArrayList<>());
        vPair rtp = new vPair(root, Math.abs(minMax[0]), 0);
        que.addLast(rtp);
        while (!que.isEmpty()) {
            int size = que.size();
            que.sort((o1, o2) -> {
                if (o1.hl < o2.hl) {
                    return 1;
                } else if (o1.hl > o2.hl) {
                    return -1;
                } else {
                    return Integer.compare(o1.node.val, o2.node.val);
                }
            });
            while (size-- > 0) {
                vPair rp = que.removeFirst();

                int hl = rp.hl;
                TreeNode node = rp.node;

                res.get(hl).add(node.val);
                if (node.left != null) {
                    que.addLast(new vPair(node.left, rp.hl - 1, rp.vl + 1));
                }
                if (node.right != null) {
                    que.addLast(new vPair(node.right, rp.hl + 1, rp.vl + 1));

                }
            }
        }

        return res;
    }

    public static class Pair {
        TreeNode node;
        int vl;
        int hl;

        Pair(TreeNode node, int hl, int vl) {
            this.node = node;
            this.vl = vl;
            this.hl = hl;
        }

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        PriorityQueue<Pair> que = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.hl < o2.hl) {
                        return -1;
                    } else if (o1.hl > o2.hl) {
                        return 1;
                    } else {
                        return Integer.compare(o1.node.val, o2.node.val);
                    }
                }
        );
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        que.add(new Pair(root, 0, 0));

        int minvl = 0;
        int maxvl = 0;

        while (!que.isEmpty()) {
            Pair p = que.poll();
            TreeNode node = p.node;
            int vl = p.vl;
            int hl = p.hl;
            minvl = Math.min(minvl, vl);
            maxvl = Math.max(maxvl, vl);

            map.putIfAbsent(vl, new ArrayList<>());
            map.get(vl).add(node.val);

            if (node.left != null) {
                que.add(new Pair(node.left, vl - 1, hl + 1));
            }

            if (node.right != null) {
                que.add(new Pair(node.right, vl + 1, hl + 1));
            }
        }

        for (int i = minvl; i <= maxvl; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
