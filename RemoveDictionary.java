public class RemoveDictionary extends TrieOperation {

    public static void removeHelp(String removeWord) {
        TrieNode currentNode = root;
        TrieNode lastNodeVisited = null;
        char lastCharacterVisited = 'a';
        for (int i = 0; i < removeWord.length(); i++) {
            char x = removeWord.charAt(i);
            if (!currentNode.getTriemap().containsKey(x)) {
                System.out.println("Từ bạn muốn xóa không tồn tại trong từ điển");
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
        root.getTriemap().remove(removeWord.charAt(0));
    }

    public static void removeDictionary() {
        System.out.println("Nhập vào từ tiếng anh bạn muốn xóa: ");
        String removeWord = scanner.nextLine().toLowerCase().trim();
        removeHelp(removeWord);
    }

}
