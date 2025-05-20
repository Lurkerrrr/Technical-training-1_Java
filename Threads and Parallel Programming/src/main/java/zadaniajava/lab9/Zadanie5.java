package zadaniajava.lab9;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie5 {
    public static void main(String[] args) {
        List<Osoba> lista = List.of(
                new Osoba("Jan", "Kowalski", 1980),
                new Osoba("Jacek", "Zalewski", 1995),
                new Osoba("Joanna", "Adamska", 2001),
                new Osoba("Anna", "Nowak", 2000)
        );

        String prefix = "Ja";

        List<Osoba> wynik = lista.parallelStream()
                .filter(o -> o.imie.startsWith(prefix))
                .sorted(Comparator.comparing(o -> o.nazwisko))
                .collect(Collectors.toList());

        System.out.println("Osoby z imieniem na \"" + prefix + "\": " + wynik);
    }
}
