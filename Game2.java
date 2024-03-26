import java.util.*;

public class Game2 {
    public final Scanner scanner;

    public Game2() {
        scanner = new Scanner(System.in);
    }

    public void question(Dictionary dictionary){
        List<Map.Entry<String, String>> entryList = new ArrayList<>(dictionary.getWords().entrySet());
        Random random = new Random();
        System.out.println("Chọn số câu hỏi (1 - 20): ");
        int quest = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i <= quest; i++){
            Map.Entry<String, String> randomEntry = entryList.get(random.nextInt(entryList.size()));
            char[] charArray = randomEntry.getKey().toCharArray();
            int randomIndex = random.nextInt(randomEntry.getValue().length());
            charArray[randomIndex] = '_';
            String questionString = String.valueOf(charArray);
            System.out.println("Câu hỏi " + i + ": Điền kí tự còn thiếu vào từ tiếng anh " + questionString + " có nghĩa là: " + randomEntry.getValue());
            char randomChar = Character.toLowerCase(randomEntry.getKey().charAt(randomIndex));
            List<Character> options = new ArrayList<>();
            options.add(randomChar);
            while (options.size() < 4) {
                int randomWrong = random.nextInt(26);
                char randomCharWrong = (char)('a' + randomWrong);
                if(!options.contains(randomCharWrong)){
                    options.add(randomCharWrong);
                }
            }
            Collections.shuffle(options);
            char[] answers = {'A', 'B', 'C', 'D'};
            for (int k = 0; k < options.size(); k++) {
                System.out.println(answers[k] + ". Kí tự còn thiếu là: " + options.get(k));
            }
            System.out.println("Câu trả lời của bạn: ");
            String answer = scanner.nextLine();
            int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
            // scanner.nextLine();
            if (Character.compare(randomChar, options.get(yourAnswer)) == 0) {
                System.out.println("Chính xác!");
            } else {
                System.out.println("Sai rồi:( Câu trả lời đúng phải là kí tự: " + randomChar);
            }
        }
    }
}
