package com.example.english.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PlayGame extends TrieOperation {
    protected static LinkedHashMap<String, String> dictionaryGame = new LinkedHashMap<>();

    protected static List<Map.Entry<String, String>> entryList;

    protected static Random random = new Random();

    public final static void addWordGame(String wordTarget, String wordExplain) {
        dictionaryGame.put(wordTarget, wordExplain);
    }

    public final static void initializeGame() throws IOException {
        FileReader fr = new FileReader("database/game.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+", 2);
            String englishWord = parts[0].toLowerCase().trim();
            String vietnameseWord = parts[1].toLowerCase().trim();
            addWordGame(englishWord, vietnameseWord);
        }
        br.close();
        entryList = new ArrayList<>(dictionaryGame.entrySet());
    }
}
