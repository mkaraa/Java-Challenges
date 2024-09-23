package org.example;

import java.util.HashMap;

public class MinWindowSubstring {
    public static String MinWindowSubstring(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];

        HashMap<Character, Integer> targetFreq = new HashMap<>();
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        for (char c : K.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = targetFreq.size();
        int formed = 0;
        int[] ans = {-1, 0, 0};

        while (right < N.length()) {

            char c = N.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = N.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowFreq.put(c, windowFreq.get(c) - 1);
                if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() < targetFreq.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : N.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String[] strArr = {"aaabaaddae", "aed"};
        String s = MinWindowSubstring(strArr);
        System.out.println(s);
    }
}
/* NOTE-> SLIDING WINDOW FUNCTION*/

/* Min Window Substring

 * Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr,
 *  which will contain only two strings,
 * the first parameter being the string N and the second parameter being a string K of some characters,
 * and your goal is to determine the smallest substring of N that contains all the characters in K. For example: if strArr is ["aaabaaddae", "aed"]
 * then the smallest substring of N that contains the characters a, e, and d is "dae" located at the end of the string.
 * So for this example your program should return the string dae.


 * Another example: if strArr is ["aabdccdbcacd", "aad"]
 * then the smallest substring of N that contains all of the characters in K is "aabd" which is located at the beginning of the string.
 * Both parameters will be strings ranging in length from 1 to 50 characters and all of K's characters will exist somewhere in the string N.
 * Both strings will only contains lowercase alphabetic characters.*/