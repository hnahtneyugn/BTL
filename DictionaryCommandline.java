import java.util.ArrayList;

public class DictionaryCommandline {
    public static void showAllWords(Dictionary dictionary){
        ArrayList<Word> words = dictionary.getWords();
        System.out.println("No\t|\tEnglish\t|\tVietnamese");
        for(int i = 0; i < words.size(); i++){
            Word word = words.get(i);
            System.out.println((i + 1) + "\t|\t" + word.getWordTarget() + "\t|\t" + word.getWordExplain());
        }
    }
}
