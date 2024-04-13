import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PlayGame extends DictionaryManagement {
    protected static List<Map.Entry<String, String>> entryList;
    protected static Random random = new Random();

    public final static void initializeGame() throws IOException {
        FileReader fr = new FileReader("game.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+", 2);
            String englishWord = parts[0].toLowerCase().trim();
            String vietnameseWord = parts[1].toLowerCase().trim();
            addWordGame(englishWord, vietnameseWord);
        }
        br.close();
        entryList = new ArrayList<>(dictionaryGame.entrySet());
    }

    public final static void menuGame() {
        System.out.println("Chào mừng đến với trò chơi của chúng tôi!");
        System.out.println("[1] Giải nghĩa từ");
        System.out.println("[2] Điền kí tự còn thiếu");
        System.out.println("[3] Giải cứu công chúa");
        System.out.println("Xin mời bạn chọn game: ");
    }

    public final static int gameMode() {
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
                scanner.nextLine();
            }
        }
    }

    public final static void playGame() throws IOException {
        initializeGame();
        menuGame();
        int gameMode = gameMode();
        switch (gameMode) {
            case 1:
                Game1.playGame1();
                break;
            case 2:
                Game2.playGame2();
                break;
            case 3:
                Game3.playGame3();
                break;
        }
    }
}
