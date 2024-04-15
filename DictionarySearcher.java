import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DictionarySearcher extends TrieOperation {
    
    public static void fill(TrieNode currentNode, ArrayList<String> store, String prefix) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.isWordEnd()) {
            store.add(prefix);
        }
        List<Character> keys = new ArrayList<>(currentNode.getTriemap().keySet());
        Collections.sort(keys);
        for (char x : keys) {
            fill(currentNode.getTriemap().get(x), store, prefix + x);
        }
    }

    public static ArrayList<String> autocomplete(String lookupWord) {
        ArrayList<String> store = new ArrayList<>();
        TrieNode currentNode = root;
        for (int i = 0; i < lookupWord.length(); i++) {
            char x = lookupWord.charAt(i);
            if (currentNode.getTriemap().containsKey(x)) {
                currentNode = currentNode.getTriemap().get(x);
            } else {
                System.out.println("Không tìm thấy từ nào như này: " + lookupWord.substring(0, i));
                return store;
            }
        }
        System.out.println("Những từ bắt đầu bằng chữ này: " + lookupWord);
        fill(currentNode, store, lookupWord);
        return store;
    }
    public static void search () {
        while (true) {
            System.out.println("Nhập từ cần tìm kiếm: ");
            String lookupWord = scanner.nextLine().toLowerCase().trim();
            if (isAllLetters(lookupWord)) {
                for (String word : autocomplete(lookupWord)) {
                    System.out.println(word);
                }
                break;
            } else {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }
}
