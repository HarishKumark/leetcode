/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author hkorada
 */
public class Example {

    public static void main(String[] args) {

        List<String> supplierNames = Arrays.asList("sp1", "sup2", "sp3", "sup4", "sup5", "sup6", "sup7");

        String v = supplierNames.stream().filter(ele -> ele.length() > 3).map(ele -> ele.toUpperCase()).collect(Collectors.joining(","));
        System.out.println("question 1 " + v);

        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, -1, 32, 7, 8, 9);
        List<Integer> asListNew = asList.stream().filter(val -> {
            return val % 2 == 0;
        }).map(e -> e * e).collect(Collectors.toList());
        System.out.println("question 2 : " + asListNew);

        OptionalInt max = asList.stream().mapToInt(ele -> ele).max();
        System.out.println("question 3 : " + max.getAsInt());

        Integer min = asList.stream().mapToInt(ele -> ele).min().orElseThrow(NoSuchElementException::new);
        System.out.println("question 4 : " + min);

        List<String> names = Arrays.asList("test", "test", "test", "test1", "test1", "test1", "test1");
        Map<String, Long> collect = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("question 5 : " + collect);

        //Calculate the average of a list of numbers using streams.
        double avg = asList.stream().mapToDouble(Integer::doubleValue).average().orElse(.0);
        System.out.println("question 6 : " + avg);
        
        List<Integer> duplicateList = Arrays.asList(1, 1, 3, 3, 5, 7, 8, 32, 7, 8, 9);
        List<Integer> collect1 = duplicateList.stream().distinct().collect(Collectors.toList());
        System.out.println("question 7 : " + collect1);
        
        List<Integer> collect2 = duplicateList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("question 8 : " + collect2);
        
        //Flatten a list of lists into a single list using streams.
        

    }

}
