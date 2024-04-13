import java.util.*;

public class TrieOperation extends DictionaryManagement {
    private static final TrieNode root = new TrieNode();
    private static final TreeMap<String, String> TrieDictionary = new TreeMap<>(Comparator.naturalOrder());

    public static TrieNode getRoot() {
        return root;
    }

    public TreeMap<String, String> getTrieDictionary() {
        return TrieDictionary;
    }

    public static void insert(String word, String meaning) {
        TrieNode currentNode = root;
        for (int j = 0; j < word.length(); j++) {
            char x = word.charAt(j);

            if (!currentNode.getTriemap().containsKey(x)) {
                currentNode.getTriemap().put(x, new TrieNode());
            }

            currentNode = currentNode.getTriemap().get(x);
        }
        currentNode.setWordEnd(true);
        currentNode.setMeaning(meaning);
    }

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

                    insert(wordTarget, wordExplain);
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }

    public static void search() {
        TrieNode currentNode = root;
        while (true) {
            System.out.println("Nhập từ cần tìm kiếm: ");
            String searchWord = scanner.nextLine().toLowerCase().trim();
            if (isAllLetters(searchWord)) {
                for (int i = 0; i < searchWord.length(); i++) {
                    char x = searchWord.charAt(i);
                    if (!currentNode.getTriemap().containsKey(x)) {
                        System.out.println("Từ này không có trong từ điển");
                        return;
                    }
                    currentNode = currentNode.getTriemap().get(x);
                }

                if (currentNode.isWordEnd()) {
                    System.out.println("Nghĩa của từ này là: " + currentNode.getMeaning());
                } else {
                    System.out.println("Từ này không có ý nghĩa!");
                }
                break;
            } else {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }

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



    public static void lookup() {
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

    private static int wordCount = 1;
    public static void display(TrieNode trieNode, String wordStored) {
        if (trieNode != null && trieNode.getTriemap() != null) {

            for (char x = 0; x < 256; x++) {
                TrieNode childNode = trieNode.getTriemap().get(x);
                if (childNode != null) {
                    String currentWord = wordStored + x;
                    if (childNode.isWordEnd()) {
                        System.out.println(wordCount + ". " + currentWord);
                        System.out.println(childNode.getMeaning());
                        wordCount++;
                    }
                    TrieDictionary.put(currentWord, childNode.getMeaning());
                    display(childNode, currentWord);
                }
            }
        }
    }



}
