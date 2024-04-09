import java.io.*;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    protected static Scanner scanner = new Scanner(System.in);

    public final static void printMenu() {
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

    /**
     * Allow user to choose mode.
     * @return mode to use
     */
    public final static int appMode() {
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
    public final static boolean isAllLetters(String string) {
        for (char x : string.toCharArray()) {
            if (!Character.isLetter(x)) {
                return false;
            }
        }
        return true;
    }

    // /**
    //  * Returns the meaning of a word.
    //  * @param dictionary stores all words
    //  */
    // public void dictionaryLookup() {
    //     boolean check = true;
    //     while(check){
    //         System.out.println("Bạn muốn tra từ bằng phương thức nào:");
    //         System.out.println("1. Tra từ bằng từ điển của chúng tôi");
    //         System.out.println("2. Tra từ bằng API translate");
    //         int mode = scanner.nextInt();
    //         scanner.nextLine();
    //         switch (mode) {
    //             case 1:
    //                 System.out.println("Nhập từ cần tra nghĩa: ");
    //                 String lookupWord = scanner.nextLine().toLowerCase().trim();
    //                 if(dictionary.containsKey(lookupWord)){
    //                     System.out.println("Từ này có nghĩa là: " + dictionary.get(lookupWord));
    //                 }else{
    //                     System.out.println("Từ này không tồn tại trong từ điển! Hãy thử lại! ");
    //                 }
    //                 check = false;
    //                 break;
    //             case 2:
    //                 System.out.println("Nhập từ cần tra nghĩa: ");
    //                 String text = scanner.nextLine().toLowerCase().trim();
    //                 System.out.println("Từ này có nghĩa là: " + API.translate("en", "vi", text));
    //                 check = false;
    //                 break;
    //             default:
    //                 System.out.println("Không hợp lệ. Vui lòng chọn lại!");
    //                 break;
    //         }
    //     }
    // }

    /**
     * Allow user to choose which mode/function to call conveniently.
     * @param dictionary stores all words
     * @throws IOException handle exceptions
     */
    public final static void dictionaryAdvanced() throws IOException {
        // InsertFromFile.insertFromFile("game.txt");
        while (true) {
            printMenu();
            int mode = appMode();
            switch (mode) {
                case 0:
                    System.out.println("Xin chào và hẹn gặp lại!");
                    System.exit(0);
                    break;
                case 1:
                    InsertFromCommandline.insertFromCommandline();;
                    break;
                case 2:
                    RemoveDictionary.removeDictionary();
                    break;
                case 3:
                    UpdateDictionary.updateDictionary();
                    break;
                case 4:
                    DisplayDictionary.displayDictionary();
                    break;
                case 5:
                    // dictionaryLookup();
                    // break;
                case 6:
                    DictionarySearcher.dictionarySearcher();
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
