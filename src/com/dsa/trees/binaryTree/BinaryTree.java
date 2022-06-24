package com.dsa.trees.binaryTree;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
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

//    static int s = 0;

    public static int size(Node node) {
        // write your code here
        // aproach 1
        if (node == null) return 0;

        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;

        // aproach 2
//        if (node == null) {
//            return s;
//        }
//        s++;
//        size(node.left);
//        size(node.right);
//
//        return s;
    }

//    static int sum = 0;

    public static int sum(Node node) {
        // aproach 1
        if (node == null) return 0;
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;

        // aproach 2
        //        if (node == null) {
//            return sum;
//        }
//        sum += node.data;
//        sum(node.left);
//        sum(node.right);
//
//        return sum;

    }

    static int max = Integer.MIN_VALUE;

    public static int max(Node node) {
        // aproach 1
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));

        return tm;

        // aproach 2
//        if (node == null) {
//            return max;
//        }
//        if (max < node.data) {
//            max = node.data;
//        }
//        max(node.left);
//        max(node.right);
//
//        return max;
    }

//    static int hgt = -1;

    public static int height(Node node) {
        // write your code here
        if (node == null) {
            return -1;
        }
        // aproach 1
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;


// aproach 2
//        int h = Math.max(height(node.left),height(node.right));
//        return h + 1;
    }

    public static void traversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data + " in preorder"); // euler left -> pre
        traversal(node.left);
        System.out.println(node.data + " in inorder");// euler between -> In
        traversal(node.right);
        System.out.println(node.data + " in postorder");// euler right -> post

    }

    public static void levelOrder(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while (mq.size() > 0) {
            int count = mq.size();
            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }


    public static void iterativePrePostInTraversal(Node node) {
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        Pair rtp = new Pair(node, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) {
                pre.append(top.node.data).append(" ");
                top.state++;
                if (st.peek().node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            } else if (top.state == 2) {
                in.append(top.node.data).append(" ");
                top.state++;
                if (st.peek().node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            } else {
                post.append(top.node.data).append(" ");
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    public static boolean find(Node node, int data) {

        if (node == null) return false;

        if (node.data == data) return true;

        boolean filc = find(node.left, data);
        if (filc) return true;

        boolean firc = find(node.right, data);
        if (firc) return true;

        return false;
    }

    static ArrayList<Integer> path = new ArrayList<>();

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) return new ArrayList<>();

        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> LList = nodeToRootPath(node.left, data);
        if (LList.size() > 0) {
            LList.add(node.data);
            return LList;
        }
        ArrayList<Integer> RList = nodeToRootPath(node.right, data);
        if (RList.size() > 0) {
            RList.add(node.data);
            return RList;
        }

        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node == null || k < 0) return;
        if (k == 0) System.out.print(node.data + " ");
        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static ArrayList<Integer> KDistance(Node node, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        return KDistanceHelper(node, list, k);

    }

    public static ArrayList<Integer> KDistanceHelper(Node node, ArrayList<Integer> list, int k) {
        if (k == 0) {
            list.add(node.data);
            return list;
        }
        if (node == null || k < 0) {
            return list;
        }

        KDistanceHelper(node.left, list, k - 1);
        KDistanceHelper(node.right, list, k - 1);

        return list;
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path + node.data + " ", +sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static Node createLeftCloneTree(Node node) {
        // write your code here
        if (node == null) return null;
        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);

        Node nn = new Node(node.data, lcr, null);
        node.left = nn;
        node.right = rcr;


        return node;
    }

    public static Node transformBackLeftClonedTree(Node node) {
        if (node == null) return null;

        Node lnn = transformBackLeftClonedTree(node.left.left);
        Node rnn = transformBackLeftClonedTree(node.right);

        node.left = lnn;
        node.right = rnn;

        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) return;

        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        } else if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node) {
        if (node == null) return null;

        if (node.left == null && node.right == null) return null;

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    static int tilt = 0;

    public static int tilt(Node node) {
        if (node == null) return 0;

        int ls = tilt(node.left);

        int rs = tilt(node.right);

        int ltilt = Math.abs(ls - rs);

        tilt += ltilt;

        int ts = ls + rs + node.data;
        return ts;
    }

    public static int tilt2(Node root) {
//code here
        int[] ans = {0};
        tilt2helper(ans, root);
        return ans[0];
    }


    public static int tilt2helper(int[] ans, Node node) {
        if (node == null)
            return 0;
        int ls = tilt2helper(ans, node.left);
        int rs = tilt2helper(ans, node.right);
        int t = ls + rs + node.data;
        ans[0] += Math.abs(ls - rs);
        return t;
    }

    public static class BSTPair {
        boolean isBst;
        int min;
        int max;
    }

    public static boolean isBst(Node node) {
        BSTPair helper = isBstHelper(node);
        return helper.isBst;
    }

    public static BSTPair isBstHelper(Node node) {
        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBst = true;
            return bp;
        }

        BSTPair lp = isBstHelper(node.left);
        BSTPair rp = isBstHelper(node.right);

        BSTPair mp = new BSTPair();
        mp.isBst = lp.isBst && rp.isBst && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        return mp;
    }

    public static boolean isBstBestApproach(Node root) {
        Stack<Node> st = new Stack<>();
        Node pre = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (pre != null && pre.data >= root.data) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    static boolean isBal = true;

    public static int isBalanced(Node node) {
        if (node == null) return 0;

        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);

        int gap = Math.abs(lh - rh);
        if (gap > 1) {
            isBal = false;
        }

        int th = Math.max(lh, rh) + 1;

        return th;
    }

    public static class BalPair {
        int ht;
        boolean isBal;

        BalPair() {
        }

        BalPair(int ht, boolean isBal) {
            this.ht = ht;
            this.isBal = isBal;
        }
    }

    public static BalPair isBal(Node node) {
        if (node == null) {
            BalPair bp = new BalPair(0, true);
            return bp;
        }

        BalPair lp = isBal(node.left);
        BalPair rp = isBal(node.right);

        BalPair mp = new BalPair();
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht, rp.ht);

        return mp;
    }

    public static void main(String[] args) throws IOException {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr1 = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr2 = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        Integer[] arr3 = {50, 50, 25, 25, 12, 12, null, null, null, null, 37, 37, 30, 30, null, null, null, null, null, null, 75, 75, 62, 62, null, null, 70, 70, null, null, null, null, 87, 87, null, null, null};
        Integer[] arr4 = {2, 1, null, null, 3, null, null};
        Integer[] arr5 = {4, 2, 3, null, null, 5, null, null, 9, null, 7, null, null};
        Integer[] arr6 = {5, 1, null, null, 4, 3, null, null, 6, null, null};
        Integer[] arr7 = {2, 2, null, null, 2, null, null};
        Node root = construct(arr);


//        isBalanced(root);
//        System.out.println(isBal);
        System.out.println(isBal(root).isBal);
//        display(root);
    }
}
