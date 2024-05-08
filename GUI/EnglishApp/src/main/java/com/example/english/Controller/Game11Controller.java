package com.example.english.Controller;

import com.example.english.Model.Game1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game11Controller {
    @FXML
    private Label question;
    @FXML
    private Button answerA;
    @FXML
    private Button answerB;
    @FXML
    private Button answerC;
    @FXML
    private Button answerD;
    @FXML
    private Button nextButton;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    private Map.Entry<String, String> randomEntry;
    private List<String> options = new ArrayList<>();

    private boolean check;

    @FXML
    public void initialize() {
        setQuestion();
    }

    public void setQuestion() {
        nextButton.setVisible(false);
        check = false;
        randomEntry = Game1.getRandomQuestion();
        question.setText("Hãy cho biết nghĩa của từ tiếng anh sau: " + randomEntry.getKey());
        options = Game1.generateOptionsVietnamese(randomEntry.getValue());
        answerA.setText(options.get(0));
        answerA.setStyle("-fx-background-color: lightgrey;");
        answerB.setText(options.get(1));
        answerB.setStyle("-fx-background-color: lightgrey;");
        answerC.setText(options.get(2));
        answerC.setStyle("-fx-background-color: lightgrey;");
        answerD.setText(options.get(3));
        answerD.setStyle("-fx-background-color: lightgrey;");
    }

    public void chooseAnswer(ActionEvent event) throws IOException {
        if (!check) {
            Button clickedButton = (Button) (event.getSource());
            String correctAnswer = randomEntry.getValue();
            if (correctAnswer.equals(clickedButton.getText())) {
                clickedButton.setStyle("-fx-background-color: green;");
            } else {
                clickedButton.setStyle("-fx-background-color: red;");
                if (answerA.getText().equals(correctAnswer)) {
                    answerA.setStyle("-fx-background-color: green;");
                } else if (answerB.getText().equals(correctAnswer)) {
                    answerB.setStyle("-fx-background-color: green;");
                } else if (answerC.getText().equals(correctAnswer)) {
                    answerC.setStyle("-fx-background-color: green;");
                } else if (answerD.getText().equals(correctAnswer)) {
                    answerD.setStyle("-fx-background-color: green;");
                }
            }
            check = true;
            nextButton.setVisible(true);
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
