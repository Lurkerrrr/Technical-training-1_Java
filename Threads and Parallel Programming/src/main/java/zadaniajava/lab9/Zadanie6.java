package zadaniajava.lab9;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Zadanie6 {
    public static List<Integer> przetworz(List<Integer> lista1, List<Integer> lista2) throws InterruptedException {
        int rozmiar = lista1.size();
        int podzial = 5;
        int krok = rozmiar / podzial;
        List<Future<List<Integer>>> wyniki = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(podzial);

        for (int i = 0; i < podzial; i++) {
            int start = i * krok;
            int end = (i == podzial - 1) ? rozmiar : (i + 1) * krok;
            wyniki.add(executor.submit(() -> {
                List<Integer> czesc = new ArrayList<>();
                for (int j = start; j < end; j++) {
                    czesc.add(lista1.get(j) + lista2.get(j));
                }
                return czesc;
            }));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        List<Integer> wynik = new ArrayList<>();
        for (Future<List<Integer>> future : wyniki) {
            try {
                wynik.addAll(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return wynik;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista1 = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        List<Integer> lista2 = IntStream.range(100, 120).boxed().collect(Collectors.toList());

        List<Integer> wynik = przetworz(lista1, lista2);
        System.out.println("Wynik końcowy: " + wynik);
    }
}

