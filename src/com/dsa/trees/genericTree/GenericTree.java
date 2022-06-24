package com.dsa.trees.genericTree;

import java.util.*;

public class GenericTree {
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    // d(10) -> 10 will print itself and its family
    // d(20) , d(30) , d(40) will print themselves and their families
    // d(10) = s(10) + d(20) + d(30) + d(40)
    public static void display(Node node) {
        String str = node.data + "-> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }


    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;
        for (Node child : node.children) {
            int cs = size(child);
            s = s + cs;
        }
        s = s + 1;

        return s;
    }

    public static int max(Node node) {
        int maximum = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int cm = max(child);
            maximum = Math.max(cm, maximum);
        }
        maximum = Math.max(node.data, maximum);
        return maximum;
    }

    public static int height(Node node) {
        int hgt = -1;
        for (Node child : node.children) {
            int heightofchild = height(child);
            hgt = Math.max(heightofchild, hgt);
        }
        hgt++;
        return hgt;
    }

    public static void traversals(Node node) {
        // area 1 -> eulers left, on the way deep in the recursion, node's pre area
        System.out.println("Node Pre " + node.data); // euler
        for (Node child : node.children) {
            System.out.println("Edge pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge pre " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
        // area 2 -> eulers right, on the way out of recursion , node's post area
    }

    public static void levelOrder(Node node) {

        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        while (que.size() > 0) {
            node = que.remove();
            System.out.print(node.data + " ");

            que.addAll(node.children);
        }
        System.out.println(".");
    }

    public static void levelOrderLinewise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        mq.add(node);
        while (mq.size() > 0) {

            node = mq.remove();
            System.out.print(node.data + " ");

            cq.addAll(node.children);

            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void levelOrderLinewise2(Node node) {
        Queue<Node> mq = new LinkedList<>();
        mq.add(node);
        mq.add(new Node(-1));

        while (mq.size() > 0) {
            node = mq.remove();
            if (node.data != -1) {
                System.out.print(node.data + " ");
                mq.addAll(node.children);
            } else {
                if (mq.size() > 0) {
                    mq.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    public static void levelOrderLinewise3(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while (mq.size() > 0) {
            int cicl = mq.size();
            for (int i = 0; i < cicl; i++) {
                node = mq.remove();
                System.out.println(node.data + " ");

                for (Node child : node.children) {
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }

    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrderLinewise4(Node node) {
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(node, 1));

        int level = 1;
        while (mq.size() > 0) {
            Pair p = mq.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }
            System.out.println(p.node.data + " ");
            for (Node child : p.node.children) {
                Pair cp = new Pair(child, p.level + 1);
                mq.add(cp);
            }
        }
    }

    public static void levelOrderLinewiseZZ(Node node) {
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
//        Stack<Node> hs = new Stack<>();
//        boolean flag = true;
        int level = 1;
        ms.add(node);
        while (ms.size() > 0) {
            node = ms.pop();
            System.out.print(node.data + " ");

            // 1st approach with 3rd KDistanceHelper stack
//            if (flag) {
//                for (Node child : node.children) {
//                    cs.add(child);
//                }
//            } else {
//                hs.addAll(node.children);
//                while (hs.size() > 0) {
//                    cs.add(hs.pop());
//                }
//            }
            if (level % 2 == 1) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
//                flag = !flag;
            }
        }
    }

    public static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }
        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node sLastChild = node.children.get(node.children.size() - 1);
            Node sLastTail = getTail(sLastChild);
            sLastTail.children.add(lastChild);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    public static Node linearize2(Node node) {
        if (node.children.size() == 0) return node;

        Node lastKeyTail = linearize2(node.children.get(node.children.size() - 1));

        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node sLast = node.children.get(node.children.size() - 1);
            Node sLastKeyTail = linearize2(sLast);
            sLastKeyTail.children.add(last);
        }
        return lastKeyTail;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            boolean fic = find(child, data);
            if (fic) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
//        j++;
        return p1.get(i);

    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        return ++i + ++j;
    }

    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if (!areSimilar(c1, c2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if (!areMirror(c1, c2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }


}
