/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

    public int maxDepth(String s) {

        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }

            if (s.charAt(i) == ')') {
                max = Math.max(count, max);
                count--;
            }
        }
        return max;
    }

    public void checkVal(int curNode, int[][] grid, boolean vis[]) {

        vis[curNode] = true;
    }

    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int curNode = grid[i][j];
                if (curNode == 2) {
                    q.add(new int[]{i, j});
                } else if (curNode == 1) {
                    freshOranges++;
                }

            }
        }

        if (freshOranges == 0) {
            return 0;
        }
        int dr[] = new int[]{0, 0, 1, -1};
        int dc[] = new int[]{1, -1, 0, 0};
        int time = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int[] poll = q.poll();
                for (int j = 0; j < 4; j++) {
                    int row = poll[0] + dr[j];
                    int col = poll[1] + dc[j];

                    if (row < 0 || row == grid.length || col < 0 || col == grid.length || grid[row][col] != 1) {
                        continue;
                    }
                    grid[row][col] = 2;
                    q.add(new int[]{row, col});
                    freshOranges--;
                }
                time++;
            }

        }

        return freshOranges == 0 ? time : -1;
    }

    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int lastVal = nums[nums.length - 1];
        int prev = lastVal;
        for (int i = 0; i < k - 1; i++) {
            lastVal += 1;
            prev += lastVal;
        }
        return prev;
    }

//    public String makeGoodtest(String s, String teo) {
//
//    }
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (!stack.isEmpty() && stack.peek() == Character.toLowerCase(ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }

            } else {
                if (!stack.isEmpty() && stack.peek() == Character.toUpperCase(ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        System.out.println(stack);
        return stack.stream().map(ele -> Character.toString(ele)).collect(Collectors.joining());
    }

    int sum = 0;

    public int subsetXORSum(int[] nums) {
        sum = 0;
        return getAns(nums, 0, 0);
    }

    int getAns(int[] arr, int i, int cur) {
        if (i == arr.length) {
            return cur;
        }
        return getAns(arr, i + 1, cur ^ arr[i]) + getAns(arr, i + 1, cur);
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= a) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (new StringBuilder(words[i]).reverse().toString().equalsIgnoreCase(words[j])) {
                        count++;
                    }
                }
            }
        }
        return count / 2;
    }

    public int countStudents(int[] students, int[] sandwiches) {

        long stuCount = Arrays.stream(students).filter(ele -> ele == 0).count();
        long sanCount = Arrays.stream(sandwiches).filter(ele -> ele == 0).count();
        if (stuCount == sanCount) {
            return 0;
        }

        return (int) Math.abs(sanCount - stuCount) + 1;

    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTimeTaken = 0;

        while (true) {
            for (int i = 0; i < tickets.length; i++) {
                int ticket = tickets[i];
                if (ticket > 0) {
                    totalTimeTaken += 1;
                    tickets[i] = ticket - 1;
                }
                if (k == i && tickets[i] == 0) {
                    return totalTimeTaken;
                }
            }
        }
    }

    public int countTestedDevices(int[] batteryPercentages) {

        int devices = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            int batteryPercentage = batteryPercentages[i];
            if (batteryPercentage > 0) {
                devices++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return devices;
    }

    public int sumOfSquares(int[] nums) {

        int len = nums.length;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len % (i + 1) == 0) {
                count += nums[i] * nums[i];
            }
        }
        return count;
    }

    public String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        System.out.println(map);

        Arrays.sort(heights);
        int count = 0;
        String[] str = new String[names.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            str[count++] = map.get(heights[i]);
        }

        return str;

    }

    public String removeKdigits(String num, int k) {
        Stack<Character> nums = new Stack<>();
        for (char c : num.toCharArray()) {
            if (k > 0 && !nums.isEmpty() && c < nums.peek()) {
                nums.pop();
                k--;
            }
            nums.push(c);
        }
        while (k > 0 && !nums.isEmpty()) {
            nums.pop();
            k--;
        }
        System.out.println(nums + ": " + k);
        if (!nums.isEmpty()) {
            if (nums.firstElement() == '0') {
                nums.remove(0);
            }
            return nums.stream()
                    .map(ele -> ele.toString()).collect(Collectors.joining());
        }
        return "0";
    }

    public int trap(int[] height) {
        int totlaHeight = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);

            }
            int right = height[i];
            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            totlaHeight += Math.max(left, right) - height[i];
        }
        return totlaHeight;
    }

    public static void main(String[] args) {

        Leet l = new Leet();
        String[] sortPeople = l.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});

        for (String string : sortPeople) {
            System.out.println(string);
        }
//        int trap = l.trap(new int[]{4, 2, 0, 3, 2, 5});

//        Function<Integer, String> v = s -> s.toString();
//        
//        String apply = v.apply(10);
//        System.out.println(10);
//        Predicate<String> vv = s -> s.contains("abc");
//        
//        System.out.println(vv.test("abcasd"));
//        String removeKdigits = l.removeKdigits("10200", 1);
//        String removeKdigits = l.removeKdigits("1432219", 3);
//        String removeKdigits = l.removeKdigits("10", 1);
//        int sumOfSquares = l.sumOfSquares(new int[]{2, 7, 1, 19, 18, 3});
//        int countTestedDevices = l.countTestedDevices(new int[]{0, 1, 2});
//        int timeRequiredToBuy = l.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0);
//        int countStudents = l.countStudents(new int[]{0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1}, new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0});
//        int countStudents = l.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
//        System.out.println(trap);
//        l.maximumNumberOfStringPairs(new String[]{"cd","ac","dc","ca","zz"});
//        l.maximumNumberOfStringPairs(new String[]{"ab", "ba", "cc"});
//        l.subsetXORSum(new int[]{1, 3});
//        System.out.println(^1);
//        System.out.println(^2);
//        System.out.println(1^3);
//        l.makeGood("Pp");
//        l.makeGood("leEeetcode");
//        l.makeGood("abBAcC");
//        l.maximizeSum(new int[]{1, 2, 3, 4, 5}, 3);
//        l.maximizeSum(new int[]{5, 5, 5}, 2);
//        l.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
//        String s = "(1+(2*3)+((8)/4))+1";
//        l.maxDepth(s);
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
