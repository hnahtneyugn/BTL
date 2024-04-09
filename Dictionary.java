import java.util.TreeMap;

public class Dictionary {
    protected static String wordTarget;
    protected static String wordExplain;
    protected final static TreeMap<String, String> dictionary = new TreeMap<>();
    protected final static TreeMap<String, String> dictionaryGame = new TreeMap<>();

    /**
     * Get English name.
     * 
     * @return English name
     */
    public String getWordTarget() {
        return wordTarget;
    }

    /**
     * Get Vietnamese definition.
     * 
     * @return Vietnamese definition
     */
    public String getWordExplain() {
        return wordExplain;
    }

    /**
     * Adds a new word into the dictionary.
     * 
     * @param word word to add
     */
    public final static void addWord(String wordTarget, String wordExplain) {
        dictionary.put(wordTarget, wordExplain);
    }

    public final static void addWordGame(String wordTarget, String wordExplain) {
        dictionaryGame.put(wordTarget, wordExplain);
    }

    /**
     * Gets the dictionary for other usages.
     * 
     * @return the dictionary
     */
    public TreeMap<String, String> getDictionary() {
        return dictionary;
    }

    public TreeMap<String, String> getDictionaryGame() {
        return dictionaryGame;
    }
}
