/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author hkorada
 */
public class Exmple {

    private static BackgroundThreadRunner ttest = new BackgroundThreadRunner() {
        @Override
        public void function() {
            System.out.println("function");
        }

    };

    static {
        System.out.println("static block");
    }

    private static final HashSet<String> cache = new HashSet<>();

    public static void test() {
        cache.add("test");
        System.out.println("test");
    }

    public void testNor() {
        System.out.println("testNor");
    }

    public static void main(String[] args) {
//        System.out.println("main");
//        Exmple ex = new Exmple();
//        ex.testNor();
//        Exmple.test();
//        System.out.println(cache);
        double avg = Arrays.asList(1,2,3,4,5,6).stream().mapToDouble(Integer::doubleValue).average().orElse(0.);
        
        
        System.out.println("avg "+avg);



    }
}
