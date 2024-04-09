public class DisplayDictionary extends DictionaryManagement {
    /**
     * Shows all words stored in the current dictionary.
     * 
     * @param dictionary store all words
     */
    public static void displayDictionary() {
        int countWords = 1;
        for (String wordTarget : dictionary.keySet()) {
            System.out.println(countWords + ". " + wordTarget);
            System.out.println(dictionary.get(wordTarget));
            countWords++;
        }
    }
}
