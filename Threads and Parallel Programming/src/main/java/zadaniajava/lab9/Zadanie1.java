package zadaniajava.lab9;

import java.util.concurrent.CompletableFuture;

public class Zadanie1 {
    public static int dlugaOperacja(int a, int b) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return a * b;
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> przyszlyWynik = CompletableFuture.supplyAsync(() -> dlugaOperacja(5, 4));
        przyszlyWynik.thenAccept(wynik -> System.out.println("Wynik: " + wynik));
        System.out.println("Trwa operacja...");
        przyszlyWynik.join();
    }
}

