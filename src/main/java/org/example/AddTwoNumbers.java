package org.example;

import java.util.Arrays;

public class AddTwoNumbers {

    public static int[] addTwoArrayReversed(int[] l1, int[] l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int[] l3 = new int[3];

        for (int i : l1) {
            sb1.append(i);
        }
        for (int i : l2) {
            sb2.append(i);
        }

        int lr1 = Integer.parseInt(sb1.reverse().toString());
        int lr2 = Integer.parseInt(sb2.reverse().toString());
        int res = lr1 + lr2;
        sb3.append(res).reverse();
        System.out.println(sb3);

        for (int i = 0; i < 3; i++) {
            l3[i] = Integer.parseInt(sb3.substring(i, i + 1));
        }

        return l3;
    }

    public static void main(String[] args) {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};
        int[] ints = addTwoArrayReversed(l1, l2);
        System.out.println(Arrays.toString(ints));
    }

}

/*
* Add Two Numbers
*
You are given two non-empty linked lists representing two non-negative integers.
*  The digits are stored in reverse order, and each of their nodes contains a single digit.
*  Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/