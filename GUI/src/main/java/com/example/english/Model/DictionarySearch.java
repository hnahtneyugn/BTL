package com.example.english.Model;

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

    public static ArrayList<String> dictionarySearch(String searchWord) {
        searchWord = searchWord.toLowerCase().trim();
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
}
