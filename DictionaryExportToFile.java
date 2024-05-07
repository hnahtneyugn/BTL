import java.io.*;

public class DictionaryExportToFile extends TrieOperation {

    public static void exportToFile(TrieNode trieNode, String wordStored, BufferedWriter bw) throws IOException {
        if (trieNode != null && trieNode.getTriemap() != null) {
            for (char x = 0; x < 256; x++) {
                TrieNode childNode = trieNode.getTriemap().get(x);
                if (childNode != null) {
                    String currentWord = wordStored + x;
                    if (childNode.isWordEnd()) {
                        bw.write(currentWord);
                        bw.write("\n");
                        bw.write(childNode.getMeaning());
                        bw.write("\n");
                    }
                    exportToFile(childNode, currentWord, bw);
                }
            }
        }
    }

    public static void dictionaryExportToFile() throws IOException {
        FileWriter fw = new FileWriter("user.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        exportToFile(root, "", bw);
        System.out.println("Danh sách các từ trong từ điển đã được xuất ra file user.txt");
        bw.close();
    }

}
