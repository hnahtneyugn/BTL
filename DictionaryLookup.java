public class DictionaryLookup extends TrieOperation {

    public static void menuLookUp() {
        System.out.println("Bạn muốn sử dụng từ điển: ");
        System.out.println("[1] Từ điển Anh - Việt");
        System.out.println("[2] Từ điển Việt - Anh");
        System.out.println("Xin mời bạn lựa chọn: ");
    }

    public static int lookUpMode() {
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

    public static void lookupEV() {
        System.out.println("Nhập vào từ tiếng anh bạn muốn tra cứu:");
        String lookUpWord = scanner.nextLine().toLowerCase().trim();
        System.out.println("Thông tin về từ tiếng anh mà bạn cần tìm kiếm:");
        if (searchTrie(lookUpWord) != null) {
            System.out.println(searchTrie(lookUpWord).getMeaning());
        } else {
            System.out.println(API.translate("en", "vi", lookUpWord));
        }
    }

    public static void lookupVE() {
        System.out.println("Nhập vào từ tiếng việt bạn muốn tra cứu:");
        String lookUpWord = scanner.nextLine().toLowerCase().trim();
        System.out.println("Thông tin về từ tiếng việt mà bạn cần tìm kiếm:");
        System.out.println(API.translate("vi", "en", lookUpWord));
    }

    public static void dictionaryLookUp() {
        menuLookUp();
        int lookUpMode = lookUpMode();
        switch (lookUpMode) {
            case 1:
                lookupEV();
                break;
            case 2:
                lookupVE();
                break;
        }
    }

}
