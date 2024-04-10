public class DisplayDictionary extends DictionaryManagement {
    public static void displayDictionary() {
        int countWords = 1;
        for (String wordTarget : dictionary.keySet()) {
            System.out.println(countWords + ". " + wordTarget);
            System.out.println(dictionary.get(wordTarget));
            countWords++;
        }
    }
}
