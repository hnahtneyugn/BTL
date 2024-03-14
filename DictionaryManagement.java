import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement {
    private Scanner scanner;

    public DictionaryManagement() {
        scanner = new Scanner(System.in);
    }

    public void insertFromCommandline(Dictionary dictionary) {
        System.out.println("Nhap vao ban phim so luong tu vung: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= count; i++) {
            System.out.println("Tu so " + i + " ban nhap vao");
            System.out.println("Nhap tu tieng Anh: ");
            String wordTarget = scanner.nextLine();
            System.out.println("Nhap giai thich bang tieng Viet: ");
            String wordExplain = scanner.nextLine();
            Word word = new Word(wordTarget, wordExplain);
            dictionary.addWord(word);
        }
    }
    public void insertFromFile(Dictionary dictionary, String filename){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Mỗi dòng trong tệp có định dạng "từ_tiếng_anh\tgiải_thích_tiếng_việt"
                // Chúng ta tách dòng thành từ tiếng Anh và giải thích tiếng Việt
                String[] parts = line.split("\\s+", 2);
                if (true) {
                    String englishWord = parts[0].trim();
                    String vietnameseWord = parts[1].trim();
                    // Thêm từ tiếng Anh và giải thích tiếng Việt tương ứng vào từ điển
                    Word word = new Word(englishWord, vietnameseWord);
                    dictionary.addWord(word);
                }
            }
            System.out.println("Words from file have been inserted into the dictionary!");
        } catch (IOException e) {
            System.err.println("Error!" + e.getMessage());
        }
    }
}
