package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void testPeopleBornAfterYear() {
        List<Person> people = List.of(
                new Person("A", "A", 1980),
                new Person("B", "B", 2000),
                new Person("C", "C", 1995)
        );

        int year = 1990;
        List<Person> result = people.stream()
                .filter(p -> p.getYearOfBirth() > year)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(p -> p.getYearOfBirth() > 1990));
    }
}

