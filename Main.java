import java.io.IOException;

public class Main {
    /**
     * The main function, entry point of the app.
     * @param args default
     * @throws IOException handle exceptions
     */
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        CommandLine.dictionaryBasic(dictionaryManagement, dictionary);
    }
}
