/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author hkorada
 */
public class practise {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        
        System.out.println(pq);
        
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

    }

    public static void test6() {
        int i = 15623;
        
        Integer collect = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(collect);

        String s1 = "RaceCar";
        String s2 = "CarRace";

        boolean equalsIgnoreCase = Stream.of(s1.split("")).map(String::toUpperCase).sorted()
                .collect(Collectors.joining()).equalsIgnoreCase(Stream.of(s2.split(""))
                        .map(String::toUpperCase).sorted().collect(Collectors.joining()));
        System.out.println(equalsIgnoreCase);

        System.out.println("==========================");

        List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(":::::::; " + listOfIntegers1.stream().sorted().limit(3).collect(Collectors.toList()));
        System.out.println(":::::::; " + listOfIntegers1.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));

        int[] a = new int[]{4, 2, 5, 1};

        int[] b = new int[]{8, 3, 5, 5};

        int[] toArray = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct()
                .toArray();
        System.out.println(Arrays.toString(toArray));

        System.out.println("==========================");

        List<Integer> listOfIntegers = Arrays.asList(45, 2, 56, 15, 24, 75, 31, 89);
        Integer get = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        Integer min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(get + " :: " + min);
    }

    public static void test5() {
        System.out.println("==========================");
        List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        listOfIntegers2.stream().filter(ele -> ele % 5 == 0).forEach(System.out::println);

        System.out.println("==========================");

        List<String> listOfStrings2 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        System.out.println("l == " + listOfStrings2.stream().collect(Collectors.joining(",", "[", "]")));

        System.out.println("==========================");
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        System.out.println(decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        System.out.println("==========================");
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

        Map<String, Long> collect4 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect4);

        System.out.println("==========================");
        String inputString = "Java Concept Of The Day";

        Map<Character, Long> collect2 = inputString.chars()
                .mapToObj(ele -> (char) ele).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect2);

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

        List<String> collect1 = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        Map<Boolean, List<Integer>> collect = listOfIntegers.stream().collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        System.out.println(collect);
    }

    public static void test4() {
        LocalDate birthDay = LocalDate.of(1991, 07, 21);

        System.out.println(ChronoUnit.YEARS.between(birthDay, LocalDate.now()));

        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

        LinkedHashMap<String, Long> linkedMap = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        String get = linkedMap.entrySet().stream().filter(ele -> ele.getValue() > 1).map(ele -> ele.getKey()).findFirst().get();
        String get1 = linkedMap.entrySet().stream().filter(ele -> ele.getValue() == 1).map(ele -> ele.getKey()).findFirst().get();

        System.out.println("get " + get);
        System.out.println("get1 " + get1);

        System.out.println(linkedMap);

        System.out.println("====================================");

        Set<String> uniqueElements1 = new HashSet<>();

        String collect = Arrays.stream(inputString.split("")).filter(ele -> !uniqueElements1.add(ele)).collect(Collectors.joining(","));
        System.out.println(collect);

        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> uniqueElements = new HashSet<>();

        List<Integer> duplicateElements = listOfIntegers.stream().filter(ele -> !uniqueElements.add(ele)).collect(Collectors.toList());

        System.out.println("collect " + duplicateElements);

        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

        listOfStrings.stream().filter(word -> Character.isDigit(word.charAt(0))).forEach(System.out::println);
    }

    public static void test3() {
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");

        Map<String, Long> collect = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map.Entry<String, Long> get = collect.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(get);

        int[] array = new int[]{5, 1, 7, 3, 9, 6};

        System.out.println(Arrays.toString(IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray()));

        System.out.println("===============================");

        int sum = IntStream.range(1, 11).sum();
        System.out.println(sum);
    }

    public static void test2() {
        String str = "Java Concept Of The Day";

        String strReverse = Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));

        System.out.println("strReverse " + strReverse);

        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        list1.stream().filter(list2::contains).forEach(System.out::println);

        System.out.println("===============================");
        int[] a = new int[]{45, 12, 56, 15, 24, 75, 31, 89};

        System.out.println("sum " + Arrays.stream(a).sum());
        System.out.println("average " + Arrays.stream(a).average());

        System.out.println("============================");

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        listOfStrings.stream().sorted(Comparator.comparing(String::toUpperCase)).forEach(System.out::println);

        System.out.println("============================");

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        Integer get = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println("get " + get);

        System.out.println("============================");
        int i = 15623;

        Integer collect = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));

        System.out.println(collect);
        String s1 = "RaceCar";
        String s2 = "CarRace";
//
        String collect1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String collect2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
//
//
        System.out.println(collect1);
        System.out.println("=======================");
        System.out.println(collect2);
//        test();
    }

    public static void test() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("======================");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }

    public static void intstreamExamples() {
        //        getOddAndEvenNumbers();
//        removeduplicates();
//        findFrequency();
//        sortOrder();
//        addparanthesis();
        int[] a = new int[]{9, 1};

        int[] b = new int[]{8, 3, 9, 1};

        int[] toArray = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().toArray();

        System.out.println(Arrays.toString(toArray));
        System.out.println("===============================");
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        listOfIntegers.stream().filter(ele -> ele % 5 == 0).forEach(System.out::println);

        Integer min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        Integer max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();

        System.out.println(min + " ::: " + max);
    }

    public static void addparanthesis() {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String collect = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    public static void getOddAndEvenNumbers() {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        List<Integer> collect = listOfIntegers.stream().filter(ele -> ele % 2 == 0).collect(Collectors.toList());

        System.out.println(collect);

        Map<Boolean, List<Integer>> collect1 = listOfIntegers.stream().collect(Collectors.partitioningBy(ele -> ele % 2 == 0));

        for (Map.Entry<Boolean, List<Integer>> entry : collect1.entrySet()) {
            if (entry.getKey()) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
            entry.getValue().stream().forEach(System.out::println);
        }
    }

    public static void removeduplicates() {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> collect = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println("collect " + collect);

    }

    public static void findFrequency() {

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

        Map<String, Long> collect1 = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("collect1 " + collect1);

        String inputString = "Java Concept Of The Day";

        Map<Character, Long> collect = inputString.chars()
                .mapToObj(ele -> (char) ele)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

    }

    public static void sortOrder() {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("===============");
        decimalList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

}
