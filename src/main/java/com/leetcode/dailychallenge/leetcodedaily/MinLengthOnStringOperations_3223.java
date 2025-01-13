/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class MinLengthOnStringOperations_3223 {

    public int minimumLength(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int count = 0;
        for (int i : arr) {
            if (i == 0) {
                continue;
            }

            if (i % 2 != 0) {
                count += 1;
            } else {
                count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinLengthOnStringOperations_3223 minLengthOnStringOperations_3223 = new MinLengthOnStringOperations_3223();

        System.out.println(minLengthOnStringOperations_3223.minimumLength("abaacbcbb"));
        System.out.println(minLengthOnStringOperations_3223.minimumLength("aa"));
        
    }
}
