package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestWord {

    public static String LongestWord(String sen) {
        String[] str = sen.split(" ");
        Map<Integer, String> map = new HashMap<>();

        for (String s : str) {
            int max = 0;
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    max++;
                }
            }
            if (!map.containsKey(max)) {
                map.put(max, s);
            }
        }

        Integer i = map.keySet().stream().max(Integer::compareTo).orElse(0);

        return map.get(i);
    }


    public static void main(String[] args) {
        String str = "I love!! all dogs in here!";
        String s = LongestWord(str);
        System.out.println(s);
    }
}
