import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InitializeTrie extends TrieOperation {
    public static void createTrie() throws IOException {
        FileReader fr = new FileReader("dictionaries.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String wordTarget = "";
        StringBuilder wordExplainBuilder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.startsWith("|")) {
                if (!wordTarget.isEmpty() && !wordExplainBuilder.isEmpty()) {
                    insertTrie(wordTarget, wordExplainBuilder.toString());
                    wordExplainBuilder.setLength(0);
                }
                wordTarget = line.substring(1).trim();
            } else {
                wordExplainBuilder.append(line.trim()).append("\n");
            }
        }
        if (!wordTarget.isEmpty() && !wordExplainBuilder.isEmpty()) {
            insertTrie(wordTarget, wordExplainBuilder.toString());
        }
        br.close();
    }
}
