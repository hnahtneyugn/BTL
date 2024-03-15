import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    private final Scanner scanner;

    /**
     * Class' constructor.
     */
    public DictionaryManagement() {
        scanner = new Scanner(System.in);
    }

    /**
     * Allow user to choose mode.
     * @return mode to use
     */
    public int appMode() {
        while (true) {
            int mode = scanner.nextInt();
            if (0 <= mode && mode <= 9) {
                return mode;
            }
            System.out.println("Action not supported!");
        }
    }

    /**
     * Receives input from user via command line.
     * @param dictionary store all inserted words
     */
    public void insertFromCommandline(Dictionary dictionary) {
        System.out.println("Type in number of words: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= count; i++) {
            System.out.println("The " + i + "th word you insert");
            System.out.println("Insert English word: ");
            String wordTarget = scanner.nextLine();
            System.out.println("Insert Vietnamese explanation: ");
            String wordExplain = scanner.nextLine();
            Word word = new Word(wordTarget, wordExplain);
            dictionary.addWord(word);
        }
    }

    /**
     * Receives dictionary data from a text file.
     * @param dictionary stores all words.
     * @param filename   database
     * @throws IOException handle exceptions
     */
    public void insertFromFile(Dictionary dictionary, String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+", 2);
            String englishWord = parts[0].trim();
            String vietnameseWord = parts[1].trim();
            Word word = new Word(englishWord, vietnameseWord);
            dictionary.addWord(word);
        }
        System.out.println("Words from file have been inserted into the dictionary!");
        br.close();
    }

    /**
     * Returns the meaning of a word.
     * @param dictionary stores all words
     */
    public void dictionaryLookup(Dictionary dictionary) {
        System.out.println("Input word: ");
        while (true) {
            String lookupWord = scanner.nextLine();
            if (dictionary.getWords().containsKey(lookupWord)) {
                System.out.println("Definition: " + dictionary.getWords().get(lookupWord));
                break;
            }
            System.out.println("This word doesn't exist in the dictionary! Please try again!");
        }
    }

    /**
     * Search all the words that begin with certain characters.
     * @param dictionary stores all words
     */
    public void dictionarySearcher(Dictionary dictionary) {
        System.out.println("Type word to search: ");
        String searchWord = scanner.nextLine();
        for (String word : dictionary.getWords().keySet()) {
            if (word.startsWith(searchWord)) {
                System.out.println(word);
            }
        }
    }

    /**
     * Export all data in the current dictionary to a new txt file.
     * @param dictionary stores all words
     * @throws IOException handle exceptions
     */
    public void dictionaryExportToFile(Dictionary dictionary) throws IOException {
        FileWriter fw = new FileWriter("dictionaries.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int countWords = 0;
        bw.write("No\t|\tEnglish\t|\tVietnamese\n");
        for (String word : dictionary.getWords().keySet()) {
            bw.write(Integer.toString(countWords + 1));
            bw.write("\t\t");
            bw.write(word);
            bw.write("\t\t");
            bw.write(dictionary.getWords().get(word));
            bw.write("\n");

            countWords++;
        }
        bw.close();
    }

    /**
     * Allow user to choose which mode/function to call conveniently.
     * @param dictionary stores all words
     * @throws IOException handle exceptions
     */
    public void dictionaryAdvanced(Dictionary dictionary) throws IOException {
        Messages.printMenu();
        int mode = appMode();
        switch (mode) {
            case 0:
                System.out.println("Goodbye! See you later!");
                System.exit(0);
                break;
            case 1:
                insertFromCommandline(dictionary);
                break;
            case 2:
                System.out.println("Removed!");
                break;
            case 3:
                System.out.println("Updated!");
                break;
            case 4:
                DictionaryCommandline.showAllWords(dictionary);
                break;
            case 5:
                dictionaryLookup(dictionary);
                break;
            case 6:
                dictionarySearcher(dictionary);
                break;
            case 7:
                System.out.println("Game!");
                break;
            case 8:
                insertFromFile(dictionary, "dictionaries.txt");
                break;
            case 9:
                dictionaryExportToFile(dictionary);
                break;
        }
    }
}
