import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("Lab5");
            Scanner scanner = new Scanner(file);
            Map<String, Integer> wordCounts = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }

            for (String word: wordCounts.keySet()) {
                System.out.println(word + " apare de " + wordCounts.get(word) + " ori.");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit sau nu conține cuvinte");
        }
    }
}