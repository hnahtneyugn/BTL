import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game2 extends PlayGame {

    protected static List<Map.Entry<String, String>> questionList = new ArrayList<>();

    protected static char[] answers = { 'A', 'B', 'C', 'D' };

    public static void menuGame2() {
        System.out.println("Có 3 chế độ chơi: ");
        System.out.println("[1]. Dễ");
        System.out.println("[2]. Trung Bình");
        System.out.println("[3]. Khó");
        System.out.println("Xin mời bạn chọn chế độ: ");
    }

    public static int gameMode2() {
        while (true) {
            try {
                int gameMode = scanner.nextInt();
                scanner.nextLine();
                if (1 <= gameMode && gameMode <= 3) {
                    return gameMode;
                }
                System.out.println("Hành động bạn chọn không được hỗ trợ!");
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
            }
        }
    }

    public static int numberQuestions() {
        while (true) {
            try {
                System.out.println("Chọn số câu hỏi bạn muốn trả lời: ");
                int numQuestions = scanner.nextInt();
                scanner.nextLine();
                return numQuestions;
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
            }
        }
    }

    public static Map.Entry<String, String> getRandomQuestion() {
        while (true) {
            Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
            if (!questionList.contains(temporaryEntry)) {
                questionList.add(temporaryEntry);
                return temporaryEntry;
            }
        }
    }

    public static List<Character> displayQuestion(Map.Entry<String, String> randomEntry, int questionNumber,
            int level) {
        int count = level;
        List<Character> cocorrectAnswer = new ArrayList<>();
        char[] charArray = randomEntry.getKey().trim().toCharArray();
        while (count > 0) {
            int randomIndex = random.nextInt(randomEntry.getKey().length());
            if (Character.compare(charArray[randomIndex], ' ') != 0) {
                cocorrectAnswer.add(Character.toLowerCase(charArray[randomIndex]));
                charArray[randomIndex] = '_';
                count--;
            }
        }
        String questionString = String.valueOf(charArray);
        System.out.println("Câu hỏi " + questionNumber + ": Điền kí tự còn thiếu vào từ tiếng anh " + questionString
                + " có nghĩa là: " + randomEntry.getValue());
        return cocorrectAnswer;
    }

    public static List<List<Character>> generateOptions(List<Character> correctAnswer, int level) {
        List<List<Character>> options = new ArrayList<>();
        options.add(correctAnswer);
        while (options.size() < 4) {
            List<Character> wrongAnswer = new ArrayList<>();
            while (wrongAnswer.size() < level) {
                int randomWrong = random.nextInt(26);
                char randomCharWrong = (char) ('a' + randomWrong);
                if (!correctAnswer.contains(randomCharWrong)) {
                    wrongAnswer.add(randomCharWrong);
                }
            }
            options.add(wrongAnswer);
        }
        Collections.shuffle(options);
        return options;
    }

    public static void displayOptions(List<List<Character>> options, int level) {
        for (int k = 0; k < options.size(); k++) {
            System.out.print(answers[k] + ". Kí tự còn thiếu là: ");
            for (int i = 0; i < level - 1; i++) {
                System.out.print(options.get(k).get(i) + ", ");
            }
            System.out.print(options.get(k).get(level - 1) + ".\n");
        }
    }

    public static void checkAnswer(List<List<Character>> options, List<Character> correctAnswer) {
        while (true) {
            try {
                System.out.println("Câu trả lời của bạn: ");
                String answer = scanner.nextLine();
                int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
                if (correctAnswer.equals(options.get(yourAnswer))) {
                    System.out.println("Đáp án của bạn chính xác!");
                } else {
                    System.out.println("Rất tiếc đáp án của bạn sai rồi:( Đáp án chính xác là: " + correctAnswer);
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
            }
        }
    }

    public static void askQuestion(Map.Entry<String, String> randomEntry, int questionNumber, int level) {
        List<Character> correctAnswer = displayQuestion(randomEntry, questionNumber, level);
        List<List<Character>> options = generateOptions(correctAnswer, level);
        displayOptions(options, level);
        checkAnswer(options, correctAnswer);
    }

    public static void askQuestions(int numQuestions, int level) {
        for (int i = 1; i <= numQuestions; i++) {
            Map.Entry<String, String> randomEntry = getRandomQuestion();
            askQuestion(randomEntry, i, level);
        }
    }

    public static void playGame2() {
        menuGame2();
        int gameMode = gameMode2();
        int numQuestions = numberQuestions();
        switch (gameMode) {
            case 1:
                askQuestions(numQuestions, 1);
                break;
            case 2:
                askQuestions(numQuestions, 2);
                break;
            case 3:
                askQuestions(numQuestions, 3);
                break;
        }
    }

}
