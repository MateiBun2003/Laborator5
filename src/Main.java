import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Calea către fișierul text
        String fileName = "Lab5";

        Map<String, Integer> wordCount = new HashMap<>();

        try {
            // Crearea unui obiect Scanner pentru citirea fișierului
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNext()) {
                String word = scanner.next();

                // Eliminăm semnele de punctuație și convertim la litera mică
                word = word.replaceAll("[^a-zA-Z]", "").toUpperCase();

                // Verificăm dacă cuvântul este gol după eliminarea semnelor de punctuație
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            // Închidem scanner-ul
            scanner.close();

            // Afișăm rezultatul
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }
    }
}
