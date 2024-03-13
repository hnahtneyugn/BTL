import java.util.Scanner;

public class DictionaryManagement {
    private Scanner scanner;

    public DictionaryManagement() {
        scanner = new Scanner(System.in);
    }

    public void insertFromCommandline(Dictionary dictionary) {
        System.out.println("Nhap vao ban phim so luong tu vung: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= count; i++) {
            System.out.println("Tu so " + i + " ban nhap vao");
            System.out.println("Nhap tu tieng Anh: ");
            String wordTarget = scanner.nextLine();
            System.out.println("Nhap giai thich bang tieng Viet: ");
            String wordExplain = scanner.nextLine();
            Word word = new Word(wordTarget, wordExplain);
            dictionary.addWord(word);
        }
    }
}
