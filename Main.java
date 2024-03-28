import java.io.IOException;

public class Main {
    /**
     * The main function, entry point of the app.
     * @param args default
     * @throws IOException handle exceptions
     */
    public static void main(String[] args) throws IOException {
        System.out.println(API.translate("en", "vi", "HELLo"));
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        CommandLine.dictionaryBasic(dictionaryManagement, dictionary);
    }
}
