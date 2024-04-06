import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game1 {
    private final Scanner scanner;
    private final List<Map.Entry<String, String>> entryList;
    private final List<Map.Entry<String, String>> questionList;
    private final Random random;
    private final char[] answers = { 'A', 'B', 'C', 'D' };

    public Game1(Dictionary dictionary) {
        scanner = new Scanner(System.in);
        entryList = new ArrayList<>(dictionary.getWords().entrySet());
        questionList = new ArrayList<>();
        random = new Random();
    }

    public int gameMenu() {
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
            System.out.println("Câu hỏi " + i + ": Hãy cho biết từ tiếng anh nào có nghĩa là: " + randomEntry.getValue());
            List<String> options = new ArrayList<>();
            options.add(randomEntry.getKey());
            while (options.size() < 4) {
                Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
                if (!options.contains(randomWrongEntry.getKey())) {
                    options.add(randomWrongEntry.getKey());
                }
            }
            Collections.shuffle(options);
            for (int k = 0; k < options.size(); k++) {
                System.out.println(answers[k] + ". " + options.get(k));
            }
            System.out.println("Câu trả lời của bạn: ");
            String answer = scanner.nextLine();
            int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
            if (options.get(yourAnswer).equalsIgnoreCase(randomEntry.getKey().trim())) {
                System.out.println("Đáp án của bạn chính xác!");
            } else {
                System.out.println("Rất tiếc đáp án của bạn sai rồi:( Đáp án chính xác là: " + randomEntry.getKey());
            }
        }

    }
}
