public class RemoveDictionary extends TrieOperation {

    public static void remove(String word) {
        TrieNode currentNode = root;
        TrieNode lastNodeVisited = null;
        char lastCharacterVisited = 'a';
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (!currentNode.getTriemap().containsKey(x)) {
                System.out.println("Từ này không tồn tại trong từ điển");
                return;
            } else {
                int count = currentNode.getTriemap().size();
                if (count > 1) {
                    lastNodeVisited = currentNode;
                    lastCharacterVisited = x;
                }
                currentNode = currentNode.getTriemap().get(x);
            }
        }
        if (currentNode.getTriemap().isEmpty()) {
            currentNode.setWordEnd(false);
            return;
        }
        if (lastNodeVisited != null) {
            lastNodeVisited.getTriemap().remove(lastCharacterVisited);
            return;
        }
        root.getTriemap().remove(word.charAt(0));
    }

    public static void removeDictionary() {
        while (true) {
            System.out.println("Nhập vào từ bạn muốn xoá đi: ");
            String removeWord = scanner.nextLine().toLowerCase().trim();
            if (isAllLetters(removeWord)) {
                remove(removeWord);
                break;
            } else {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }
}
