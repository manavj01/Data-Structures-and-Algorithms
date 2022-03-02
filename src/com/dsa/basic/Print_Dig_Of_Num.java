package com.dsa.basic;

import java.util.Scanner;

public class Print_Dig_Of_Num {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
         int nod=0;
         int temp = n;
         
         while(temp != 0){
           temp=temp/10;
           nod++;
         }
  
         int divisor = (int)Math.pow(10 , nod-1);
         while(divisor != 0){
           int quotient = n/divisor;
           System.out.println(quotient);
  
           n = n % divisor;
           divisor = divisor/10;
  
         }
        
  
       }
}
