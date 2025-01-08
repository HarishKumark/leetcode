/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class CountPrefixSuffixPairs {

    public boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        String prefix = str2.substring(0, str1.length());
        String suffix = str2.substring(str2.length() - str1.length());
        return str1.equalsIgnoreCase(prefix) && str1.equalsIgnoreCase(suffix);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        CountPrefixSuffixPairs countPrefix = new CountPrefixSuffixPairs();

//        countPrefix.countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aa"});
        countPrefix.countPrefixSuffixPairs(new String[]{"pa", "papa", "ma", "mama"});
    }
}
