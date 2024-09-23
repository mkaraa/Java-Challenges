package org.example;

public class QuestionMarks {

    public static String QuestionsMarks(String str) {
        char[] arr = str.toCharArray();
        int lastNumberIndex = -1;
        int questionMarkCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                int currentNumber = Character.getNumericValue(arr[i]);

                if (lastNumberIndex != -1) {
                    if (currentNumber + Character.getNumericValue(arr[lastNumberIndex]) == 10) {
                        if (questionMarkCount != 3) {
                            return "false";
                        }
                    }
                }

                lastNumberIndex = i;
                questionMarkCount = 0;
            } else if (arr[i] == '?') {
                questionMarkCount++;
            }
        }

        return "true";
    }

    public static void main(String[] args) {
        System.out.println(QuestionsMarks("arrb6???4xxbl5???eee5")); // true
        System.out.println(QuestionsMarks("arrb6??4xxbl5???eee5"));  // false

        String s = new StringBuilder("Hello World Mete!").reverse().toString();
    }
}

/*Questions Marks
Have the function QuestionsMarks(str) take the str string parameter,
which will contain single digit numbers, letters, and question marks,
and check if there are exactly 3 question marks between every pair of two numbers
that add up to 10. If so, then your program should return the string true,
otherwise it should return the string false.
If there aren't any two numbers that add up to 10 in the string,
then your program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true
because there are exactly 3 question marks between 6 and 4,
and 3 question marks between 5 and 5 at the end of the string.*/