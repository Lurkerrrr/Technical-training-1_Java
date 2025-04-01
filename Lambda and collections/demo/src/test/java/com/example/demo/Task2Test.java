package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void testEvenNumbersFiltering() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> expected = List.of(2, 4, 6);

        List<Integer> result = input.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        assertEquals(expected, result);
    }
}

