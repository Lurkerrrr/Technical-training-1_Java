package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    public static void run() {
        List<Person> people = Arrays.asList(
                new Person("Anna", "Nowak", 1990),
                new Person("Antek", "Kowalski", 1992),
                new Person("Katarzyna", "Kowalczyk", 1988),
                new Person("Andrzej", "Adamski", 1980)
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj początek imienia: ");
        String prefix = scanner.nextLine().toLowerCase();

        long count = people.stream()
                .filter(p -> p.getFirstName().toLowerCase().startsWith(prefix))
                .count();

        System.out.println("Liczba pasujących osób: " + count);
    }
}

