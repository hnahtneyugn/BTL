public class DisplayDictionary extends DictionaryManagement{
    /**
     * Shows all words stored in the current dictionary.
     * @param dictionary store all words
     */
    public static void displayDictionary() {
        System.out.println("No\t|\tEnglish\t|\tVietnamese");
        int countWords = 1;
        for (String wordTarget : dictionary.keySet()) {
            System.out.println(countWords + "\t|\t" + wordTarget + "\t|\t" + dictionary.get(wordTarget));
            countWords++;
        }
    }
}
