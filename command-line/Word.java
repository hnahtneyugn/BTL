public class Word {
    private final String wordTarget;
    private final String wordExplain;

    /**
     * Forms a new Word with English name and Vietnamese definition.
     * @param wordTarget  English name
     * @param wordExplain Vietnamese definition
     */
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    /**
     * Get English name.
     * @return English name
     */
    public String getWordTarget() {
        return wordTarget;
    }

    /**
     * Get Vietnamese definition.
     * @return Vietnamese definition
     */
    public String getWordExplain() {
        return wordExplain;
    }
}
