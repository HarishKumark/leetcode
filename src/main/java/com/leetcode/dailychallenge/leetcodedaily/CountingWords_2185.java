/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class CountingWords_2185 {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.length() >= pref.length()) {
                if (word.substring(0, pref.length()).equalsIgnoreCase(pref)) {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {

        CountingWords_2185 countingWords_2185 = new CountingWords_2185();

        System.out.println(countingWords_2185.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        System.out.println(countingWords_2185.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));

    }

}
