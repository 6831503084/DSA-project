import java.util.*;

public class WordManager {
    private ArrayList<String> words;

    public WordManager() {
        words = new ArrayList<>(Arrays.asList(
                "apple", "banana", "grape", "orange"
        ));
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void viewWords() {
        System.out.println("\nWords List:");
        for (String w : words) {
            System.out.println("- " + w);
        }
    }

    public void addWord(String word) {
        words.add(word.toLowerCase());
        System.out.println("Word added!");
    }

    public void removeWord(String word) {
        if (words.remove(word.toLowerCase())) {
            System.out.println("Word removed!");
        } else {
            System.out.println("Word not found!");
        }
    }
}