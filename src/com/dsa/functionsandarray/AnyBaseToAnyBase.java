package com.dsa.functionsandarray;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        scn.close();

        int val = showResult(n, b1, b2);
        System.out.println(val);

    }

    public static int showResult(int n, int b1, int b2) {
        int a = AnyBaseTODecimal(n, b1);
        int b = DecimalToAnyBase(a, b2);
        return b;
    }

    public static int AnyBaseTODecimal(int n, int b1) {
        int rv = 0;
        int power = 1;

        while (n > 0) {
            int dig = n % 10;
            n = n / 10;
            rv = rv + dig * power;
            power *= b1;
        }

        return rv;
    }

    public static int DecimalToAnyBase(int n, int b2) {
        int rv = 0;
        int power = 1;

        while (n > 0) {
            int dig = n % b2;
            n = n / b2;
            rv = rv + dig * power;
            power *= 10;
        }

        return rv;
    }
}
