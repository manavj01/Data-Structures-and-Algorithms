package com.dsa.striver30daysSheet.d6_LinkedList;

import java.util.List;

class ListNode {
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

public class ReverseALinkedListInGroupsOfSizeK {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = n1;
        head = reverseKGroup(head, 2);
        System.out.println();
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];

        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            arr[i] = temp;
            temp = temp.next;
        }
        reverse(arr);
        ListNode dummy = head;

        for (int i = 0; i < arr.length; i++) {
            dummy = arr[i];
            dummy = dummy.next;
        }


        return head;
    }

    public static void reverse(ListNode[] arr) {
        int si = 0;
        int ei = arr.length - 1;
        while (si <= ei) {
            ListNode temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }

    }
}
