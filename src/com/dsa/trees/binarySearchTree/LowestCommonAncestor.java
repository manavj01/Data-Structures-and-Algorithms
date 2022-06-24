package com.dsa.trees.binarySearchTree;

import java.io.*;
import java.util.ArrayList;

public class LowestCommonAncestor {
    public static class Node {
        Integer data;
        Node left;
        Node right;

        Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        // node self work
        if (node == null) {
            return;
        }
        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node construct(int[] arr, Integer lo, Integer hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;

        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);

        Node node = new Node(data, lc, rc);

        return node;
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1 = helper(node, list1, d1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2 = helper(node, list2, d2);
        int lca = 0;
        int i = list2.size();
        while (i != 0) {
            i--;
            if (!list1.get(i).equals(list2.get(i))) {
                break;
            }
        }
        lca = list1.get(++i);
        return lca;
//        System.out.println(list1);
//        System.out.println(list2);
    }

    public static ArrayList<Integer> helper(Node node, ArrayList<Integer> list, int d) {
        if (node == null) return new ArrayList<>();

        if (d > node.data) {
            ArrayList<Integer> RList = helper(node.right, list, d);
            if (RList.size() > 0) {
                RList.add(node.data);
                return RList;
            }
        } else if (d < node.data) {
            ArrayList<Integer> LList = helper(node.left, list, d);
            if (LList.size() > 0) {
                LList.add(node.data);
                return LList;
            }
        } else {
            ArrayList<Integer> nlist = new ArrayList<>();
            nlist.add(node.data);
            return nlist;
        }

        return new ArrayList<>();

    }

    // that was a bad / lengthy approach
    // now this one is good

    public static int lca2(Node node, int d1, int d2) {
        if (d1 < node.data && d2 < node.data) {
            return lca(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            return lca(node.right, d1, d2);
        } else {
            return node.data;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
//        Integer[] arr1 = {12, 25, 37, , 50, null, null, 62, 75, null, null, 87, null, null};
        Node root = construct(arr, 0, arr.length - 1);
//        display(root);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("inp");
        int data = Integer.parseInt(br.readLine());
        int data2 = Integer.parseInt(br.readLine());

        System.out.println(lca(root, data, data2));
    }
}
