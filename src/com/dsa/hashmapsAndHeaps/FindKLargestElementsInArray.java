package com.dsa.hashmapsAndHeaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKLargestElementsInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int c = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val :arr) {
            pq.add(val);
        }

        for (int i=0 ;i< c;i++) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
