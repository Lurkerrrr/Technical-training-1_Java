package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    void testLambdaCombination() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(10, 20, 30);
        BiFunction<Integer, Integer, Integer> operation = Integer::sum;

        List<Integer> result = IntStream.range(0, Math.min(list1.size(), list2.size()))
                .mapToObj(i -> operation.apply(list1.get(i), list2.get(i)))
                .collect(Collectors.toList());

        List<Integer> expected = List.of(11, 22, 33);
        assertEquals(expected, result);
    }
}

