import java.io.*;

public class DictionaryExportToFile extends DictionaryManagement{
        /**
     * Export all data in the current dictionary to a new txt file.
     * @param dictionary stores all words
     * @throws IOException handle exceptions
     */
    public static void dictionaryExportToFile() throws IOException {
        FileWriter fw = new FileWriter("user.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int countWords = 1;
        bw.write("No\t|\tEnglish\t|\tVietnamese\n");
        for (String wordTarget : dictionary.keySet()) {
            bw.write(Integer.toString(countWords));
            bw.write("\t\t");
            bw.write(wordTarget);
            bw.write("\t\t");
            bw.write(dictionary.get(wordTarget));
            bw.write("\n");
            countWords++;
        }
        System.out.println("Danh sách các từ trong từ điển đã được xuất ra file!");
        bw.close();
    }
}
