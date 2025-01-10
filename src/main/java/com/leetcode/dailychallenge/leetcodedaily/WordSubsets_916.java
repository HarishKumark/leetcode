/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class WordSubsets_916 {

    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> list = new ArrayList<>();
        //0 ,0 ,0,0
        int[] maxFreq = new int[26];

        //maxFre = 1,0,0,0,2
        //words=[a]
        for (String str2 : words2) {
            int[] temp = new int[26];// 1, 0 ,0 ,0 
            for (char c : str2.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < maxFreq.length; i++) {
                maxFreq[i] = Math.max(maxFreq[i], temp[i]);
            }
        }

        for (String string : words1) {
            int[] temp = new int[26];// 1, 0 ,0 ,0 
            for (char c : string.toCharArray()) {
                temp[c - 'a']++;
            }

            boolean isSubset = true;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] < maxFreq[i]) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                list.add(string);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        WordSubsets_916 wordSubsets_916 = new WordSubsets_916();
        System.out.println(wordSubsets_916.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));
        System.out.println(wordSubsets_916.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"ce", "o"}));

    }
}
