package com.dsa.patterns;

import java.util.Scanner;

public class Pattern15 {

    // pattern 15
    //      1
    //    2 3 2
    //  3 4 5 4 3
    //    2 3 2
    //      1

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        
        // int space =n/2;
        // int star = 1;
        // int val=1;
        // for(int i =1;i<=n; i++ ){
          
        //   //for spaces 
        //     for(int j=1; j<=space;j++){
        //         System.out.print("\t");
        //     }
        //     // for stars/values 
        //     int cval=val;
        //     for(int k=1; k<=star; k++){
        //         System.out.print(cval+ "\t");
                
        //         if(k <= star/2){
        //             cval++;
        //         }else{
        //             cval--;
        //         }
        //     }

        //     if(i<=n/2){
        //         space--;
        //         star+=2;
        //         val++;
        //     }else{
        //         space++;
        //         star-=2;
        //         val--;
        //     }
        //     System.out.println();
        // }
        int space= n/2;
        int star= 1;
        int value =1;
        // for rows
        for(int i= 1; i<= n; i++){

            //for spaces
            for(int j=1; j<=space; j++){
                System.out.print("\t");
            }

            //for values/stars
            int columnVal=value;
            for(int k=1; k<=star; k++){
                // columnVal++;
                System.out.print(columnVal +"\t");
                if(k<=star/2){
                    columnVal++;
                }else{
                    columnVal--;
                }
            }

            if(i<=n/2){
                space--;
                star+=2;
                value++;
            }else{
                space++;
                star-=2;
                value--;
            }
            System.out.println();

        }
        int a=2,b=3;
        int c = b/a;
        System.out.println(c);
    }

}
