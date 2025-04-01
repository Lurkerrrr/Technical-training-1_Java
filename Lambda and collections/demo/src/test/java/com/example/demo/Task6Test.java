package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void testFilterAndSortByNamePrefix() {
        List<Person> people = List.of(
                new Person("Anna", "Nowak", 1990),
                new Person("Andrzej", "Adamski", 1980),
                new Person("Jan", "Zieliński", 1970)
        );

        String prefix = "An";

        List<Person> filtered = people.stream()
                .filter(p -> p.getFirstName().startsWith(prefix))
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());

        assertEquals(2, filtered.size());
        assertEquals("Adamski", filtered.get(0).getLastName());
        assertEquals("Nowak", filtered.get(1).getLastName());
    }
}

