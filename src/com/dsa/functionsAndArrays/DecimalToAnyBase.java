package com.dsa.functionsAndArrays;

import java.util.Scanner;

public class DecimalToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        scn.close();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        int rv = 0;
        int power = 1;

        while (n > 0) {
            int dig = n % b;
            n = n / b;
            rv = rv + dig * power;
            power *= 10;
        }

        return rv;
    }
}
