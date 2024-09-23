package org.example;

public class CamelCase {

    public static void main(String[] args) {
        // Example usage
        String input = "BOB loves-coding";
        System.out.println(convertToCamelCase(input));  // Output: "bobLovesCoding"
    }

    public static String convertToCamelCase(String str) {
        // Split the string by non-letter characters
        String[] words = str.split("[^a-zA-Z]+");

        // Initialize a StringBuilder to build the camel case string
        StringBuilder camelCaseStr = new StringBuilder();

        // Process each word
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                // Convert the first word to lowercase and subsequent words to Capitalized
                if (i == 0) {
                    camelCaseStr.append(words[i].toLowerCase());
                } else {
                    camelCaseStr.append(Character.toUpperCase(words[i].charAt(0)))
                            .append(words[i].substring(1).toLowerCase());
                }
            }
        }

        return camelCaseStr.toString();
    }
}



