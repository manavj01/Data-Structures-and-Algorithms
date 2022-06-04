package com.dsa.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if (str.startsWith("size")) {
                System.out.println(list.size());
            } else if (str.startsWith("display")) {
                list.display();
            } else if (str.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (str.startsWith("getFirst")) {
                int val = list.getFirst();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getLast")) {
                int val = list.getLast();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("addFirst")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            } else if (str.startsWith("addAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            } else if (str.startsWith("removeLast")) {
                list.removeLast();
            } else if (str.startsWith("removeAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            } else if (str.startsWith("reverseDI")) {
                list.reverseDI();
            } else if (str.startsWith("reversePI")) {
                list.reversePI();
            } else if (str.startsWith("kthFromEnd")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                System.out.println(list.kthFromLast(idx));
            } else if (str.startsWith("mid")) {
                System.out.println(list.mid());
            }
//            int n1 = Integer.parseInt(br.readLine());
//            LinkedList l1 = new LinkedList();
//            String[] values1 = br.readLine().split(" ");
//            for (int i = 0; i < n1; i++) {
//                int d = Integer.parseInt(values1[i]);
//                l1.addLast(d);
//            }
//
//            int n2 = Integer.parseInt(br.readLine());
//            LinkedList l2 = new LinkedList();
//            String[] values2 = br.readLine().split(" ");
//            for (int i = 0; i < n2; i++) {
//                int d = Integer.parseInt(values2[i]);
//                l2.addLast(d);
//            }

            int n1 = Integer.parseInt(br.readLine());
            LinkedList l1 = new LinkedList();
            String[] values1 = br.readLine().split(" ");
            for (int i = 0; i < n1; i++) {
                int d = Integer.parseInt(values1[i]);
                l1.addLast(d);
            }
//            LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
//            merged.display();
            l1.display();
//            l2.display();
            str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            l1.display();
            l1.kReverse(k);
            l1.display();
            l1.addFirst(a);
            l1.addLast(b);
            l1.display();
        }
    }
}
//addLast 10
//addLast 20
//addLast 30