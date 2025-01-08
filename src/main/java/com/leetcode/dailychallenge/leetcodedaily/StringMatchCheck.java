/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class StringMatchCheck {

    public boolean isSubstring(String mainStr, String subStr) {
        if (mainStr == null || subStr == null) {
            return false;
        }
        return mainStr.contains(subStr);
    }

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (isSubstring(words[i], words[j])) {
                        set.add(words[j]);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        StringMatchCheck strmatch = new StringMatchCheck();
        System.out.println(strmatch.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(strmatch.stringMatching(new String[]{"leetcode","et","code"}));

    }
}
