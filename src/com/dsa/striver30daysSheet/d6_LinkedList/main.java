package com.dsa.striver30daysSheet.d6_LinkedList;


import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node() {
    }

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
        Node[] arr = new Node[n];
        int idx = 0;
        while (n > 0) {
            System.out.println("Enter " + idx + " List");
            int len = scn.nextInt();
            Node head = new Node(scn.nextInt());
            Node tail = head;
            for (int i = 0; i < len - 1; i++) {
                tail.next = new Node(scn.nextInt());
                tail = tail.next;
            }
            --n;
            arr[idx++] = head;
            System.out.println("-----");
        }
        IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();
//        Node ans = obj.getIntersectionNode(arr[0],arr[1]);
//        System.out.println(ans.data);
//            System.out.println(ans.data);
//        printList(ans);
//            t--;
//        }
    }

}


