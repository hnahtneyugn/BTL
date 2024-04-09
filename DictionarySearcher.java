public class DictionarySearcher extends DictionaryManagement{
    /**
     * Search all the words that begin with certain characters.
     * @param dictionary stores all words
     */
    public static void dictionarySearcher() {
        while (true) {
            System.out.println("Nhập từ cần tìm kiếm: ");
            String searchWord = scanner.nextLine().toLowerCase().trim();
            if(isAllLetters(searchWord)){
                for (String word : dictionary.keySet()) {
                    if (word.startsWith(searchWord)) {
                        System.out.println(word);
                    }
                }
                break;
            }else{
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }
}
