package org.example;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i != 0) {
                arr[i] = nums1[i];
                count++;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (i != 0) {
                arr[count + i] = nums2[i];
            }
        }

        Arrays.sort(arr);
        System.out.println(arr);
    }
}
