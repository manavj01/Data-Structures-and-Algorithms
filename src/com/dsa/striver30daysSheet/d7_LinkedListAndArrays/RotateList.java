package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int size = 1;
        ListNode ptr1 = head;
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
            size++;
        }

        k = k % size;
        if (size == 1 || k == 0) return head;

        ListNode ptr2 = head;
        for (int i = 0; i < size - k - 1; i++) {
            ptr2 = ptr2.next;
        }
        ptr1.next = head;
        head = ptr2.next;
        ptr2.next = null;

        return head;
    }
}
