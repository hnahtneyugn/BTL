import java.io.*;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    protected static Scanner scanner = new Scanner(System.in);
    
    public static void initializeDictionary() throws IOException {
        FileReader fr = new FileReader("dictionaries.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String wordTarget = "";
        StringBuilder wordExplainBuilder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.startsWith("|")) {
                if (!wordTarget.isEmpty() && !wordExplainBuilder.isEmpty()) {
                    addWord(wordTarget, wordExplainBuilder.toString());
                    wordExplainBuilder.setLength(0);
                }
                wordTarget = line.substring(1).trim();
            } else {
                wordExplainBuilder.append(line.trim()).append("\n");
            }
        }
        if (!wordTarget.isEmpty() && !wordExplainBuilder.isEmpty()) {
            addWord(wordTarget, wordExplainBuilder.toString());
        }
        br.close();
    }

    public static void saveDictionary() throws IOException{
        FileWriter fw = new FileWriter("dictionaries.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (String wordTarget : dictionary.keySet()) {
            bw.write("|");
            bw.write(wordTarget);
            bw.write("\n");
            bw.write(dictionary.get(wordTarget));
        }
        bw.close();
    }
    public static void printMenu() {
        System.out.println("Chào mừng đến với app học tập của chúng tôi!");
        System.out.println("[0] Thoát");
        System.out.println("[1] Thêm từ");
        System.out.println("[2] Xoá từ");
        System.out.println("[3] Sửa từ");
        System.out.println("[4] Hiện tất cả từ trong từ điển");
        System.out.println("[5] Tra từ");
        System.out.println("[6] Tìm kiếm");
        System.out.println("[7] Game");
        System.out.println("[8] Nhập vào từ file");
        System.out.println("[9] Xuất ra file");
        System.out.println("Lựa chọn của bạn: ");
    }

    public static int appMode() {
        while (true) {
            try {
                int mode = scanner.nextInt();
                scanner.nextLine();
                if (0 <= mode && mode <= 9) {
                    return mode;
                }
                System.out.println("Hành động bạn chọn không được hỗ trợ!");
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }

    public static boolean isAllLetters(String string) {
        for (char x : string.toCharArray()) {
            if (!Character.isLetter(x)) {
                return false;
            }
        }
        return true;
    }

    public static void dictionaryAdvanced() throws IOException {
        InitializeTrie.createTrie();
        while (true) {
            printMenu();
            int mode = appMode();
            switch (mode) {
                case 0:
                    System.out.println("Xin chào và hẹn gặp lại!");
                    saveDictionary();
                    System.exit(0);
                    break;
                case 1:
                    TrieOperation.insertFromCommandline();
                    break;
                case 2:
                    RemoveDictionary.removeDictionary();
                    break;
                case 3:
                    UpdateDictionary.updateDictionary();
                    break;
                case 4:
                    TrieOperation.display(TrieOperation.getRoot(), "");
                    break;
                case 5:
                    TrieOperation.lookup();
                    break;
                case 6:
                    TrieOperation.search();
                    break;
                case 7:
                    PlayGame.playGame();
                    break;
                case 8:
                    InsertFromFile.insertFromFile();
                    break;
                case 9:
                    DictionaryExportToFile.dictionaryExportToFile();
                    break;
            }
            System.out.println("Nhấp Enter để kết thúc chương trình!");
            scanner.nextLine();
        }
    }
}
