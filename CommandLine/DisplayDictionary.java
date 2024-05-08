public class DisplayDictionary extends TrieOperation {

    public static int displayDictionary(TrieNode trieNode, String wordStored, int wordCount) {
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
                    wordCount = displayDictionary(childNode, currentWord, wordCount);
                }
            }
        }
        return wordCount;
    }

}
