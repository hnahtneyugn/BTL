package com.example.english.Model;

import java.util.HashMap;

public class TrieNode {
    protected boolean isWordEnd;
    protected HashMap<Character, TrieNode> triemap;
    protected String meaning;

    public TrieNode() {
        this.isWordEnd = false;
        this.triemap = new HashMap<>();
        this.meaning = "";
    }

    public HashMap<Character, TrieNode> getTriemap() {
        return triemap;
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

}
