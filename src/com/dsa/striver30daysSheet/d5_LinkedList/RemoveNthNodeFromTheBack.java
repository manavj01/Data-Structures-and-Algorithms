package com.dsa.striver30daysSheet.d5_LinkedList;

public class RemoveNthNodeFromTheBack {
    public Node removeNthFromEnd(Node head, int n) {

        Node dummy = new Node();
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

    public Node removeNthFromEnd1(Node head, int n) {
        if (head.next == null) return null;

        int c = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            c++;
        }

        Node trav = head;

        int dIdx = c - n - 1;

        if (dIdx == -1) {
            return head = head.next;
        }

        int idx = 0;

        while (idx != dIdx) {
            trav = trav.next;
            idx++;
        }

        trav.next = trav.next.next;
        return head;
    }
}
