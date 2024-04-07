package B_ComparadorYContador;

import java.util.HashMap;
import java.util.Map;

public class AnalizadorDeTexto {

    public static Map<String, Integer> analyzeText(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split("\\s+"); // Divide el texto en palabras

        for (String word : words) {
            word = word.toLowerCase(); // Considera las palabras de manera insensible a mayúsculas
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    // Método para contar el número total de palabras
    public static int totalWords(String text) {
        return text.split("\\s+").length;
    }
}