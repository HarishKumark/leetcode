/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1;

import java.util.stream.Stream;

/**
 *
 * @author hkorada
 */
public class StreamExamples {
    public static void main(String[] args) {
        
        Stream<String> streamEmpty = Stream.empty();

        System.out.println("streamEmpty "+streamEmpty);
        
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);

        streamIterated.forEach(System.out::println);
    }
}
