package com.example.english.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game3 extends PlayGame {

    protected static List<String> questionList = new ArrayList<>();

    protected static char[][] matrix = new char[25][25];

    public static void initializeGame3(char[][] matrix, int sizeMatrix) {
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    public static void buildQuestion(List<String> questionList, int sizeWords) {
        while (questionList.size() < 5) {
            Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
            String ques = temporaryEntry.getKey().toLowerCase();
            if (!questionList.contains(ques) && ques.length() >= sizeWords && ques.length() <= (sizeWords + 1)) {
                questionList.add(ques);
            }
        }
    }

    public static boolean checkPlace(char[][] matrix, int sizeMatrix, int row, int col, int direction, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (row < 0 || row >= sizeMatrix || col < 0 || col >= sizeMatrix || matrix[row][col] != ' ') {
                return false;
            }
            switch (direction) {
                case 0:
                    col++;
                    break;
                case 1:
                    row++;
                    break;
                case 2:
                    row++;
                    col++;
                    break;
                case 3:
                    col--;
                    break;
                case 4:
                    row--;
                    break;
                case 5:
                    row--;
                    col--;
                    break;
                case 6:
                    row--;
                    col++;
                    break;
                case 7:
                    row++;
                    col--;
                    break;
            }
        }
        return true;
    }

    public static void placeWord(char[][] matrix, int sizeMatrix, int row, int col, int direction, String word) {
        for (int i = 0; i < word.length(); i++) {
            matrix[row][col] = Character.toUpperCase(word.charAt(i));
            switch (direction) {
                case 0:
                    col++;
                    break;
                case 1:
                    row++;
                    break;
                case 2:
                    row++;
                    col++;
                    break;
                case 3:
                    col--;
                    break;
                case 4:
                    row--;
                    break;
                case 5:
                    row--;
                    col--;
                    break;
                case 6:
                    row--;
                    col++;
                    break;
                case 7:
                    row++;
                    col--;
                    break;
            }
        }
    }

    public static void findPlace(char[][] matrix, int sizeMatrix, List<String> questionList, int direction) {
        for (String word : questionList) {
            boolean placed = true;
            while (placed) {
                int row = random.nextInt(sizeMatrix);
                int col = random.nextInt(sizeMatrix);
                int option = random.nextInt(direction);
                if (checkPlace(matrix, sizeMatrix, row, col, option, word)) {
                    placeWord(matrix, sizeMatrix, row, col, option, word);
                    placed = false;
                }
            }
        }
    }

    public static void fillMatrix(char[][] matrix, int sizeMatrix) {
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = (char) (random.nextInt(26) + 'A');
                }
            }
        }
    }
    public static void runGame(char[][] matrix, int sizeMatrix, List<String> questionList, int direction){
        findPlace(matrix, sizeMatrix,questionList, direction);
        fillMatrix(matrix, sizeMatrix);
    }
    public static boolean checkAnswer(List<String> questionList, List<String> answerList, String answer){
        answer = answer.toLowerCase().trim();
        if(questionList.contains(answer) && !answerList.contains(answer)){
            answerList.add(answer);
            return true;
        }
        return false;
    }
}