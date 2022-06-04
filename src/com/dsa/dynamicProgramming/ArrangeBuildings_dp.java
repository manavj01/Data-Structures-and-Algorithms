package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class ArrangeBuildings_dp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ob = 1;
        int os = 1;

        for (int i = 2; i <= n; i++) {
            int nb = os;
            int ns = os + ob;

            os = ns;
            ob = nb;

        }
        int total = os + ob;
        total = total * total;
        System.out.println(total);
    }
}
