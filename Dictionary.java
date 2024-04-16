import java.util.LinkedHashMap;

public class Dictionary {
    protected static String wordTarget;
    protected static String wordExplain;
    protected final static LinkedHashMap<String, String> dictionary = new LinkedHashMap<>();
    protected final static LinkedHashMap<String, String> dictionaryGame = new LinkedHashMap<>();

    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public final static void addWord(String wordTarget, String wordExplain) {
        dictionary.put(wordTarget, wordExplain);
    }

    public final static void addWordGame(String wordTarget, String wordExplain) {
        dictionaryGame.put(wordTarget, wordExplain);
    }

    public LinkedHashMap<String, String> getDictionary() {
        return dictionary;
    }

    public LinkedHashMap<String, String> getDictionaryGame() {
        return dictionaryGame;
    }
}
