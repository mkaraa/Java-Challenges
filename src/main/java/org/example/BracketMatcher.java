package org.example;

import java.util.Stack;

public class BracketMatcher {

    public static String BracketMatcher(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (String.valueOf(aChar).equals("(")) {
                stack.push(aChar);
            } else if (String.valueOf(aChar).equals(")")) {
                if (stack.isEmpty()) {
                    return "0";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "1" : "0";
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        Integer pop = stack.pop();
        Integer peek = stack.peek();
//        System.out.println(" stack: "+ stack );
//        System.out.println("pop: "+pop+"\n stack: "+ stack);
//        System.out.println("peek: "+ peek+"\n stack: "+ stack);

        String str = "(hello (world)!))";
        char[] chars = str.toLowerCase().toCharArray();
        String s = BracketMatcher(str);
        System.out.println(s);
    }
}
/*
 * Bracket Matcher
 * Have the function BracketMatcher(str) take the str parameter being passed and return 1
 * if the brackets are correctly matched and each one is accounted for.
 * Otherwise return 0. For example: if str is "(hello (world))", then the output should be 1,
 * but if str is "((hello (world))" the the output should be 0 because the brackets do not correctly match up.
 * Only "(" and ")" will be used as brackets.
 * If str contains no brackets return 1.
 */