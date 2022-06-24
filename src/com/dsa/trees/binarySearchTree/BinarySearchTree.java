package com.dsa.trees.binarySearchTree;


import java.io.*;

public class BinarySearchTree {

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
        // node self wortarget
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

    public static int size(Node node) {
        // write your code here
        if (node == null) return 0;
        int ls = size(node.left);
        int rs = size(node.right);

        return ls + rs + 1;
    }

    public static int sum(Node node) {

        if (node == null) return 0;
        int ls = sum(node.left);
        int rs = sum(node.right);
        int sum = ls + rs + node.data;


        return sum;
    }

    public static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }


//      alt.  approach
//        if (node == null) return Integer.MIN_VALUE;
//
//        int m = max(node.right);
//
//        return Math.max(m, node.data);
    }

    public static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }

        // alt. approach
//        if (node == null) return Integer.MAX_VALUE;
//
//        int m = min(node.left);
//
//        return Math.min(m, node.data);
//    }
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    public static Node add(Node node, int data) {
        if (node == null) return new Node(data, null, null);
        if (data < node.data) {
            node.left = add(node.left, data);
        } else if (data > node.data) {
            node.right = add(node.right, data);
        }

        return node;
    }

    public static Node remove(Node node, int data) {
        if (node == null) return null;

        if (data < node.data) {
            node.left = remove(node.left, data);
        } else if (data > node.data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left != null && node.right != null) {
                int lm = max(node.left);
                node.data = lm;
                node.left = remove(node.left, lm);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    static int sum = 0;

    public static void rwsol(Node node) {
        if (node == null) return;

        rwsol(node.right);
        int od = node.data;
        node.data = sum;
        sum += od;
        rwsol(node.left);
    }

    public static int lca(Node node, int d1, int d2) {
        if (d1 < node.data && d2 < node.data) {
            return lca(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            return lca(node.right, d1, d2);
        } else {
            return node.data;
        }
    }

    public static void pir(Node node, int d1, int d2) {

        if (node == null) return;

        if (node.data < d1 && node.data < d2) {
            pir(node.left, d1, d2);
        } else if (node.data > d1 && node.data > d2) {
            pir(node.right, d1, d2);
        } else {
            pir(node.left, d1, d2);
            System.out.println(node.data);
            pir(node.right, d1, d2);
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
//        int data2 = Integer.parseInt(br.readLine());


    }
}
