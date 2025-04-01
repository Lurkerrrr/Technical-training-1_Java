package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task3 {
    public static void run() {
        List<Integer> numbers = Arrays.asList(11, 4, 7, 12, 8, 3);

        Optional<Integer> minEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .min(Integer::compareTo);

        System.out.println("Najmniejsza liczba parzysta: " + minEven.orElse(null));
    }
}

