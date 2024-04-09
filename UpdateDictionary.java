public class UpdateDictionary extends DictionaryManagement{
    public static void updateDictionary(){
        while (true) {
            System.out.println("Nhập vào từ bạn muốn sửa: ");
            String updateWord = scanner.nextLine().toLowerCase().trim();
            if(isAllLetters(updateWord)){
                if (dictionary.containsKey(updateWord)){
                    System.out.println(updateWord + " nghĩa là " + dictionary.get(updateWord));
                    System.out.println("Bạn muốn thay đổi nghĩa của từ này thành: ");
                    String updateMeaning = scanner.nextLine().toLowerCase().trim();
                    dictionary.put(updateWord, updateMeaning);
                    break;
                }else{
                    System.out.println("Từ này không tồn tại trong từ điển! Bạn có muốn thêm nó vào từ điển không ?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    char choice = scanner.next().charAt(0);
                    scanner.nextLine();
                    if(choice == '1'){
                        System.out.println("Nhập vào nghĩa tiếng việt: ");
                        String updateMeaning = scanner.nextLine().toLowerCase().trim();
                        addWord(updateWord, updateMeaning);
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
