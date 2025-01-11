/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ConstructKPalindromes_1400 {

    public boolean canConstruct(String s, int k) {

        if (s.length() < k) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            odd += entry.getValue() % 2;
        }
        return (odd <= k);
    }

    public static void main(String[] args) {

        ConstructKPalindromes_1400 con = new ConstructKPalindromes_1400();
        
        System.out.println(con.canConstruct("annabelle", 2));
        System.out.println(con.canConstruct("leetcode", 3));
        
    }
}
