// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Map;

// public class Game1 extends PlayGame {
//     protected static List<Map.Entry<String, String>> questionList = new ArrayList<>();
//     protected static char[] answers = { 'A', 'B', 'C', 'D' };

//     public static void menuGame1() {
//         System.out.println("Có 2 chế độ chơi: ");
//         System.out.println("[1] Tìm nghĩa tiếng viêt");
//         System.out.println("[2] Tìm từ tiếng anh");
//         System.out.println("Xin mời bạn chọn chế độ: ");
//     }

//     public static int gameMode1() {
//         while (true) {
//             try {
//                 int gameMode = scanner.nextInt();
//                 scanner.nextLine();
//                 if (1 <= gameMode && gameMode <= 2) {
//                     return gameMode;
//                 }
//                 System.out.println("Hành động bạn chọn không được hỗ trợ!");
//             } catch (Exception e) {
//                 System.out.println("Dữ liệu đầu vào không hợp lệ!");
//                 scanner.nextLine();
//             }
//         }
//     }

//     public static int numberQuestions() {
//         while (true) {
//             try {
//                 System.out.println("Chọn số câu hỏi bạn muốn trả lời: ");
//                 int numQuestions = scanner.nextInt();
//                 scanner.nextLine();
//                 return numQuestions;
//             } catch (Exception e) {
//                 System.out.println("Dữ liệu đầu vào không hợp lệ!");
//                 scanner.nextLine();
//             }
//         }
//     }

//     public static Map.Entry<String, String> getRandomQuestion() {
//         while (true) {
//             Map.Entry<String, String> temporaryEntry = entryList.get(random.nextInt(entryList.size()));
//             if (!questionList.contains(temporaryEntry)) {
//                 questionList.add(temporaryEntry);
//                 return temporaryEntry;
//             }
//         }
//     }

//     public static List<String> generateOptionsVietnamese(String correctAnswer) {
//         List<String> options = new ArrayList<>();
//         options.add(correctAnswer);
//         while (options.size() < 4) {
//             Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
//             if (!options.contains(randomWrongEntry.getValue())) {
//                 options.add(randomWrongEntry.getValue());
//             }
//         }
//         Collections.shuffle(options);
//         return options;
//     }

//     public static List<String> generateOptionsEnglish(String correctAnswer) {
//         List<String> options = new ArrayList<>();
//         options.add(correctAnswer);
//         while (options.size() < 4) {
//             Map.Entry<String, String> randomWrongEntry = entryList.get(random.nextInt(entryList.size()));
//             if (!options.contains(randomWrongEntry.getKey())) {
//                 options.add(randomWrongEntry.getKey());
//             }
//         }
//         Collections.shuffle(options);
//         return options;
//     }

//     public static void displayOptions(List<String> options) {
//         for (int k = 0; k < options.size(); k++) {
//             System.out.println(answers[k] + ". " + options.get(k));
//         }
//     }

//     public static void checkAnswer(List<String> options, String correctAnswer) {
//         while (true) {
//             try {
//                 System.out.println("Câu trả lời của bạn: ");
//                 String answer = scanner.nextLine();
//                 int yourAnswer = Character.toUpperCase(answer.charAt(0)) - 'A';
//                 if (options.get(yourAnswer).equalsIgnoreCase(correctAnswer.trim())) {
//                     System.out.println("Đáp án của bạn chính xác!");
//                 } else {
//                     System.out.println("Rất tiếc đáp án của bạn sai rồi:( Đáp án chính xác là: " + correctAnswer);
//                 }
//                 break;
//             } catch (Exception e) {
//                 System.out.println("Dữ liệu đầu vào không hợp lệ!");
//             }
//         }
//     }

//     public static void askQuestionEnglish(Map.Entry<String, String> randomEntry, int questionNumber) {
//         System.out.println(
//                 "Câu hỏi " + questionNumber + ": Hãy cho biết nghĩa của từ tiếng anh sau: " + randomEntry.getKey());
//         List<String> options = generateOptionsVietnamese(randomEntry.getValue());
//         displayOptions(options);
//         checkAnswer(options, randomEntry.getValue());
//     }

//     public static void askQuestionsEnglish(int numQuestions) {
//         for (int i = 1; i <= numQuestions; i++) {
//             Map.Entry<String, String> randomEntry = getRandomQuestion();
//             askQuestionEnglish(randomEntry, i);
//         }
//     }

//     public static void askQuestionVietnamese(Map.Entry<String, String> randomEntry, int questionNumber) {
//         System.out.println(
//                 "Câu hỏi " + questionNumber + ": Hãy cho biết từ tiếng anh nào có nghĩa là: " + randomEntry.getValue());
//         List<String> options = generateOptionsEnglish(randomEntry.getKey());
//         displayOptions(options);
//         checkAnswer(options, randomEntry.getKey());
//     }

//     public static void askQuestionsVietnamese(int numQuestions) {
//         for (int i = 1; i <= numQuestions; i++) {
//             Map.Entry<String, String> randomEntry = getRandomQuestion();
//             askQuestionVietnamese(randomEntry, i);
//         }
//     }

//     public static void playGame1() {
//         menuGame1();
//         int gameMode = gameMode1();
//         int numQuestions = numberQuestions();
//         switch (gameMode) {
//             case 1:
//                 askQuestionsEnglish(numQuestions);
//                 break;
//             case 2:
//                 askQuestionsVietnamese(numQuestions);
//                 break;
//         }
//     }
// }
