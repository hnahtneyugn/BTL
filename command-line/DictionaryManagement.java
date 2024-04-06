import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    private final Scanner scanner;

    /**
     * Class' constructor.
     */
    public DictionaryManagement() {
        scanner = new Scanner(System.in);
    }

    /**
     * Allow user to choose mode.
     * @return mode to use
     */
    public int appMode() {
        while (true) {
            int mode = scanner.nextInt();
            scanner.nextLine();
            if (0 <= mode && mode <= 9) {
                return mode;
            }
            System.out.println("Hành động không hợp lệ!");
        }
    }

    public int gameMode() {
        while (true) {
            int gameMode = scanner.nextInt();
            scanner.nextLine();
            if (1 <= gameMode && gameMode <= 3) {
                return gameMode;
            }
            System.out.println("Mời bạn chọn lại!");
        }
    }

    /**
     * Receives input from user via command line.
     * @param dictionary store all inserted words
     */
    public void insertFromCommandline(Dictionary dictionary) {
        System.out.println("Nhập vào số lượng từ bạn muốn: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= count; i++) {
            System.out.println("Từ thứ " + i + " mà bạn đã thêm vào");
            System.out.println("Nhập vào từ tiếng anh: ");
            String wordTarget = scanner.nextLine();
            System.out.println("Nhập vào nghĩa tiếng : ");
            String wordExplain = scanner.nextLine();
            Word word = new Word(wordTarget, wordExplain);
            dictionary.addWord(word);
        }
    }

    public void removeDictionary(Dictionary dictionary){
        System.out.println("Nhập vào từ bạn muốn xoá đi: ");
        scanner.nextLine();
        String removeWord = scanner.nextLine();
        if (dictionary.getWords().containsKey(removeWord)){
            dictionary.getWords().remove(removeWord);
            System.out.println("Từ đã được xoá thành công!");
        }else{
            System.out.println("Từ này không tồn tại trong từ điển!");
        }
    }

    public void updateDictionary(Dictionary dictionary){
        System.out.println("Nhập vào từ bạn muốn sửa: ");
        scanner.nextLine();
        String updateWord = scanner.nextLine();
        String updateMeaning;
        if (dictionary.getWords().containsKey(updateWord)){
            System.out.println(updateWord + " nghĩa là " + dictionary.getWords().get(updateWord));
            System.out.println("Thay đổi nghĩa của từ này thành: ");
            updateMeaning = scanner.nextLine();
            dictionary.getWords().put(updateWord, updateMeaning);
        }else{
            System.out.println("Từ này không tồn tại trong từ điển! Hãy thử lại! ");
        }
    }


    /**
     * Returns the meaning of a word.
     * @param dictionary stores all words
     */
    public void dictionaryLookup(Dictionary dictionary) {
        boolean check = true;
        while(check){
            System.out.println("Bạn muốn tra từ bằng phương thức nào:");
            System.out.println("1. Tra từ bằng từ điển của chúng tôi");
            System.out.println("2. Tra từ bằng API translate");
            int mode = scanner.nextInt();
            scanner.nextLine();
            switch (mode) {
                case 1:
                    System.out.println("Nhập từ cần tra nghĩa: ");
                    String lookupWord = scanner.nextLine();
                    if(dictionary.getWords().containsKey(lookupWord)){
                        System.out.println("Từ này có nghĩa là: " + dictionary.getWords().get(lookupWord));
                    }else{
                        System.out.println("Từ này không tồn tại trong từ điển! Hãy thử lại! ");
                    }
                    check = false;
                    break;
                case 2:
                    System.out.println("Nhập từ cần tra nghĩa: ");
                    String text = scanner.nextLine();
                    System.out.println("Từ này có nghĩa là: " + API.translate("en", "vi", text));
                    check = false;
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        }
    }

    /**
     * Search all the words that begin with certain characters.
     * @param dictionary stores all words
     */
    public void dictionarySearcher(Dictionary dictionary) {
        System.out.println("Nhập từ cần tìm kiếm: ");
        scanner.nextLine();
        String searchWord = scanner.nextLine();
        for (String word : dictionary.getWords().keySet()) {
            if (word.startsWith(searchWord)) {
                System.out.println(word);
            }
        }
    }

    public void playGame(Dictionary dictionary) throws IOException {
        insertFromFile(dictionary, "dictionaries.txt");
        System.out.println("Chọn game của bạn (1-3): ");
        System.out.println("Game 1: Đoán từ tiếng Anh!\nGame 2: Đoán chữ cái còn thiếu!\nGame 3: Chọn đáp án chính xác!");
        int gameMode = gameMode();
        switch(gameMode) {
            case 1:
                Game1 game1 = new Game1(dictionary);
                game1.question();
                break;
            case 2:
                Game2 game2 = new Game2(dictionary);
                game2.question();
                break;
            case 3:
                Game3 game3 = new Game3(dictionary);
                game3.question();
                break;
        }

    }

    /**
     * Receives dictionary data from a text file.
     * @param dictionary stores all words.
     * @param filename   database
     * @throws IOException handle exceptions
     */
    public void insertFromFile(Dictionary dictionary, String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+", 2);
            String englishWord = parts[0].trim();
            String vietnameseWord = parts[1].trim();
            Word word = new Word(englishWord, vietnameseWord);
            dictionary.addWord(word);
        }
        System.out.println("Danh sách các từ trong file đã được thêm vào từ điển!");
        br.close();
    }

    /**
     * Export all data in the current dictionary to a new txt file.
     * @param dictionary stores all words
     * @throws IOException handle exceptions
     */
    public void dictionaryExportToFile(Dictionary dictionary) throws IOException {
        FileWriter fw = new FileWriter("user.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int countWords = 0;
        bw.write("No\t|\tEnglish\t|\tVietnamese\n");
        for (String word : dictionary.getWords().keySet()) {
            bw.write(Integer.toString(countWords + 1));
            bw.write("\t\t");
            bw.write(word);
            bw.write("\t\t");
            bw.write(dictionary.getWords().get(word));
            bw.write("\n");
            countWords++;
        }
        System.out.println("Danh sách các từ trong từ điển đã được xuất ra file!");
        bw.close();
    }


    /**
     * Allow user to choose which mode/function to call conveniently.
     * @param dictionary stores all words
     * @throws IOException handle exceptions
     */
    public void dictionaryAdvanced(Dictionary dictionary) throws IOException {
        while (true) {
            Messages.printMenu();
            int mode = appMode();
            switch (mode) {
                case 0:
                    System.out.println("Xin chào và hẹn gặp lại!");
                    System.exit(0);
                    break;
                case 1:
                    insertFromCommandline(dictionary);
                    break;
                case 2:
                    removeDictionary(dictionary);
                    break;
                case 3:
                    updateDictionary(dictionary);
                    break;
                case 4:
                    DictionaryCommandline.showAllWords(dictionary);
                    break;
                case 5:
                    dictionaryLookup(dictionary);
                    break;
                case 6:
                    dictionarySearcher(dictionary);
                    break;
                case 7:
                    playGame(dictionary);
                    break;
                case 8:
                    insertFromFile(dictionary, "dictionaries.txt");
                    break;
                case 9:
                    dictionaryExportToFile(dictionary);
                    break;
            }
            System.out.println("Nhấp Enter để kết thúc chương trình!");
            scanner.nextLine();
        }
    }
}
