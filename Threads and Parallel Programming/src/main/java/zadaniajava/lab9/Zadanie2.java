package zadaniajava.lab9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.CompletableFuture;

public class Zadanie2 {
    public static boolean czyPierwsza(int n) {
        if (n < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0);
    }

    public static List<Integer> znajdzPierwsze(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .parallel()
                .filter(Zadanie2::czyPierwsza)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() -> znajdzPierwsze(10, 50));
        future.thenAccept(lista -> System.out.println("Liczby pierwsze: " + lista));
        future.join();
    }
}

