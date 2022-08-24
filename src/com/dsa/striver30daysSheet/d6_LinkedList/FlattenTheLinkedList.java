package com.dsa.striver30daysSheet.d6_LinkedList;


public class FlattenTheLinkedList {
    public static class Node {
        int data;
        Node next;
        Node bottom;

        Node() {
        }

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public static Node flatten(Node head) {
        if (head == null || head.next == null) return head;
        // recurse for list on right
        head.next = flatten(head.next);

        // now merge
        head = mergeTwoLists(head, head.next);

        return head;
    }

    public static Node mergeTwoLists(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) {
            temp.bottom = a;
        } else temp.bottom = b;

        return res.bottom;
    }
}
