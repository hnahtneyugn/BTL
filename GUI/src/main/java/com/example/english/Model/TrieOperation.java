package com.example.english.Model;

public class TrieOperation extends TrieNode {
    protected static TrieNode root = new TrieNode();
    public static TrieNode getRoot() {
        return root;
    }
    public final static void insertTrie(String insertWord, String insertMeaning) {
        TrieNode currentNode = root;
        for (int j = 0; j < insertWord.length(); j++) {
            char x = insertWord.charAt(j);
            if (!currentNode.getTriemap().containsKey(x)) {
                currentNode.getTriemap().put(x, new TrieNode());
            }
            currentNode = currentNode.getTriemap().get(x);
        }
        currentNode.setWordEnd(true);
        currentNode.setMeaning(insertMeaning);
    }

    public final static boolean containWord(String searchWord) {
        TrieNode currentNode = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char x = searchWord.charAt(i);
            if (!currentNode.getTriemap().containsKey(x)) {
                return false;
            }
            currentNode = currentNode.getTriemap().get(x);
        }
        if (currentNode.isWordEnd()) {
            return true;
        } else {
            return false;
        }
    }
}
