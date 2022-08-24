package com.dsa.striver30daysSheet.d5_LinkedList;

public class AddTwoLists {
    public static void main(String[] args) {

    }


    public static Node addTwoNumbers(Node l1, Node l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;


        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            int d = sum % 10;
            carry = sum / 10;

            temp.next = new Node(d);
            temp = temp.next;

        }

        return dummy.next;
    }

    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
