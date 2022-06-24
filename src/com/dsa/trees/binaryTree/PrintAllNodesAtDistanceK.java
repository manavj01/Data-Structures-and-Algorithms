package com.dsa.trees.binaryTree;

import java.util.*;

public class PrintAllNodesAtDistanceK {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);

        Stack<Pair> st = new Stack<>();

        Pair rtp = new Pair(root, 1);

        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;

            } else if (top.state == 2) {
//                idx++;
                if (arr[++idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;

            } else {
                st.pop();
            }
        }
        return root;
    }


    static List<Node> path;

    public static List<Integer> distanceK(Node root, Node target, int K) {
        path = new ArrayList<>();
        findPathAndPrint(root, target);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            printKLevelsDown(path.get(i), K - i, result, i == 0 ? null : path.get(i - 1));
        }
        //Returning list of all nodes at a distance K
        return result;
    }

    // Blocker is used for ancestors node if target at
    //left then we have to go in right or if target atj
    // right then we have to go in left.
    public static void printKLevelsDown(Node node, int dist, List<Integer> result, Node blocker) {
        if (dist < 0 || node == null || (blocker != null && node == blocker)) {
            return;
        }

        if (dist == 0) {
            result.add(node.data);
        }

        printKLevelsDown(node.left, dist - 1, result, blocker);
        printKLevelsDown(node.right, dist - 1, result, blocker);
    }

    //Finding the path of target node from root node
    public static boolean findPathAndPrint(Node node, Node target) {
        if (node == null)
            return false;

        if (node == target || findPathAndPrint(node.left, target) || findPathAndPrint(node.right, target)) {
            path.add(node);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr1 = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
        Node target = root.left.right;
        List<Integer> res = distanceK(root, target, 2);
        System.out.println(res);
    }
}
