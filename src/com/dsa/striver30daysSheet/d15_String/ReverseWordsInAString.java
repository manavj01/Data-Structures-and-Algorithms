package com.dsa.striver30daysSheet.d15_String;

import java.util.Stack;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords(" a good   example "));
    }
    /*

Steps:

1. Trim front spaces -> by st
2. Trim last spaces -> by end
3. st to end is the string to reverse
4. now i = st, j = st
5. loop j till end and do following

     a) when j is space char -> reverse word (i to j-1) to handle last word , edge case when j ==n
        and i = j+1
     b) now skip trailing spaces of middle while(str[j]==' ') j++; out of this loop j--; coz j should be last space of middle spaces

     c) we need another marker to remove trailing middle spaces, this mark starts bagging next words that j iterates
        use mark

        mark is a pointer to keep char of j

      if(str[j]!=' '){
         str[mark++]= str[j++];
      }

     all places inside loop where i was taking support of j -> mark replaces j
     after each reverse of word append a space on mark pointer

   mark =st; initialize with i and j

*/

    public static String reverseWords(String s) {


        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] str = s.toCharArray();
        int n = str.length;

        // for trimming front spaces => take st
        // for trimming last spaces take end
        int st = 0, end = n - 1;

        // trim first spaces
        while (st <= end && str[st] == ' ') {
            st++;
        }

        // trim last spaces
        while (end >= st && str[end] == ' ') {
            end--;
        }

        int i = st, j = st, mark = st;
        // now st and end points to word first  and last word last char respectively

        reverse(str, st, end); //reverse whole string means reverse(str, 0, n-1) earlier

        // mark is used to remove middle multiple spaces
        // ptr that start bagging  on extra spaces , next words which are pointed by j
        while (j <= end) {   //while(j<=n){

            if (str[j] != ' ') { // means j is on word after middle spaces
                str[mark++] = str[j];
            }

            // after this mark points to first space

            if (j == end || str[j] == ' ') {
                reverse(str, i, mark - 1);//  reverse(str, i, j-1);

                // when out of boundary then no need to append ' ' and iterate further
                if (j == end) {
                    break;
                }

                str[mark++] = ' ';
                i = mark;

                while (str[j] == ' ') { // to skip extra spaces after one space so that j points to
                    // word next to middle series of spaces
                    j++;
                }
                // j should point to last space of middle series of spaces so that j++ out of this loop starts first char position of j
                j = j - 1;
            }

            j++;
        }

        return new String(str, st, mark - st);  // len of final string is mark-1 -st +1

    }

   static void reverse(char[] str, int l, int h) {

        while (l < h) {
            char tmp = str[l];
            str[l] = str[h];
            str[h] = tmp;

            l++;
            h--;
        }

    }

    public static String reverseWords1(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') continue;
            if (ch == ' ') {
                stack.push(sb.toString());
                // stack.push(" ");
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        stack.push(sb.toString());
        sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(stack.pop());
                break;
            }
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();

        // 3 line answer
        /**
         * String[] words = s.trim().split(" +");
         *         Collections.reverse(Arrays.asList(words));
         *          return String.join(" ", words);
         */

    }
}
