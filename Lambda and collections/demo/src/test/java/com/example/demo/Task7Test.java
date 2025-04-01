package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void testCountMatchingPeople() {
        List<Person> people = List.of(
                new Person("Anna", "A", 1990),
                new Person("Antek", "B", 1992),
                new Person("Katarzyna", "C", 1995)
        );

        String prefix = "An";

        long count = people.stream()
                .filter(p -> p.getFirstName().startsWith(prefix))
                .count();

        assertEquals(2, count);
    }
}

