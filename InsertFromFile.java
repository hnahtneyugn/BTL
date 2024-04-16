import java.io.*;

public class InsertFromFile extends TrieOperation {

    public static void conditionInsertFromFile() {
        System.out.println("File txt đầu vào phải có định dạng như sau:");
        System.out.println("Từ tiếng anh bắt đầu với kí tự |");
        System.out.println("Các thông tin về từ tiếng anh sẽ nằm trên các dòng còn lại cho đến từ tiếng anh tiếp theo");
        System.out.println("Ví dụ:");
        System.out.println("|hello");
        System.out.println("xin chào");
        System.out.println("Lưu ý: Nếu từ bạn thêm vào đã tồn tại trong từ điển nó sẽ thay dổi từ trong điển");
    }

    public static void insertFromFile() throws IOException {
        conditionInsertFromFile();
        try {
            System.out.println("Nhập vào tên file bạn muốn truyền vào từ điển (Ví dụ: namefile.txt):");
            String filename = scanner.nextLine();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String wordTarget = "";
            StringBuilder wordExplainBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("|")) {
                    if (!wordTarget.isEmpty() && !wordExplainBuilder.isEmpty()) {
                        insertTrie(wordTarget, wordExplainBuilder.toString());
                        wordExplainBuilder.setLength(0);
                    }
                    wordTarget = line.substring(1).trim();
                } else {
                    wordExplainBuilder.append(line.trim()).append("\n");
                }
            }
            if (!wordTarget.isEmpty() && !wordExplainBuilder.isEmpty()) {
                insertTrie(wordTarget, wordExplainBuilder.toString());
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi trong quá trình truyền từ file vào từ điển");
        }
    }

}
