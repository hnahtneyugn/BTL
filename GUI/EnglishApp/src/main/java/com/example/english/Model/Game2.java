package com.example.english.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game2 extends PlayGame {
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
    public static List<Character> setAnswer(String question, int level) {
        int count = level;
        List<Character> correct = new ArrayList<>();
        char[] charArray = question.toCharArray();
        while (count > 0) {
            int randomIndex = random.nextInt(question.length());
            if (charArray[randomIndex] != '_') {
                correct.add(charArray[randomIndex]);
                charArray[randomIndex] = '_';
                count--;
            }
        }
        return correct;
    }
    public static String displayQuestion(String question, List<Character> correct) {
        char[] charArray = question.toCharArray();
        for (Character x : correct) {
            for (int i = 0; i < question.length(); i++) {
                if (charArray[i] == x) {
                    charArray[i] = '_';
                    break;
                }
            }
        }
        return String.valueOf(charArray);
    }
    public static List<String> displayOptions(List<Character> correct, int level) {
        List<String> options = new ArrayList<>();
        options.add(correct.toString());
        while (options.size() < 4) {
            List<Character> wrongAnswer = new ArrayList<>();
            while (wrongAnswer.size() < level) {
                int randomWrong = random.nextInt(26);
                char randomCharWrong = (char) ('a' + randomWrong);
                if (!correct.contains(randomCharWrong)) {
                    wrongAnswer.add(randomCharWrong);
                }
            }
            options.add(wrongAnswer.toString());
        }
        Collections.shuffle(options);
        return options;
    }
}
