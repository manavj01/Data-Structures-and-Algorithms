package com.dsa.striver30daysSheet.d6_LinkedList;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoLinkedList {
    // approach time O(N^2) space O(1)
    public Node getIntersectionNode1(Node headA, Node headB) {
        Node tempA = headA;

        while (tempA != null) {
            Node tempB = headB;
            while (tempB != null) {
                if (tempA == tempB) {
                    return tempA;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }

        return null;
    }
    // approach time O(N) space O(N)

    public Node getIntersectionNode2(Node headA, Node headB) {
        HashSet<Node> set = new HashSet<>();
        Node tempA = headA;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        Node tempB = headB;
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

    public Node getIntersectionNode3(Node headA, Node headB) {
        Node tempA = headA;
        Node tempB = headB;

        while (tempA != tempB) {
            // approach 1
            if (tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
            // approach 2
//            tempA = tempA == null ? headB : tempA.next;
//            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
