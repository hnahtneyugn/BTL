package com.example.english.Model;

import java.io.*;
import java.util.ArrayList;

public class DictionaryFavorite extends TrieOperation{
    public static ArrayList<String> listFavorite = new ArrayList<>();
    public static void dictionaryFavorite(String wordFavorite){
        listFavorite.add(0, wordFavorite);
    }

    public static void addFavorite(String wordFavorite) {
        listFavorite.add(wordFavorite);
    }
    public static void removeFavorite(String wordFavorite) {
        listFavorite.remove(wordFavorite);
    }
    public static ArrayList<String> getListFavorite(){
        return listFavorite;
    }
    public static boolean containFavorite(String wordFavorite){
        return listFavorite.contains(wordFavorite);
    }
    public static void initializeFavorite(String account) throws IOException {
        listFavorite.clear();
        FileReader fr = new FileReader("favoriteaccount/" + account + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            addFavorite(line);
        }
        br.close();
    }
    public static void saveFavorite(String account) throws IOException {
        File file = new File("favoriteaccount/" + account + ".txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (String string : listFavorite) {
            bw.write(string);
            bw.write("\n");
        }
        bw.close();
    }
}
