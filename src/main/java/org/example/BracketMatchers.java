package org.example;

public class BracketMatchers {

    public static int BracketMatcher(int num) {
        int res = 1;

        for (int i = 1; i < num; i++) {
            res = 2 * (2 * i + 1) * res / (i + 2);
        }

        return res;
    }

    public static void main(String[] args) {
        int res = BracketMatcher(5);
        System.out.println(res);

        res = BracketMatcher(3);
        System.out.println(res);

        res = BracketMatcher(2);
        System.out.println(res);
    }
}
/*Bracket Combinations
Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero,
and return the number of valid combinations that can be formed with num pairs of parentheses.
For example, if the input is 3, then the possible combinations of 3 pairs of parenthesis,
namely: ()()(), are ()()(), ()(()), (())(), ((())), and (()()).
There are 5 total combinations when the input is 3, so your program should return 5.*/