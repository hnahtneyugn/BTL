import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game1 {

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
        for (int i = 0; i < quest; i++) {
            Map.Entry<String, String> randomEntry = entryList.get(random.nextInt(entryList.size()));
            // Print that random question (Vietnamese word) and answer (English word)
            System.out.println("Câu hỏi: " + randomEntry.getValue());
            System.out.println("Câu trả lời của bạn: ");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase(randomEntry.getKey().trim())){
                System.out.println("Chính xác!");
            }else{
                System.out.println("Sai rồi:( Câu trả lời đúng phải là: " + randomEntry.getKey());
            }
        }

    }
}

