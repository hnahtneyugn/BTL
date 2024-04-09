public class InsertFromCommandline extends DictionaryManagement{
    /**
     * Receives input from user via command line.
     * @param dictionary store all inserted words
     */
    public static void insertFromCommandline() {
        while (true) {
            try {
                System.out.println("Nhập vào số lượng từ bạn muốn: ");
                int count = scanner.nextInt();
                scanner.nextLine();
                for (int i = 1; i <= count; i++) {
                    System.out.println("Từ thứ " + i + " mà bạn đã thêm vào");
                    System.out.println("Nhập vào từ tiếng anh: ");
                    String wordTarget = scanner.nextLine().toLowerCase().trim();
                    System.out.println("Nhập vào nghĩa tiếng việt: ");
                    String wordExplain = scanner.nextLine().toLowerCase().trim();
                    addWord(wordTarget, wordExplain);
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }


    }
}
