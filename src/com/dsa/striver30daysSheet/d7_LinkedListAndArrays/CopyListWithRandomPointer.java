package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node temp = head;
        // first round : make copy of each node,
        // and link them together side bt side in a single list.
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;

        }
        temp = head;

        // Second round : assign random pointers for the copy nodes
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }


        // Third round : restore the original list, and extract the copy list
        temp = head;
        Node psuedoHead = new Node(0);
        Node copy = psuedoHead;
        Node front;
        while (temp != null) {
            front = temp.next.next;

            // extract the copy
            copy.next = temp.next;
            copy = copy.next;

            //restore the original list
            temp.next = front;
            temp = front;
        }

        return psuedoHead.next;
    }

    public static Node copyRandomList2(Node head) {

        Node trav = head;
        Node dummy = new Node(0);
        Node temp = dummy;
        int size = -1;

        while (trav != null) {
            temp.next = new Node(trav.val);
            temp = temp.next;
            trav = trav.next;
            size++;

        }
        trav = head;
        temp = dummy.next;
        while (trav != null) {
            Node randPtr = trav.random;
            if (randPtr == null) {
                temp.random = null;
                temp = temp.next;
                trav = trav.next;
                continue;
            }
            Node l2Trav = dummy.next;
            Node l1Trav = head;
            while (l1Trav != randPtr) {
                l2Trav = l2Trav.next;
                l1Trav = l1Trav.next;
            }
            temp.random = l2Trav;
            trav = trav.next;
            temp = temp.next;
        }


        return dummy.next;
    }

    public static Node copyRandomList1(Node head) {

        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
