package com.example.english.Model;

public class DictionaryLookup extends TrieOperation {
    public static String dictionaryLookup(String searchWord) {
        searchWord = searchWord.toLowerCase().trim();
        TrieNode currentNode = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char x = searchWord.charAt(i);
            if (!currentNode.getTriemap().containsKey(x)) {
                return API.translate("vi", "en", searchWord);
            }
            currentNode = currentNode.getTriemap().get(x);
        }
        if (currentNode.isWordEnd()) {
            return currentNode.getMeaning();
        } else {
            return API.translate("vi", "en", searchWord);
        }
    }
}
