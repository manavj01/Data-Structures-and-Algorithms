package com.dsa.striver30daysSheet.d5_LinkedList;

public class MergeTwoSortedLists {

    public Node Lists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data > l2.data) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }


        Node res_node = l1;

        while (l1 != null && l2 != null) {
            Node tmp = null;
            while (l1 != null && l1.data <= l2.data) {
                tmp = l1;
                l1 = l1.next;
            }
            tmp.next = l2;

            //swap
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res_node;
    }

    public Node Lists1(Node list1, Node list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node head = new Node(0);
        Node ret_head = head;

        while (list1 != null && list2 != null) {
            Node node = new Node(0);
            if (list1.data <= list2.data) {
                head.data = list1.data;
                if (list1.next != null) {
                    head.next = node;
                    head = head.next;
                }
                list1 = list1.next;
            } else {
                head.data = list2.data;
                if (list2.next != null) {
                    head.next = node;
                    head = head.next;
                }
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            Node temp = new Node(0);
            temp.data = list1.data;
            head.next = temp;
            head = head.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            Node temp = new Node(0);
            temp.data = list2.data;
            list2 = list2.next;
            head.next = temp;
            head = head.next;
        }

        return ret_head;
    }

}
