package com.dsa.hashmapsAndHeaps;

import java.io.*;
import java.util.*;


public class GenericHeap_ComparableVsComparator {
    static class Student implements Comparable<Student> {
        int rno;
        int ht;
        int wt;

        Student(int rno, int ht, int wt) {
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }


        public int compareTo(Student o) {
            return this.rno - o.rno; // to get smaller first
//            return o.rno - this.rno; to get larger first
        }

        public String toString() {
            return "Rno. = " + this.rno + ", Ht = " + this.ht + ", Wt = " + this.wt;
        }

        static class StudentHtComparator implements Comparator<Student> {
            public int compare(Student s1, Student s2) {
                return s1.ht - s2.ht;
            }
        }

        static class StudentWtComparator implements Comparator<Student> {
            public int compare(Student s1, Student s2) {
                return s1.wt - s2.wt;
            }
        }
    }

    public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList<>();
            comp = null;
        }

        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
        }

        private boolean isSmaller(int i, int j) {
            if (comp == null) {
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                if (ith.compareTo(jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                T ith = data.get(i);
                T jth = data.get(j);
                if (comp.compare(ith, jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int i) {
            if (i == 0) {
                return;
            }
            int pi = (i - 1) / 2;
            if (isSmaller(i, pi)) {
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public T remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            swap(0, data.size() - 1);
            T val = data.remove(data.size() - 1);
            downheapify(0);
            return val;

        }

        private void downheapify(int pi) {
            int mini = pi;
            int lci = 2 * pi + 1;
            if (lci < data.size() && isSmaller(lci, mini)) {
                mini = lci;
            }
            int rci = 2 * pi + 2;
            if (rci < data.size() && isSmaller(rci, mini)) {
                mini = rci;
            }
            if (mini != pi) {
                swap(pi, mini);
                downheapify(mini);
            }
        }

        public T peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] arr = {10, 2, 17, 3, 18, 9, 22};
//        PriorityQueue qu = new PriorityQueue(arr);

        PriorityQueue<Student> pq = new PriorityQueue<>(new Student.StudentHtComparator());

        pq.add(new Student(10, 160, 75));
        pq.add(new Student(17, 179, 77));
        pq.add(new Student(13, 189, 84));
        pq.add(new Student(26, 182, 82));
        pq.add(new Student(32, 172, 70));

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }

}


// for example - in ques priority queue using heap
// inner workings of comparable interface
//    private void upheapify(int i){
//        Comparable parent = (Comparable) data.get(pi);
//        Comparable child  = (Comparable) data.get(i);
//        if(child.compareTo(parent) < 0){
//            swap(i, pi);
//            upheapify(pi);
//        }
//    }
