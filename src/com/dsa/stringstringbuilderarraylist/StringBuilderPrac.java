package com.dsa.stringstringbuilderarraylist;

public class StringBuilderPrac {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);

        char ch = sb.charAt(0);
        System.out.println(ch);

        sb.setCharAt(0,'d');
        System.out.println(sb);

        sb.insert(2,'y');
        System.out.println(sb);

        sb.deleteCharAt(2);
        System.out.println(sb);

        sb.append('g');
        System.out.println(sb);

        int n = 100000;

        long start = System.currentTimeMillis();
//        String s ="";
//        for (int i = 0; i < n; i++) {
//            s+=i;
//        }
        
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(i);
        }
        long end = System.currentTimeMillis();
        long duration = end-start;
        System.out.println(duration);
    }
}
