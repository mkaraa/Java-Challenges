package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeConstructor {

    public static String TreeConstructor(String[] strArr) {
//        String[] strArr = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};

        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, Set<Integer>> childrenMap = new HashMap<>();

        for (String str : strArr) {
            String pair = str.substring(1, str.length() - 1);
            String[] split = pair.split(",");

            int child = Integer.parseInt(split[0]);
            int parent = Integer.parseInt(split[1]);

            if (parentMap.containsKey(child)) {
                return "false";
            }
            parentMap.put(child, parent);

            childrenMap.putIfAbsent(parent, new HashSet<>());
            if (childrenMap.get(parent).size() >= 2) {
                return "false";
            }
            childrenMap.get(parent).add(child);
        }

        Set<Integer> allNodes = new HashSet<>(parentMap.keySet());
        allNodes.addAll(parentMap.values());

        Set<Integer> potentialNodes = new HashSet<>(allNodes);
        potentialNodes.removeAll(parentMap.keySet());

        if (potentialNodes.size() != 1) {
            return "false";
        }

        return "true";
    }

    public static void main(String[] args) {
        String[] strArr = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        String s = TreeConstructor(strArr);
        System.out.println(s);

        String[] strArr2 = {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        String s1 = TreeConstructor(strArr2);
        System.out.println(s1);
    }
}


/*
Tree Constructor
Have the function TreeConstructor(strArr) take the array of strings stored in strArr,
which will contain pairs of integers in the following format: (i1,i2),
where i1 represents a child node in a tree and the second integer i2 signifies that it is the parent of i1.
For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"]

which you can see forms a proper binary tree.
Your program should, in this case, return the string true because a valid binary tree can be formed.
If a proper binary tree cannot be formed with the integer pairs,
then return the string false. All of the integers within the tree will be unique,
which means there can only be one node in the tree with the given integer value.
*/