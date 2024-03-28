/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author hkorada
 */
//https://medium.com/techie-delight/500-data-structures-and-algorithms-practice-problems-35afe8a1e222
public class Medium {

    static class Product {

        String name;
        int id;

        public Product(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static void main(String[] args) {

        List<Product> asList = Arrays.asList(new Product("product1", 1),
                new Product("product2", 2),
                new Product("product3", 3),
                new Product("product4", 4));

        List<String> collect = asList.stream().map(Product::getName).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

        String collect1 = asList.stream().map(Product::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect1);

        Double collect2 = asList.stream().collect(Collectors.averagingInt(Product::getId));
        System.out.println("collect2 : " + collect2);

        IntSummaryStatistics collect3 = asList.stream().collect(Collectors.summarizingInt(Product::getId));
        System.out.println("collect3 : " + collect3);
        
        Integer collect4 = asList.stream().collect(Collectors.summingInt(Product::getId));
        System.out.println("collect4 : " + collect4);
        
        
//        Stream<String> filter = Stream.of("a", "b", "c").filter(e -> e.equalsIgnoreCase("b"));
//        System.out.println(filter.findAny().get());
//        System.out.println(filter.findFirst().get());
//        IntStream.rangeClosed(1, 4).forEach(System.out::println);
//        //1,2,3,4
//        OptionalInt reduced
//                = IntStream.rangeClosed(1, 4).reduce((a, b) -> a + b);
//        System.out.println("reduced " + reduced);
//
//        int reduce = IntStream.rangeClosed(1, 3).reduce(10, (a, b) -> a + b);
//
//        System.out.println(reduce);
//        IntStream range = IntStream.range(1, 10);
//        range.forEach(System.out::println);
//        Random r = new Random();
//        r.doubles(3).forEach(System.out::println);
//        "abc".lines().forEach(System.out::println);
//        Stream<String> limit = Stream.generate(()-> "ele").limit(10);
//        limit.forEach(System.out::println);
//        System.out.println("limit "+limit);
//        //Find a pair with the given sum in an array
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int target = 10;
//        Medium m = new Medium();
//        m.removeDuplicates(nums);
//        System.out.println("bol : " + m.ValidParentheses("()"));
//        m.findPair(nums, target);
//        System.out.println("========");
//        m.findPairAnotherApproach(nums, target);
    }

    public Medium() {
    }

    public int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        System.out.println(i);
        return i + 1;

    }

    public boolean ValidParentheses(String str) {
        Stack<Character> s = new Stack<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {

                if (Objects.equals(map.get(str.charAt(i)), s.peek())) {
                    s.pop();
                }
            }
        }
        return s.empty();
//        System.out.println("pop  : " + s.pop());
//
//        System.out.println(s);
//        System.out.println(s.peek());

    }

    //0,0,1,1,1,2,2,3,3,4
    public void findPair(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if ((num + num2) == target) {
                    System.out.println(num + ", " + num2);
                }
            }
        }
    }

    public void findPairAnotherApproach(int[] nums, int target) {
//1,2,3,5,7,8
//0,1,2,3,4,5
        Arrays.sort(nums);
        int last = nums.length - 1;
        int first = 0;
        while (first < last) {
            if (nums[first] + nums[last] == target) {
                System.out.println(nums[first] + " , " + nums[last]);
            }

            if (nums[first] + nums[last] < target) {
                first++;
            } else {
                last--;
            }
        }
    }

}
