import java.io.*;
public class InsertFromFile extends DictionaryManagement{
    /**
     * Receives dictionary data from a text file.
     * @param dictionary stores all words.
     * @param filename   database
     * @throws IOException handle exceptions
     */
    public static void insertFromFile() throws IOException {
        System.out.println("File txt đầu vào phải có định dạng mỗi dòng chứa từ tiếng anh và giải thích tiếng việt (ngăn cách nhau bằng dấu tab).");
        while (true) {
            try {
                String filename = scanner.nextLine();
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\s+", 2);
                    String englishWord = parts[0].toLowerCase().trim();
                    String vietnameseWord = parts[1].toLowerCase().trim();
                    addWord(englishWord, vietnameseWord);
                }
                System.out.println("Danh sách các từ trong file đã được thêm vào từ điển!");
                br.close();
                break;
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi trong quá trình truyền từ file vào từ điển!");
            }
        }

    }
}
