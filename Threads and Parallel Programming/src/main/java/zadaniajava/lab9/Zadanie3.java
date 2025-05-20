package zadaniajava.lab9;

import java.util.List;
import java.util.stream.Collectors;

public class Zadanie3 {
    public static void main(String[] args) {
        List<Integer> liczby = List.of(1, 3, 7, 10, 20, 30, 40);
        int min = 10, max = 30;

        List<Integer> wynik = liczby.parallelStream()
                .filter(n -> n >= min && n <= max)
                .collect(Collectors.toList());

        System.out.println("Liczby w zakresie: " + wynik);
    }
}

