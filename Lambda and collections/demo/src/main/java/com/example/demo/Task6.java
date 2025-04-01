package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task6 {
    public static void run() {
        List<Person> people = Arrays.asList(
                new Person("Anna", "Nowak", 1990),
                new Person("Antek", "Kowalski", 1992),
                new Person("Katarzyna", "Kowalczyk", 1988),
                new Person("Andrzej", "Adamski", 1980)
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj początek imienia (np. 'An'): ");
        String prefix = scanner.nextLine().toLowerCase();

        List<Person> filtered = people.stream()
                .filter(p -> p.getFirstName().toLowerCase().startsWith(prefix))
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());

        System.out.println("Pasujące osoby:");
        filtered.forEach(System.out::println);
    }
}

