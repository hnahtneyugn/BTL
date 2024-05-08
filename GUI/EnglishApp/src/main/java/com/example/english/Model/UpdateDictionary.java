package com.example.english.Model;

public class UpdateDictionary extends TrieOperation {
    public static void updateDictionary(String updateWord, String updateWordMeaning) {
        TrieNode currentNode = root;
        for (int i = 0; i < updateWord.length(); i++) {
            char x = updateWord.charAt(i);
            if (!currentNode.getTriemap().containsKey(x)) {
                return;
            }
            currentNode = currentNode.getTriemap().get(x);
        }
        if (currentNode.isWordEnd()) {
            currentNode.setMeaning(updateWordMeaning + "\n");
        }
    }
}
