public class UpdateDictionary extends TrieOperation {
    public static void updateDictionary() {
        TrieNode currentNode = root;
        while (true) {
            System.out.println("Nhập vào từ bạn muốn sửa: ");
            String updateWord = scanner.nextLine().toLowerCase().trim();
            if (isAllLetters(updateWord)) {
                for (int i = 0; i < updateWord.length(); i++) {
                    char x = updateWord.charAt(i);
                    if (!currentNode.getTriemap().containsKey(x)) {
                        System.out.println("Từ này không tồn tại trong từ điển! Bạn có muốn thêm nó vào từ điển không ?");
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        char choice = scanner.next().charAt(0);
                        scanner.nextLine();
                        if (choice == '1') {
                            System.out.println("Nhập vào nghĩa tiếng việt: ");
                            String updateMeaning = scanner.nextLine().toLowerCase().trim();
                            insertTrie(updateWord, updateMeaning);
                        }
                        return;
                    }
                    currentNode = currentNode.getTriemap().get(x);
                }
                if (currentNode.isWordEnd()) {
                    System.out.println(updateWord + " nghĩa là " + currentNode.getMeaning());
                    System.out.println("Bạn muốn thay đổi nghĩa của từ này thành: ");
                    String updateMeaning = scanner.nextLine().toLowerCase().trim();
                    
                    currentNode.setMeaning(updateMeaning);
                } else {
                    System.out.println("Từ này không tồn tại trong từ điển! Bạn có muốn thêm nó vào từ điển không ?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    char choice = scanner.next().charAt(0);
                    scanner.nextLine();
                    if (choice == '1') {
                        System.out.println("Nhập vào nghĩa tiếng việt: ");
                        String updateMeaning = scanner.nextLine().toLowerCase().trim();
                        insertTrie(updateWord, updateMeaning);
                    }
                    return;
                }
                break;
            } else {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }
}
