public class DisplayDictionary extends TrieOperation {

    private static int wordCount = 1;

    public static void displayDictionary(TrieNode trieNode, String wordStored) {
        if (trieNode != null && trieNode.getTriemap() != null) {
            for (char x = 0; x < 256; x++) {
                TrieNode childNode = trieNode.getTriemap().get(x);
                if (childNode != null) {
                    String currentWord = wordStored + x;
                    if (childNode.isWordEnd()) {
                        System.out.println(wordCount + ". " + currentWord);
                        System.out.println(childNode.getMeaning());
                        wordCount++;
                    }
                    displayDictionary(childNode, currentWord);
                }
            }
        }
    }

}
