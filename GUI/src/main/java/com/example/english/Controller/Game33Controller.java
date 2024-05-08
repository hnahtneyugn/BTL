package com.example.english.Controller;

import com.example.english.Model.Game3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game33Controller {
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField textField;
    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Button nextButton;
    private List<String> correctAnswer = new ArrayList<>();
    private int count = 1;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    public void initialize() {
        setQuestion();
    }

    public void setQuestion() {
        textField.setDisable(false);
        nextButton.setVisible(false);
        gridPane.getChildren().clear();
        label.setText(null);
        label1.setText(null);
        label2.setText(null);
        label3.setText(null);
        label4.setText(null);
        label5.setText(null);
        textField.setText(null);
        char[][] matrix = new char[12][12];
        Game3.initializeGame3(matrix, 12);
        correctAnswer.clear();
        Game3.buildQuestion(correctAnswer, 7);
        Game3.runGame(matrix, 12, correctAnswer, 8);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                Label text = new Label(String.valueOf(matrix[i][j]));
                text.setAlignment(Pos.CENTER);
                text.setPrefWidth(1000);
                text.setPrefHeight(1000);
                text.setFont(Font.font(26));
                gridPane.add(text, j, i);
            }
        }
        List<String> answerList = new ArrayList<>();
        textField.setOnAction(event -> {
            String keyword = textField.getText();
            if (Game3.checkAnswer(correctAnswer, answerList, keyword)) {
                keyword = keyword.toUpperCase();
                switch (count) {
                    case 1:
                        label1.setText(keyword);
                        label.setText("Đáp án chính xác");
                        break;
                    case 2:
                        label2.setText(keyword);
                        label.setText("Đáp án chính xác");
                        break;
                    case 3:
                        label3.setText(keyword);
                        label.setText("Đáp án chính xác");
                        break;
                    case 4:
                        label4.setText(keyword);
                        label.setText("Đáp án chính xác");
                        break;
                    case 5:
                        label5.setText(keyword);
                        label.setText("Chúc mừng bạn đã chiến thắng");
                        textField.setDisable(true);
                        nextButton.setVisible(true);
                        break;
                }
                count++;
            } else {
                label.setText("Đáp án chưa chính xác");
            }
            textField.setText("");
        });
    }

    public void printAnswer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Bạn chắc chắn muốn hiển thị đáp án");
        alert.setContentText("Nếu hiển thị đáp án trò chơi sẽ kết thúc");
        if (alert.showAndWait().get() == ButtonType.OK) {
            alert.close();
            label.setText(null);
            int temporary = 1;
            for (String keyword : correctAnswer) {
                switch (temporary) {
                    case 1:
                        label1.setText(keyword);
                        break;
                    case 2:
                        label2.setText(keyword);
                        break;
                    case 3:
                        label3.setText(keyword);
                        break;
                    case 4:
                        label4.setText(keyword);
                        break;
                    case 5:
                        label5.setText(keyword);
                        textField.setDisable(true);
                        nextButton.setVisible(true);
                        break;
                }
                temporary++;
            }
        }
    }

    public void switchToSceneGame(ActionEvent event) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("/com/example/english/Search-view.fxml"));
        AnchorPane view = FXMLLoader.load(getClass().getResource("/com/example/english/Game-view.fxml"));
        root.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void nextQuestion(ActionEvent event) throws IOException {
        setQuestion();
    }
}
