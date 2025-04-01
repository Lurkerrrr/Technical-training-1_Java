package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static void run() {
        List<Person> people = Arrays.asList(
                new Person("Anna", "Nowak", 1990),
                new Person("Kamil", "Kowalski", 1985),
                new Person("Ola", "Wiśniewska", 2000)
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj rok: ");
        int year = scanner.nextInt();

        System.out.println("Osoby urodzone po " + year + ":");
        people.stream()
                .filter(p -> p.getYearOfBirth() > year)
                .forEach(System.out::println);
    }
}

