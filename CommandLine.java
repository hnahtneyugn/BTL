public class CommandLine {
    public static void dictionaryBasic(DictionaryManagement dictionaryManagement, Dictionary dictionary){
        dictionaryManagement.insertFromCommandline(dictionary);
        DictionaryCommandline.showAllWords(dictionary);
    }
}
