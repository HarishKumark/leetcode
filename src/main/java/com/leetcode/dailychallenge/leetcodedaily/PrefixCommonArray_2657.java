/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class PrefixCommonArray_2657 {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] countArr = new int[A.length];
        for (int i = 0; i < countArr.length; i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (A[j] == B[k]) {
                        count++;
                    }
                }
            }
            countArr[i] = count;
        }
        return countArr;
    }

    public static void main(String[] args) {
        PrefixCommonArray_2657 prefixCommonArray_2657 = new PrefixCommonArray_2657();

        prefixCommonArray_2657.findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4});
        System.out.println("=====");
        prefixCommonArray_2657.findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2});

    }

}
