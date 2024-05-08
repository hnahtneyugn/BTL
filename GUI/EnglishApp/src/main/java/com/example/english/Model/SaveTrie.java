package com.example.english.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTrie extends TrieOperation {
    public static void saveTrie(String account) throws IOException {
        File file = new File("useraccount/" + account + ".txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        saveTrieHelp(root, "", bw);
        bw.close();
    }

    public static void saveTrieHelp(TrieNode trieNode, String wordStored, BufferedWriter bw) throws IOException {
        if (trieNode != null && trieNode.getTriemap() != null) {
            for (char x = 0; x < 256; x++) {
                TrieNode childNode = trieNode.getTriemap().get(x);
                if (childNode != null) {
                    String currentWord = wordStored + x;
                    if (childNode.isWordEnd()) {
                        bw.write("|");
                        bw.write(currentWord);
                        bw.write("\n");
                        bw.write(childNode.getMeaning());
                    }
                    saveTrieHelp(childNode, currentWord, bw);
                }
            }
        }
    }
}
