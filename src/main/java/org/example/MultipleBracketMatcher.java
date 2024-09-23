package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MultipleBracketMatcher {

    // SOLUTION I
    public static String MultipleBracketMatcher(String str) {
        Stack<Character> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        for (char c : str.toCharArray()) {
            String s = map.get(String.valueOf(c));
            if (String.valueOf(c).equals("(") || String.valueOf(c).equals("{") || String.valueOf(c).equals("[")) {
                stack.push(c);
            } else if (String.valueOf(c).equals(")") || String.valueOf(c).equals("}") || String.valueOf(c).equals("]")) {
                if (stack.isEmpty()) {
                    return "false";
                }
                Character pop = stack.pop();
                if (!map.get(String.valueOf(c)).equals(String.valueOf(pop))) {
                    return "false";
                }

            }
        }

        if (!stack.isEmpty()) {
            return "false";
        }

        return "true";
    }

    // SOLUTION II -> I WORK FOR IT AGAIN TO BETTER PERFORMANCE
    public static boolean multipleBracketMatcher(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpen = stack.pop();
                if ((c == ')' && lastOpen != '(') ||
                        (c == '}' && lastOpen != '{') ||
                        (c == ']' && lastOpen != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "{}[]{}()";
        String s3 = "(]";
        String s4 = "(){]";
        List<String> stringList = List.of(s1, s2, s3, s4);
        for (String str : stringList) {
            String res = MultipleBracketMatcher(str);
            System.out.println("SOLUTION I : " + res);

            boolean resII = multipleBracketMatcher(str);
            System.out.println("SOLUTION II : " + resII);

        }
    }
}

/* From my interview: MultipleBracketMatcher
 *
 * a function that takes a parameter as String like : "()" or "(){}[]" or "{}[]" and so on.
 * if bracket close correctly it returns "true",
 * if string is like "[}" or "(}" and so on, it returns false
 *
 * */
