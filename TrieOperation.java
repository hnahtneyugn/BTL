import java.io.IOException;
import java.util.*;

public class TrieOperation extends TrieNode {
    protected static TrieNode root = new TrieNode();
    protected static Scanner scanner = new Scanner(System.in);
    public static TrieNode getRoot() {
        return root;
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

    public static void insertTrie(String word, String meaning) {
        TrieNode currentNode = root;
        for (int j = 0; j < word.length(); j++) {
            char x = word.charAt(j);
            if (!currentNode.getTriemap().containsKey(x)) {
                currentNode.getTriemap().put(x, new TrieNode());
            }
            currentNode = currentNode.getTriemap().get(x);
        }
        currentNode.setWordEnd(true);
        currentNode.setMeaning(meaning);
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
                    SaveTrie.saveTrie();
                    System.exit(0);
                case 1:
                    InsertFromCommandline.insertFromCommandline();
                    break;
                case 2:
                    RemoveDictionary.removeDictionary();
                    break;
                case 3:
                    UpdateDictionary.updateDictionary();
                    break;
                case 4:
                    DisplayDictionary.display(root, "");
                    break;
                case 5:
                    DictionaryLookup.dictionaryLookup();
                    break;
                case 6:
                    DictionarySearcher.search();
                    break;
                case 7:
                    // PlayGame.playGame();
                    // break;
                case 8:
                    // InsertFromFile.insertFromFile();
                    // break;
                case 9:
                    // DictionaryExportToFile.dictionaryExportToFile();
                    // break;
            }
            System.out.println("Nhấp Enter để kết thúc chương trình!");
            scanner.nextLine();
        }
    }

}
