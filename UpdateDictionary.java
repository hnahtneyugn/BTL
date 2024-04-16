public class UpdateDictionary extends TrieOperation {

    public static void updateDictionary() {
        System.out.println("Nhập vào từ tiếng anh bạn muốn sửa: ");
        String updateWord = scanner.nextLine().toLowerCase().trim();
        if (searchTrie(updateWord) != null) {
            System.out.println("Nhập vào thông tin của từ tiếng anh bạn muốn sửa: ");
            String updateMeaning = scanner.nextLine().toLowerCase().trim();
            searchTrie(updateWord).setMeaning(updateMeaning + "\n");
        } else {
            System.out.println("Từ bạn muốn sửa không tồn tại trong từ điển");
        }
    }

}
