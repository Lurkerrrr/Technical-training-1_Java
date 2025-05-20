package zadaniajava.lab9;

import java.util.List;
import java.util.stream.Collectors;

public class Zadanie4 {
    public static void main(String[] args) {
        List<Osoba> lista = List.of(
                new Osoba("Jan", "Kowalski", 1980),
                new Osoba("Anna", "Nowak", 2000),
                new Osoba("Piotr", "Zalewski", 1995)
        );

        int rok = 1990;

        List<Osoba> wynik = lista.parallelStream()
                .filter(o -> o.rokUrodzenia > rok)
                .collect(Collectors.toList());

        System.out.println("Osoby urodzone po " + rok + ": " + wynik);
    }
}

