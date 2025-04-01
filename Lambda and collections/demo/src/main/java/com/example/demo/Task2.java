package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void run() {
        List<Integer> numbers = Arrays.asList(3, 8, 15, 22, 7, 10);

        System.out.println("Parzyste liczby:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}

