package com.dsa.accenture;
import  java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomerDetails c = new CustomerDetails("Sample", "Sample", 123456789,"Sample",12.00,13.00);
        System.out.println("Enter Customer Id");
        c.setCustomerId(sc.nextLine());
        System.out.println("Enter Customer Name");
        c.setCustomerName(sc.nextLine());
        System. out. println("Enter Phone Number");
        c.setPhoneNumber(sc.nextLong());
        System.out.println("Enter City");
        c.setCity(sc.next());
        System.out.println("Enter Units Consumed");
        c.setUnitConsumed(sc.nextDouble());
        System.out.println("Enter Cost per Unit");
        c.setCostPerUnit(sc.nextDouble ());
        double amount =c.calculateElectricityBill();
        System.out.println("Amount to be paid is Rs."+ amount);

    }

}
