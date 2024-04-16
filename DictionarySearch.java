import java.util.ArrayList;


public class DictionarySearch extends TrieOperation {

    public static void fill(TrieNode currentNode, ArrayList<String> store, String prefix) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.isWordEnd()) {
            store.add(prefix);
        }
        for (char x : currentNode.getTriemap().keySet()) {
            fill(currentNode.getTriemap().get(x), store, prefix + x);
        }
    }

    public static ArrayList<String> autocomplete(String searchWord) {
        TrieNode currentNode = root;
        ArrayList<String> store = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            char x = searchWord.charAt(i);
            if (currentNode.getTriemap().containsKey(x)) {
                currentNode = currentNode.getTriemap().get(x);
            } else {
                return store;
            }
        }
        fill(currentNode, store, searchWord);
        return store;
    }

    public static void searchDictionary() {
        System.out.println("Nhập vào từ tiếng anh bạn muốn tìm kiếm:");
        String searchWord = scanner.nextLine().toLowerCase().trim();
        ArrayList<String> searchResults = autocomplete(searchWord);
        if (searchResults.isEmpty()) {
            System.out.println("Trong từ điển không có từ tiếng anh bắt đầu với " + searchWord);
        } else {
            System.out.println("Danh sách các từ tiếng anh bắt đầu với " + searchWord);
            for (String word : searchResults) {
                System.out.println(word);
            }
        }
    }
}
