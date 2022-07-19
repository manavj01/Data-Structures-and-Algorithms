package com.dsa.striver30daysSheet.arrays2;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] arr) {
        int[] freq =  new int[arr.length];
        for (int a : arr){
            freq[a]++;
        }
        int ret=0;
        for (int i=0; i < freq.length;i++){
            if (freq[i]==2){
                ret= i;
                break;
            }
        }
        return ret;
    }
}
