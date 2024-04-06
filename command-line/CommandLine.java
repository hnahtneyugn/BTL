import java.io.IOException;

public class CommandLine {
    /**
     * Controls the programs' stream.
     * @param dictionaryManagement class with features
     * @param dictionary store words
     * @throws IOException handle exceptions
     */
    public static void dictionaryBasic(DictionaryManagement dictionaryManagement, Dictionary dictionary) throws IOException {
        dictionaryManagement.dictionaryAdvanced(dictionary);
    }
}
