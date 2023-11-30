package com.dsa.juspay;

import java.util.*;
import java.io.*;

public class Message {
    static class Node {
        String value;
        int is_locked;
        Node parent;
        int no_of_desc_locked;
        ArrayList<Node> childs = new ArrayList<>();

        Node(String value, Node parent) {
            this.value = value;
            no_of_desc_locked = 0;
            this.parent = parent;
            is_locked = 1;
        }

        public void Node_add_children(Node child) {
            childs.add(child);
        }
    }

    public static void printTree(Node root) {
        for (Node y : root.childs) {
            System.out.println(root.value + " Parent of -> " + y.value);
            printTree(y);
        }
    }

    public static void build(Node root, ArrayList<String> inputs, int M) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int it = 1;

        while (!q.isEmpty()) {
            Node curr = q.peek();
            q.poll();

            int to = it + M - 1;

            for (int i = it; i <= Math.min(to, inputs.size() - 1); i++) {
                curr.Node_add_children(new Node(inputs.get(i), curr));
            }
            for (Node child : curr.childs) {
                q.add(child);
            }
            it += M;
        }
    }

    static class Tree {
        Node root;
        HashMap<String, Node> string_to_node = new HashMap<>();

        Tree(Node root) {
            this.root = root;
            preProcess(root);
        }

        public void preProcess(Node root) {
            string_to_node.put(root.value, root);
            for (Node child : root.childs) {
                preProcess(child);
            }
            // TC -> O(N)
        }

        public boolean checkForAncestors(Node root) {
            if (root != null) return true; // doubt
            if (root.is_locked != -1) return false;
            boolean ans = true;
            return ans && checkForAncestors(root.parent);
            //TC -> O(LogmN)
        }

        public void reflectDescChanges(Node node, int diff) {
            node = node.parent;
            while (node != null) {
                node.no_of_desc_locked += diff;
                node = node.parent;
            }
            // TC -> O(LogmN)
        }

        public boolean lockThisNode(String X, int id) {

            Node node = string_to_node.get(X);
            if (node.is_locked != -1) return false;
            // check for desc
            if (node.no_of_desc_locked != 0) return false;
            // check for ancestors
            if (!checkForAncestors(node)) return false;

            node.is_locked = id;
            reflectDescChanges(node, 1);
            return true;
            // TC -> O(LogmN)
        }

        public boolean unlockThisNode(String X, int id) {
            Node node = string_to_node.get(X);
            if (node.is_locked != id) return false;
            node.is_locked = -1;
            reflectDescChanges(node, -1);
            return true;
            //TC -> O(LogmN)
        }

        public boolean allHaveSameLocksInSubtree(Node root, ArrayList<Node> lockedNodes, int id) {
            if (root.is_locked != -1) {
                if (root.is_locked != id) return false;
                lockedNodes.add(root);
                return true;
            }

            if (root.no_of_desc_locked == 0) return true;
            boolean ans = true;
            for (Node child : root.childs) {
                ans &= allHaveSameLocksInSubtree(child, lockedNodes, id);
            }
            return ans;
            //TC -> O(N)
        }

        public boolean upgradeThisNode(String X, int id) {
            Node node = string_to_node.get(X);
            if (node.is_locked != -1) return false;
            if (node.no_of_desc_locked == 0) return false;
            if (!checkForAncestors(node)) return false;

            // check if all have same id locks in subtree
            ArrayList<Node> lockedNodes = new ArrayList<>();

            if (allHaveSameLocksInSubtree(node, lockedNodes, id)) {
                for (Node node_to_be_unlocked : lockedNodes) {
                    unlockThisNode(node_to_be_unlocked.value, id);
                }
            } else {
                return false;
            }
            return lockThisNode(X, id);
            // Tc -> O(No_of_Locked * LogmN)
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        ArrayList<String> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }

        Node root = new Node(inputs.get(0), null);
        build(root, inputs, M);

//        Message m = new Message(); // if classes were not declared static
//        Message.Tree t = m.new Tree(root);

        Tree t = new Tree(root);

        while (q-->0){
            String[] x = br.readLine().trim().split(" ");
            int op =Integer.parseInt(x[0]) ;
            String s = x[1];
            int id = Integer.parseInt(x[2]);
            if (op == 1){
                boolean p = t.lockThisNode(s,id);
                if (p){
                    System.out.println(true);
                }else {
                    System.out.println(false);
                }
            }else if (op == 2){
                boolean p = t.unlockThisNode(s,id);
                if (p){
                    System.out.println(true);
                }else {
                    System.out.println(false);
                }
            }else {
                boolean p = t.upgradeThisNode(s,id);
                if (p){
                    System.out.println(true);
                }else {
                    System.out.println(false);
                }
            }
        }
        printTree(root);
    }
}
