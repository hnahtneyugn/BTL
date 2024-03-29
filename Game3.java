import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game3 {
    private final Scanner scanner;
    private final List<Map.Entry<String, String>> entryList;
    private final List<String> questionList;
    private final Random random;
    private final char[][] matrix;

    public Game3(Dictionary dictionary) {
        scanner = new Scanner(System.in);
        entryList = new ArrayList<>(dictionary.getWords().entrySet());
        questionList = new ArrayList<>();
        random = new Random();
        matrix = new char[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    private int rulesGame() {
        System.out.println("Trò chơi của chúng tôi như sau:");
        System.out.println("- Công chúa bị một con quái vật bắt cóc và nhốt vào một lâu đài.");
        System.out.println("- Để cứu công chúa hoàng tử phải đến lâu đài và đánh bại con quái vật đó.");
        System.out.println("- Nhưng lâu đài nằm trong rừng và hoàng tử không biết đường đến đó.");
        System.out.println("- Bạn hãy giúp hoàng tử tìm bản đồ và chỉ dẫn hoàng tử đường đến lâu đài.");
        System.out.println("- Bản đồ bị chia làm 4 phần nằm ẩn dấu trong một bảng kí tự.");
        System.out.println("- Nhiệm vụ của bạn là tìm 4 mảnh bản đồ bị ẩn dấu. Mỗi mảnh bản đồ là 1 từ tiếng anh trong bảng kí tự.");
        System.out.println("- Bạn sẽ có 5 điểm sinh lực. Mỗi lần sai sẽ bị trừ 1 sinh lực. Khi cạn sinh lực bạn sẽ thua.");
        System.out.println("Trò chơi có 3 mức độ. Bạn muốn chọn mức độ nào:");
        System.out.println("1. Dễ");
        System.out.println("2. Trung Bình");
        System.out.println("3. Khó");
        int mode = scanner.nextInt();
        scanner.nextLine();
        return mode;
    }

    private void buildQuestion(int sizeWords) {
        while (questionList.size() < 5) {
            Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
            String ques = temporaryEntry.getKey().toLowerCase();
            if(!questionList.contains(ques) && ques.length() >= sizeWords && ques.length() <= (sizeWords + 3)){
                questionList.add(ques);
            }
        }
    }

    private boolean checkPlace(int row, int col, int direction, int length, int sizeMatrix) {
        for (int i = 0; i < length; i++) {
            if (row < 0 || row >= sizeMatrix || col < 0 || col >= sizeMatrix || matrix[row][col] != ' ') {
                return false;
            }
            switch (direction) {
                case 0:
                    col++;
                    break;
                case 1:
                    col--;
                    break;
                case 2:
                    row++;
                    break;
                case 3:
                    row--;
                    break;
                case 4:
                    row++;
                    col++;
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

    private void placeWord(int row, int col, int direction, String word) {
        for (int i = 0; i < word.length(); i++) {
            matrix[row][col] = Character.toUpperCase(word.charAt(i));
            switch (direction) {
                case 0:
                    col++;
                    break;
                case 1:
                    col--;
                    break;
                case 2:
                    row++;
                    break;
                case 3:
                    row--;
                    break;
                case 4:
                    row++;
                    col++;
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

    private void findPlace(int sizeMatrix) {
        for (String word : questionList) {
            boolean placed = true;
            while (placed) {
                int row = random.nextInt(sizeMatrix);
                int col = random.nextInt(sizeMatrix);
                int direction = random.nextInt(8);
                if (checkPlace(row, col, direction, word.length(), sizeMatrix)) {
                    placeWord(row, col, direction, word);
                    placed = false;
                }
            }
        }
    }

    private void fillMatrix(int sizeMatrix) {
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = (char) (random.nextInt(26) + 'A');
                }
            }
        }
    }

    private void printMatrix(int sizeMatrix) {
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void question() {
        int mode = rulesGame();
        buildQuestion(mode * 2 + 1);
        findPlace(5 * (mode + 1));
        fillMatrix(5 * (mode + 1));
        printMatrix(5 * (mode + 1));
        int heart = 5;
        List<String> correctList = new ArrayList<>();
        while (heart > 0 && correctList.size() < 5) {
            String answer = scanner.nextLine().toLowerCase();
            if (questionList.contains(answer)) {
                correctList.add(answer);
                System.out.println("Đáp án của bạn chính xác");
            } else {
                heart--;
                System.out.println("Đáp án của bạn chưa chính xác. Bạn còn " + heart + " cơ hội.");
            }
        }
        if (heart == 0) {
            System.out.println("Rất tiếc bạn đã thua :(");
            System.out.println("Đáp án của trò chơi là:");
            for (int i = 1; i <= questionList.size(); i++) {
                System.out.println(i + ". " + questionList.get(i - 1));
            }
        } else {
            System.out.println("Chúc mừng bạn đã giải cứu thành công công chúa!");
        }
    }
}