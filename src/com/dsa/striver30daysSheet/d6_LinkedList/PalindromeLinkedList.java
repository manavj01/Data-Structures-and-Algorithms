package com.dsa.striver30daysSheet.d6_LinkedList;

import java.util.ArrayList;
import java.util.Objects;

public class PalindromeLinkedList {

    public boolean isPalindrome(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverseList(slow.next);
        dummy = dummy.next;
        slow = slow.next;
        while (slow != null) {
            if (dummy.data != slow.data) {
                return false;
            }
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }

    public static Node reverseList(Node slow) {
        Node prev = null;
        Node curr = slow;
        Node curr_next = slow;

        while (curr != null) {
            curr_next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr_next;
        }
        return prev;
    }

    public boolean isPalindrome2(Node head) {
        rLeft = head;
        return isPalindrome2Helper(head);
    }

    Node rLeft;

    public boolean isPalindrome2Helper(Node head) {
        if (head == null) return true;

        boolean flag = isPalindrome2Helper(head.next);

        if (!flag) {
            return false;
        } else if (rLeft.data != head.data) {
            return false;
        } else {
            rLeft = rLeft.next;
        }
        return true;
    }

    public boolean isPalindrome1(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.data);
            head = head.next;
        }
        for (int i = 0; i < arr.size() / 2; i++)
            if (!Objects.equals(arr.get(i), arr.get(arr.size() - i - 1))) return false;
        return true;
    }

}
