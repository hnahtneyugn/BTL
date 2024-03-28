import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game1 {
<<<<<<< HEAD
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

    public void question(Dictionary dictionary) {
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
            System.out
                    .println("Câu hỏi " + i + ": Hãy cho biết từ tiếng anh nào có nghĩa là: " + randomEntry.getValue());
            List<String> options = new ArrayList<>();
            options.add(randomEntry.getKey());
            while (options.size() < 4) {
                Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
                if (!options.contains(randomWrongEntry.getKey())) {
=======

    private final Scanner scanner;

    public Game1() {
        scanner = new Scanner(System.in);
    }
    public void question(Dictionary dictionary){
         // Change LinkedHashmap into a list of key-value pairs
        List<Map.Entry<String, String>> entryList = new ArrayList<>(dictionary.getWords().entrySet());
        // Get a random pair from the list
        Random random = new Random();
        System.out.println("Chọn số câu hỏi (1 - 20): ");
        int quest = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= quest; i++) {
            Map.Entry<String, String> randomEntry = entryList.get(random.nextInt(entryList.size()));
            // Print that random question (Vietnamese word) and answer (English word)
            System.out.println("Câu hỏi: " + randomEntry.getValue());
             List<String> options = new ArrayList<>();
            options.add(randomEntry.getKey());
            while(options.size() < 4){
                // Get a random entry from entryList that is not the correct answer
                Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
                if(!options.contains(randomWrongEntry.getKey())){
>>>>>>> 15f6ff06e6cf7db66ab0a9326fd1a3cd3a085400
                    options.add(randomWrongEntry.getKey());
                }
            }
            Collections.shuffle(options);
<<<<<<< HEAD
=======
            char[] answers = {'A', 'B', 'C', 'D'};
>>>>>>> 15f6ff06e6cf7db66ab0a9326fd1a3cd3a085400
            for (int k = 0; k < options.size(); k++) {
                System.out.println(answers[k] + ". " + options.get(k));
            }
            System.out.println("Câu trả lời của bạn: ");
            String answer = scanner.nextLine();
            int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
<<<<<<< HEAD
            if (options.get(yourAnswer).equalsIgnoreCase(randomEntry.getKey().trim())) {
                System.out.println("Đáp án của bạn chính xác!");
            } else {
                System.out.println("Rất tiếc đáp án của bạn sai rồi:( Đáp án chính xác là: " + randomEntry.getKey());
=======
            // scanner.nextLine();
            if (options.get(yourAnswer).equalsIgnoreCase(randomEntry.getKey().trim())) {
                System.out.println("Chính xác!");
            } else {
                System.out.println("Sai rồi:( Câu trả lời đúng phải là: " + randomEntry.getKey());
>>>>>>> 15f6ff06e6cf7db66ab0a9326fd1a3cd3a085400
            }
        }

    }
}
