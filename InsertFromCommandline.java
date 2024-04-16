public class InsertFromCommandline extends TrieOperation {

    public static void insertFromCommandline() {
        System.out.println("Nhập vào từ tiếng anh bạn muốn thêm:");
        String addWord = scanner.nextLine().toLowerCase().trim();
        if (searchTrie(addWord) == null) {
            System.out.println("Nhập vào thông tin của từ tiếng anh bạn muốn thêm:");
            String addMeaning = scanner.nextLine().toLowerCase().trim();
            insertTrie(addWord, addMeaning + "\n");
        } else {
            System.out.println("Từ bạn muốn thêm đã tồn tại trong từ điển");
        }
    }

}
