public class DictionaryLookup extends TrieOperation {
    public final static void menuLookup() {
        System.out.println("Bạn muốn sử dụng từ điển: ");
        System.out.println("[1] Từ điển Anh - Việt");
        System.out.println("[2] Từ điển Việt - Anh");
        System.out.println("Xin mời bạn lựa chọn: ");
    }

    public final static int lookupMode() {
        while (true) {
            try {
                int lookupMode = scanner.nextInt();
                scanner.nextLine();
                if (1 <= lookupMode && lookupMode <= 3) {
                    return lookupMode;
                }
                System.out.println("Hành động bạn chọn không được hỗ trợ!");
            } catch (Exception e) {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }

    public static void lookupEV(){
        TrieNode currentNode = root;
        while (true) {
            System.out.println("Nhập từ cần tìm kiếm: ");
            String searchWord = scanner.nextLine().toLowerCase().trim();
            if (isAllLetters(searchWord)) {
                for (int i = 0; i < searchWord.length(); i++) {
                    char x = searchWord.charAt(i);
                    if (!currentNode.getTriemap().containsKey(x)) {
                        System.out.println("Thông tin về từ mà bạn cần tìm kiếm:");
                        System.out.println(API.translate("en", "vi", searchWord));
                        return;
                    }
                    currentNode = currentNode.getTriemap().get(x);
                }
                if (currentNode.isWordEnd()) {
                    System.out.println("Thông tin về từ mà bạn cần tìm kiếm:");
                    System.out.println(currentNode.getMeaning());
                } else {
                    System.out.println("Thông tin về từ mà bạn cần tìm kiếm:");
                    System.out.println(API.translate("en", "vi", searchWord));
                }
                break;
            } else {
                System.out.println("Dữ liệu đầu vào không hợp lệ!");
                scanner.nextLine();
            }
        }
    }
    public static void lookupVE(){
        System.out.println("Nhập từ cần tìm: ");
        String text = scanner.nextLine().toLowerCase().trim();
        System.out.println("Từ bạn muốn tìm kiếm là: ");
        System.out.println(API.translate("vi", "en", text));
    }

    public final static void dictionaryLookup(){
        menuLookup();
        int lookupMode = lookupMode();
        switch (lookupMode) {
            case 1:
                lookupEV();
                break;
            case 2:
                lookupVE();
                break;
        }
    }
}
