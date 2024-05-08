package com.example.english.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game1 extends PlayGame {
    protected static List<Map.Entry<String, String>> questionList = new ArrayList<>();
    public static Map.Entry<String, String> getRandomQuestion() {
        while (true) {
            Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
            if (!questionList.contains(temporaryEntry)) {
                questionList.add(temporaryEntry);
                return temporaryEntry;
            }
        }
    }

    public static List<String> generateOptionsVietnamese(String correctAnswer) {
        List<String> options = new ArrayList<>();
        options.add(correctAnswer);
        while (options.size() < 4) {
            Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
            if (!options.contains(randomWrongEntry.getValue())) {
                options.add(randomWrongEntry.getValue());
            }
        }
        Collections.shuffle(options);
        return options;
    }

    public static List<String> generateOptionsEnglish(String correctAnswer) {
        List<String> options = new ArrayList<>();
        options.add(correctAnswer);
        while (options.size() < 4) {
            Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
            if (!options.contains(randomWrongEntry.getKey())) {
                options.add(randomWrongEntry.getKey());
            }
        }
        Collections.shuffle(options);
        return options;
    }
}
