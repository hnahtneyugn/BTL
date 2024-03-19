import java.util.LinkedHashMap;

public class DictionaryCommandline {
    /**
     * Shows all words stored in the current dictionary.
     * @param dictionary store all words
     */
    public static void showAllWords(Dictionary dictionary) {
        LinkedHashMap<String, String> dict = dictionary.getWords();
        System.out.println("No\t|\tEnglish\t|\tVietnamese");

        int countWords = 0;
        for (String word : dict.keySet()) {
            System.out.println((countWords + 1) + "\t|\t" + word + "\t|\t" + dict.get(word));
            countWords++;
        }
    }
}
