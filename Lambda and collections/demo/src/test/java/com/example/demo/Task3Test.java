package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void testMinEvenNumber() {
        List<Integer> input = List.of(7, 4, 9, 12, 6);
        Optional<Integer> minEven = input.stream()
                .filter(n -> n % 2 == 0)
                .min(Integer::compareTo);

        assertTrue(minEven.isPresent());
        assertEquals(4, minEven.get());
    }
}

