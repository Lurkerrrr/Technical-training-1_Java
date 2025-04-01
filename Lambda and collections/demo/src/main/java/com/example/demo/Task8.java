package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Task8 {
    public static void run() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40);

        BiFunction<Integer, Integer, Integer> operation = (a, b) -> a + b;

        List<Integer> result = IntStream.range(0, Math.min(list1.size(), list2.size()))
                .mapToObj(i -> operation.apply(list1.get(i), list2.get(i)))
                .collect(Collectors.toList());

        System.out.println("Wynikowa kolekcja: " + result);
    }
}

