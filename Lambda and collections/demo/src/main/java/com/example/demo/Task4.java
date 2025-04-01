package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void run() {
        List<Integer> numbers = Arrays.asList(2, 5, 10, 15, 20, 25, 30);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj dolny zakres: ");
        int min = scanner.nextInt();

        System.out.print("Podaj górny zakres: ");
        int max = scanner.nextInt();

        System.out.println("Liczby z zakresu [" + min + ", " + max + "]:");
        numbers.stream()
                .filter(n -> n >= min && n <= max)
                .forEach(System.out::println);
    }
}

