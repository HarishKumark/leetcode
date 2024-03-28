/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author hkorada
 */
public class Leet {

    public void slidingWindow(int[] nums, int sliding) {
        for (int i = 0; i < nums.length; i++) {
            if (sliding + i <= nums.length) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j < sliding + i; j++) {
                    int num = nums[j];
                    if (max < num) {
                        max = num;
                    }
                }
            }
        }
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int start = -1, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > k) {
                start++;
                map.put(nums[start], map.get(nums[start]) - 1);
            }
            ans = Math.max(ans, i - start);
        }
        return ans;
    }

    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> mp = new HashMap<>();
        mp.put('a', ".-");
        mp.put('b', "-...");
        mp.put('c', "-.-.");
        mp.put('d', "-..");
        mp.put('e', ".");
        mp.put('f', "..-.");
        mp.put('g', "--.");
        mp.put('h', "....");
        mp.put('i', "..");
        mp.put('j', ".---");
        mp.put('k', "-.-");
        mp.put('l', ".-..");
        mp.put('m', "--");
        mp.put('n', "-.");
        mp.put('o', "---");
        mp.put('p', ".--.");
        mp.put('q', "--.-");
        mp.put('r', ".-.");
        mp.put('s', "...");
        mp.put('t', "-");
        mp.put('u', "..-");
        mp.put('v', "...-");
        mp.put('w', ".--");
        mp.put('x', "-..-");
        mp.put('y', "-.--");
        mp.put('z', "--..");

        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            String str = "";
            for (int i = 0; i < word.split("").length; i++) {
                str += mp.get(word.charAt(i));
            }
            set.add(str);
        }
        return set.size();
    }

    public static void main(String[] args) {

        Leet leet = new Leet();

        int uniqueMorseRepresentations = leet.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});

        System.out.println(uniqueMorseRepresentations);
//        System.out.println("i :: " + leet.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
//        leet.slidingWindow(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }

}
