import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game2 {
    private final Scanner scanner;
    private final List<Map.Entry<String, String>> entryList;
    private final List<Map.Entry<String, String>> questionList;
    private final Random random;
    private final char[] answers = { 'A', 'B', 'C', 'D' };

    public Game2(Dictionary dictionary) {
        scanner = new Scanner(System.in);
        entryList = new ArrayList<>(dictionary.getWords().entrySet());
        questionList = new ArrayList<>();
        random = new Random();
    }

    private int gameMenu() {
        System.out.println("Chọn số câu hỏi (1 - 20): ");
        int quest = scanner.nextInt();
        scanner.nextLine();
        return quest;
    }

    public void question() {
        int quest = gameMenu();
        for (int i = 1; i <= quest; i++) {
            Map.Entry<String, String> randomEntry;
            while (true) {
                Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
                if (!questionList.contains(temporaryEntry)) {
                    questionList.add(temporaryEntry);
                    randomEntry = temporaryEntry;
                    break;
                }
            }
            char[] charArray = randomEntry.getKey().toCharArray();
            int randomIndex = random.nextInt(randomEntry.getKey().length());
            char randomChar = Character.toLowerCase(charArray[randomIndex]);
            charArray[randomIndex] = '_';
            String questionString = String.valueOf(charArray);
            System.out.println("Câu hỏi " + i + ": Điền kí tự còn thiếu vào từ tiếng anh " + questionString
                    + " có nghĩa là: " + randomEntry.getValue());
            List<Character> options = new ArrayList<>();
            options.add(randomChar);
            while (options.size() < 4) {
                int randomWrong = random.nextInt(26);
                char randomCharWrong = (char) ('a' + randomWrong);
                if (!options.contains(randomCharWrong)) {
                    options.add(randomCharWrong);
                }
            }
            Collections.shuffle(options);
            for (int k = 0; k < options.size(); k++) {
                System.out.println(answers[k] + ". Kí tự còn thiếu là: " + options.get(k));
            }
            System.out.println("Câu trả lời của bạn: ");
            String answer = scanner.nextLine();
            int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
            if (Character.compare(randomChar, options.get(yourAnswer)) == 0) {
                System.out.println("Đáp án của bạn chính xác!");
            } else {
                System.out.println("Rất tiếc đáp án của bạn sai rồi:( Đáp án chính xác là kí tự: " + randomChar);
            }
        }
    }
}
