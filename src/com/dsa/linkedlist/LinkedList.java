package com.dsa.linkedlist;

public class LinkedList {

    public static class Node {
        int data;
        Node next;
    }

    Node head;
    Node tail;
    int size;

    void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;

        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    public int size() {
        return size;
    }

    public void display() {
//        for (Node temp = head; temp != null; temp = temp.next) {
//            System.out.print(temp.data + " ");
//        }
//        System.out.println();
        Node temp = new Node();
        temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();

    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
//            Node temp = new Node();
//            temp = head;
//            temp = temp.next;
//            head = temp;
//            size--;
            head = head.next;
            size--;
        }
    }

    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    public int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return tail.data;
        }
    }

    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;

//            Node temp = new Node();
//            temp = head;
//            int i =0;
//            while(i != idx){
//                temp= temp.next;
//                i++;
//            }
//            return temp.data;
        }
    }

    public void addFirst(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;

        if (size == 0) {
            tail = temp;
        }

        size++;
    }

    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            Node node = new Node();
            node.data = val;

            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;

            temp.next = node;
            size++;
        }
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }

            tail = temp;
            tail.next = null;
            size--;
        }
    }

    public void removeAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            size--;
        }
    }

    private Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseDI() {
        int li = 0;
        int ri = size - 1;
        while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            li++;
            ri--;
        }
    }

    public void reversePI() {
        // write your code here
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node ocn = current.next;

            current.next = prev;

            prev = current;
            current = ocn;
        }

        Node temp = head;
        head = tail;
        tail = temp;

    }

    public int kthFromLast(int k) {
//        my approach
//        Node temp = new Node();
//        Node node = new Node();
//        int c = 0;
//        temp =node= head;
//        while (temp != null){
//            temp = temp.next;
//            c++;
//        }
//        int kthfromlast = c-k-1;
//        while (kthfromlast != 0){
//            node = node.next;
//            kthfromlast--;
//        }
//        return node.data;

//      optimized approach
        Node s = head;
        Node f = head;

        for (int i = 0; i < k; i++) {
            f = f.next;
        }
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        return s.data;
    }

    public int mid() {
        // write your code here
        Node s = head;
        Node f = head;

        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s.data;

    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        Node one = l1.head;
        Node two = l2.head;

        LinkedList res = new LinkedList();

        while (one != null && two != null) {
            if (one.data <= two.data) {
                res.addLast(one.data);
                one = one.next;
            } else {
                res.addLast(two.data);
                two = two.next;
            }
        }
        while (one != null) {
            res.addLast(one.data);
            one = one.next;
        }
        while (two != null) {
            res.addLast(two.data);
            two = two.next;
        }

        return res;
    }

    private static Node midNode(Node head, Node tail) {
        Node f = head;
        Node s = head;

        while (f != tail && f.next != tail) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
        // write your code here
        if (head == tail) {
            LinkedList br = new LinkedList();
            br.addLast(head.data);
            return br;
        }

        Node mid = midNode(head, tail);
        LinkedList fsh = mergeSort(head, mid);
        LinkedList ssh = mergeSort(mid.next, tail);
        LinkedList cl = mergeTwoSortedLists(fsh, ssh);

        return cl;
    }

    public void removeDuplicates() {
        // write your code here
        LinkedList res = new LinkedList();

        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (res.size() == 0 || res.tail.data != val) {
                res.addLast(val);
            }
        }
        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
    }

    public void oddEven() {
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();

        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (val % 2 == 0) {
                even.addLast(val);
            } else {
                odd.addLast(val);
            }
        }

        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;

            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if (odd.size > 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else if (even.size > 0) {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }
    }

    public void kReverse(int k) {
        int s = this.size;
        int divi = s / k;
        int si = 0;
        int fi = k - 1;
        for (int i = 1; i <= divi; i++) {
            datarev(si, fi);
            si += k;
            fi += k;
        }
        // method 2
//        LinkedList prev = null;
//
//        while (this.size > 0) {
//            LinkedList curr = new LinkedList();
//
//            if (this.size >= k) {
//                for (int i = 0; i < k; i++) {
//                    int val = this.getFirst();
//                    this.removeFirst();
//                    curr.addFirst(val);
//                }
//            } else {
//                int sz = this.size;
//                for (int i = 0; i < sz; i++) {
//                    int val = this.getFirst();
//                    this.removeFirst();
//                    curr.addLast(val);
//                }
//            }
//
//            if (prev == null) {
//                prev = curr;
//            } else {
//                prev.tail.next = curr.head;
//                prev.tail = curr.tail;
//                prev.size += curr.size;
//            }
//        }
//
//        this.head = prev.head;
//        this.tail = prev.tail;
//        this.size = prev.size;
    }

    private void datarev(int si, int fi) {
        int li = si;
        int ri = fi;
        while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            li++;
            ri--;
        }
    }

    public boolean IsPalindrome() {
        // write your code here
//        int li =0;
//        int ri = size-1;
//        while(li<ri){
//
//            Node left = getNodeAt(li);
//            Node right = getNodeAt(ri);
//
//            if(left.data != right.data){
//                return false;
//            }
//            li++;
//            ri--;
//        }
//        return true;
        rleft = head;
        boolean flag = isPalindromeRhelper(head, 0);
        return flag;
    }

    Node rleft;

    public boolean isPalindromeRhelper(Node right, int floor) {
        if (right == null) {
            return true;
        }
        boolean flag = isPalindromeRhelper(right.next, floor + 1);

        if (floor >= size / 2) {
            if (!flag) {
                return false;
            } else if (right.data != rleft.data) {
                return false;
            } else {
                rleft = rleft.next;
            }
        }

        return true;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        // write your code here
        LinkedList res = new LinkedList();

        int oc = addTwoListsHelper(one.head, one.size, two.head, two.size, res);

        if (oc > 0) {
            res.addFirst(oc);
        }

        return res;
    }

    public static int addTwoListsHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
        if (one == null || two == null) {
            return 0;
        }

        int data = 0;
        if (pv1 > pv2) {
            int oc = addTwoListsHelper(one.next, pv1 - 1, two, pv2, res);
            data = one.data + oc;
        } else if (pv1 < pv2) {
            int oc = addTwoListsHelper(one, pv1, two.next, pv2 - 1, res);
            data = two.data + oc;
        } else {
            int oc = addTwoListsHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
            data = one.data + two.data + oc;
        }

        int nd = data % 10;
        int nc = data / 10;

        res.addFirst(nd);
        return nc;

    }
}
