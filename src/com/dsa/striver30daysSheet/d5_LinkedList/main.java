package com.dsa.striver30daysSheet.d5_LinkedList;


import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Function {
    static void printList(Node node) {
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        int t = scn.nextInt();
//        while (t>0){
        int n = scn.nextInt();
        Node head = new Node(scn.nextInt());
        Node tail = head;
        for (int i = 0; i < n - 1; i++) {
            tail.next = new Node(scn.nextInt());
            tail = tail.next;
        }
        MergeTwoSortedLists moll = new MergeTwoSortedLists();
        Node ans = moll.Lists(head, head);
//            System.out.println(ans.data);
        printList(ans);
//            t--;
//        }
    }

}


