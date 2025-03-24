import java.util.Scanner;

public class Licznik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tekst:");
        String text = scanner.nextLine();
        scanner.close();

        int wordCount = countWords(text);
        System.out.println("Liczba wyrazów: " + wordCount);
    }

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}