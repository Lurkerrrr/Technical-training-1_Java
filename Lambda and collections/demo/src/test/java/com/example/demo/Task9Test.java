package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {

    @Test
    void testSortByLastNameThenFirstName() {
        List<Person> people = List.of(
                new Person("Zuzanna", "Nowak", 1990),
                new Person("Anna", "Nowak", 1995),
                new Person("Paweł", "Adamski", 1980)
        );

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName))
                .collect(Collectors.toList());

        assertEquals("Adamski", sorted.get(0).getLastName());
        assertEquals("Nowak", sorted.get(1).getLastName());
        assertEquals("Anna", sorted.get(1).getFirstName());
    }
}

