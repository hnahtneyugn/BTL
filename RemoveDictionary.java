public class RemoveDictionary extends DictionaryManagement {
    public static void removeDictionary() {
        while (true) {
            System.out.println("Nhập vào từ bạn muốn xoá đi: ");
            String removeWord = scanner.nextLine().toLowerCase().trim();
            if (isAllLetters(removeWord)) {
                if (dictionary.containsKey(removeWord)) {
                    dictionary.remove(removeWord);
                    System.out.println("Từ đã được xoá thành công!");
                } else {
                    System.out.println("Từ này không tồn tại trong từ điển!");
                }
                break;
            } else {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }
}
