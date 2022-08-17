package com.dsa.striver30daysSheet.d6_LinkedList;


public class DetectACycleInLinkedList2 {

    public static Node detectCycle(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                fast = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
