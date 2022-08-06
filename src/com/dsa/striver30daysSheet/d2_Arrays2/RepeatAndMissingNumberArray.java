package com.dsa.striver30daysSheet.d2_Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(3, 1, 2, 5, 3);
        ArrayList<Integer> res = repeatedNumber(A);
        System.out.println(res);
    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int[] freq = new int[A.size() + 1];

        for (Integer a : A) {
            freq[a]++;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 1) {
                ret.add(i);
                break;
            }
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                ret.add(i);
                break;
            }
        }


        return ret;
    }

    public static ArrayList<Integer> repeatedNumber1(final List<Integer> A) {
        int len = A.size();

        int S = (len * (len + 1)) / 2;
        int P = (len * (len + 1) * (2 * len + 1)) / 6;
        int missingNumber = 0, repeating = 0;

        for (int i = 0; i < A.size(); i++) {
            S -= A.get(i);
            P -= A.get(i) * A.get(i);
        }

        missingNumber = (S + P / S) / 2;

        repeating = missingNumber - S;

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(repeating);
        ans.add(missingNumber);

        return ans;
    }

    static int x, y;

    public static void repeatedNumbers2(final List<Integer> A) {
        int n = A.size();
        /* Will hold xor of all elements
       and numbers from 1 to n  */
        int xor1;

        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        x = 0;
        y = 0;

        xor1 = A.get(0);

        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ A.get(i);

        /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);

        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((A.get(i) & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ A.get(i);

            else
                /* arr[i] belongs to second set*/
                y = y ^ A.get(i);
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;

            else
                /* i belongs to second set*/
                y = y ^ i;
        }

        // at last do a linear check which amont x and y is missing or repeating

        /* *x and *y hold the desired output elements */


    }
}