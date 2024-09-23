package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {

    public static String FindIntersection(String[] strArr) {
        String[] first = strArr[0].split(",");
        String[] second = strArr[1].split(",");
        List<String> intersec = new ArrayList<>();

        for (String f : first) {
            for (String s : second) {
                if (f.equals(s)) {
                    intersec.add(s);
                }
            }
        }

        return intersec.toString();
    }

    public static void main(String[] args) {
        String[] strArr = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(Arrays.toString(strArr[0].split(",")));
    }
}

/*
* Find Intersection
Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
* the first element will represent a list of comma-separated numbers sorted in ascending order,
* the second element will represent a second list of comma-separated numbers (also sorted).
* Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
* If there is no intersection, return the string false.*/