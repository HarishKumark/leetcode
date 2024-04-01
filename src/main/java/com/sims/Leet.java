/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            ans += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return ans;
    }

    public boolean isAcronym(List<String> words, String s) {
        String acronym = "";
        for (String word : words) {

            acronym += word.charAt(0);
        }
        return acronym.equalsIgnoreCase(s);

    }

    public long countSubarrays(int[] nums, int k) {

        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                count++;
            }
            while (k == count) {
                if (nums[start] == maxElement) {
                    count--;
                }
                start++;
            }
            ans += start;

        }
//        
        return ans;

    }

    public int sumCounts(List<Integer> nums) {
        int c = 0;
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                for (int k = i; k <= j; k++) {
                    l1.add(nums.get(k));
                }
                Set<Integer> set = new HashSet<>(l1); //For finding distinct elements
                c += Math.pow(set.size(), 2);
                l1.clear();
            }
        }
        return c;

    }

    public int lengthOfLastWord(String s) {

        String trim = s.trim();
        String[] split = trim.split(" ");
        return split[split.length - 1].length();

    }

    public static void main(String[] args) {

        Leet leet = new Leet();
        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        ll.add(1);
        int sumCounts = leet.sumCounts(ll);
//        long countSubarrays = leet.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);

//        long countSubarrays = leet.countSubarrays(new int[]{61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82}, 2);
        System.out.println("sumCounts " + sumCounts);
//        int uniqueMorseRepresentations = leet.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
//
//        System.out.println(uniqueMorseRepresentations);
//        System.out.println("i :: " + leet.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
//        leet.slidingWindow(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }

}
