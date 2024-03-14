public class CommandLine {
    public static void dictionaryBasic(DictionaryManagement dictionaryManagement, Dictionary dictionary){
        // dictionaryManagement.insertFromCommandline(dictionary);
        dictionaryManagement.insertFromFile(dictionary, "dictionaries.txt");
        DictionaryCommandline.showAllWords(dictionary);
    }
}
