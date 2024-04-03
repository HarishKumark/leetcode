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

    public int findCommonValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(i);
                }
            }
        }
        return set.size();
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean first[] = new boolean[nums1.length];
        boolean second[] = new boolean[nums2.length];

        int firstCount = 0, secondCount = 0;
        for (int i : nums1) {
            first[i] = true;
        }
        for (int i : nums2) {
            second[i] = true;
        }
        for (int i : nums1) {
            if (second[i]) {
                firstCount++;
            }
        }
        for (int i : nums2) {
            if (first[i]) {
                secondCount++;
            }
        }
        return new int[]{firstCount, secondCount};

//        return new int[]{findCommonValues(nums1, nums2), findCommonValues(nums2, nums1)};
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }
        return moves;

    }

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sVal = s.charAt(i);
            char tVal = t.charAt(i);

            if (smap.containsKey(sVal)) {
                if (tmap.get(sVal) != tVal) {
                    return false;
                }
            } else {

                if (tmap.containsKey(tVal)) {
                    return false;
                }

                smap.put(sVal, tVal);
                tmap.put(tVal, sVal);
            }

        }
        return true;

    }

    public void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public int[][] flipAndInvertImage(int[][] image) {

        int[][] out = new int[image.length][image.length];

        for (int i = 0; i < image.length; i++) {
            reverseArray(image[i]);
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == 0) {
                    out[i][j] = 1;
                }
                if (image[i][j] == 1) {
                    out[i][j] = 0;
                }

            }
        }
        return out;
    }

    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, board, word)) {
                    return true;
                }

            }
        }

        return false;

    }

    public boolean searchWord(int i, int j, int index, char[][] board, String word) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (searchWord(i + 1, j, index + 1, board, word) || searchWord(i - 1, j, index + 1, board, word)
                || searchWord(i, j + 1, index + 1, board, word) || searchWord(i, j - 1, index + 1, board, word)) {
            return false;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {

        Leet l = new Leet();

//        int[] findIntersectionValues = leet.findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6});
//
//        for (int findIntersectionValue : findIntersectionValues) {
//            System.out.println(findIntersectionValue);
//        }
//        List<Integer> ll = new ArrayList<>();
//        ll.add(1);
//        ll.add(2);
//        ll.add(1);
//        int sumCounts = leet.sumCounts(ll);
//        long countSubarrays = leet.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);
//        long countSubarrays = leet.countSubarrays(new int[]{61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82}, 2);
//        System.out.println("sumCounts " + sumCounts);
//        int uniqueMorseRepresentations = leet.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
//
//        System.out.println(uniqueMorseRepresentations);
//        System.out.println("i :: " + leet.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
//        leet.slidingWindow(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }

}
