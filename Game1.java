import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game1 {
    public void question(Dictionary dictionary){
         // Chuyển HashMap thành một danh sách các cặp key-value
        List<Map.Entry<String, String>> entryList = new ArrayList<>(dictionary.getWords().entrySet());
        // Lấy một cặp ngẫu nhiên từ danh sách
        Random random = new Random();
        Map.Entry<String, String> randomEntry = entryList.get(random.nextInt(entryList.size()));
        // In ra cặp key-value ngẫu nhiên
        System.out.println("Câu hỏi: Từ tiếng anh nào có nghĩa là: " + randomEntry.getValue());
        System.out.println("Câu trả lời của bạn: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase(randomEntry.getKey().trim())){
            System.out.println("Đáp án của bạn chính xác!");
        }else{
            System.out.println("Rất tiếc dáp án của bạn chưa đúng. Đáp án đúng là: " + randomEntry.getKey());
        }
    }
}

