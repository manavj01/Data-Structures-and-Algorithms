package com.dsa.striver30daysSheet.d3_Arrays3;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 2, 3};
//        int[] arr = new int[]{2, 2, 1, 1, 3, 4, 1, 2};
        int[] arr = new int[]{2, 2};

        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement1(int[] nums) {
        int maj = nums.length / 3;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();

        for (int a : freq.keySet()) {
            if (freq.get(a) > maj) {
                list.add(a);
            }
        }
        return list;
    }

    public static List<Integer> majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int maj = nums.length / 3;
        int c = 1;
        int element = nums[0];

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == element) {
                c++;
            } else {
                if (c > maj) {
                    list.add(element);
                }
                element = nums[i];
                c = 1;
            }

        }
        if (c > maj) {
            list.add(element);
        }
        return list;

    }

    public static List<Integer> majorityElement(int[] nums) {
        int maj = nums.length / 3;
        int num1 = -1;
        int num2 = -2;
        int c1 = 0;
        int c2 = 0;

        for (int el : nums) {
            if (el == num1) {
                c1++;
            } else if (el == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = el;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = el;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            }
        }
        if (c1 > maj) {
            ans.add(num1);
        }
        if (c2 > maj) {
            ans.add(num2);
        }
        return ans;

    }

}
