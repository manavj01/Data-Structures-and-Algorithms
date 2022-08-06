package com.dsa.striver30daysSheet.d5_LinkedList;

import java.util.List;

public class ReverseALinkedList {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        for (int i = 1; i < 5; i++) { // creating linked List
            ListNode node = new ListNode(i + 1);
            temp.next = node;
            temp = node;
        }
        temp.next = null;

        ListNode trav = reverseList(head); // calling desired function

        while (trav != null) { // printing linkedList
            System.out.print(trav.val + "->");
            trav = trav.next;
        }
        System.out.print("null");
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode curr_next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr_next;
        }

        return prev;
    }
}

