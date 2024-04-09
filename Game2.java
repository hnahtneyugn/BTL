import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game2 extends PlayGame{
    public static List<Map.Entry<String, String>> questionList = new ArrayList<>();

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
    public static int numberQuestions(){
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
    // public void question() {
    //     int quest = gameMenu();
    //     for (int i = 1; i <= quest; i++) {
    //         Map.Entry<String, String> randomEntry;
    //         while (true) {
    //             Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
    //             if (!questionList.contains(temporaryEntry)) {
    //                 questionList.add(temporaryEntry);
    //                 randomEntry = temporaryEntry;
    //                 break;
    //             }
    //         }
    //         char[] charArray = randomEntry.getKey().toCharArray();
    //         int randomIndex = random.nextInt(randomEntry.getKey().length());
    //         char randomChar = Character.toLowerCase(charArray[randomIndex]);
    //         charArray[randomIndex] = '_';
    //         String questionString = String.valueOf(charArray);
    //         System.out.println("Câu hỏi " + i + ": Điền kí tự còn thiếu vào từ tiếng anh " + questionString
    //                 + " có nghĩa là: " + randomEntry.getValue());
    //         List<Character> options = new ArrayList<>();
    //         options.add(randomChar);
    //         while (options.size() < 4) {
    //             int randomWrong = random.nextInt(26);
    //             char randomCharWrong = (char) ('a' + randomWrong);
    //             if (!options.contains(randomCharWrong)) {
    //                 options.add(randomCharWrong);
    //             }
    //         }
    //         Collections.shuffle(options);
    //         for (int k = 0; k < options.size(); k++) {
    //             System.out.println(answers[k] + ". Kí tự còn thiếu là: " + options.get(k));
    //         }
    //         System.out.println("Câu trả lời của bạn: ");
    //         String answer = scanner.nextLine();
    //         int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
    //         if (Character.compare(randomChar, options.get(yourAnswer)) == 0) {
    //             System.out.println("Đáp án của bạn chính xác!");
    //         } else {
    //             System.out.println("Rất tiếc đáp án của bạn sai rồi:( Đáp án chính xác là kí tự: " + randomChar);
    //         }
    //     }
    // }
}
