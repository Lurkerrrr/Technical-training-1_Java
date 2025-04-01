package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task9 {
    public static void run() {
        List<Person> people = Arrays.asList(
                new Person("Anna", "Nowak", 1990),
                new Person("Zuzanna", "Nowak", 1988),
                new Person("Paweł", "Adamski", 1995),
                new Person("Kamil", "Adamski", 1980)
        );

        people.stream()
                .sorted(Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName))
                .forEach(System.out::println);
    }
}

