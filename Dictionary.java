import java.util.LinkedHashMap;

public class Dictionary {
    private final LinkedHashMap<String, String> dictionary;

    /**
     * Class' constructor to initialize dictionary in the form of a HashMap.
     */
    public Dictionary() {
        dictionary = new LinkedHashMap<>();
    }

    /**
     * Adds a new word into the dictionary.
     * @param word word to add
     */
    public void addWord(Word word) {
        dictionary.put(word.getWordTarget(), word.getWordExplain());
    }

    /**
     * Gets the dictionary for other usages.
     * @return the dictionary
     */
    public LinkedHashMap<String, String> getWords() {
        return dictionary;
    }
}
