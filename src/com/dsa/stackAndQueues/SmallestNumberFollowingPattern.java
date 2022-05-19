package com.dsa.stackAndQueues;

import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern {
    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Integer> st = new Stack<>();
        int counter = 1;
//      ddddiiii->  543216789
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == 'd') {
                st.push(counter);
                counter++;
            } else if (ch == 'i') {

                st.push(counter);

                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
                counter++;
            }

        }
        System.out.print(counter);


    }
}
