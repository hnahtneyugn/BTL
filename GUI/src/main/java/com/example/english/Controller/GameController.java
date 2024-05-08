package com.example.english.Controller;

import com.example.english.Model.PlayGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button game11Button;
    @FXML
    private Button game12Button;
    @FXML
    private Button game21Button;
    @FXML
    private Button game22Button;
    @FXML
    private Button game23Button;
    @FXML
    private Button game31Button;
    @FXML
    private Button game32Button;
    @FXML
    private Button game33Button;

    @FXML
    public void initialize() throws IOException {
        PlayGame.initializeGame();
    }

    public void printGame1(ActionEvent event) {
        if (game11Button.isVisible()) {
            game11Button.setVisible(false);
            game12Button.setVisible(false);
        } else {
            game11Button.setVisible(true);
            game12Button.setVisible(true);
        }
    }
    public void printGame2(ActionEvent event) {
        if (game21Button.isVisible()) {
            game21Button.setVisible(false);
            game22Button.setVisible(false);
            game23Button.setVisible(false);
        } else {
            game21Button.setVisible(true);
            game22Button.setVisible(true);
            game23Button.setVisible(true);
        }
    }
    public void printGame3(ActionEvent event) {
        if (game31Button.isVisible()) {
            game31Button.setVisible(false);
            game32Button.setVisible(false);
            game33Button.setVisible(false);
        } else {
            game31Button.setVisible(true);
            game32Button.setVisible(true);
            game33Button.setVisible(true);
        }
    }
    public void switchToSceneGame11(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game11-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame12(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game12-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame21(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game21-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame22(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game22-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame23(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game23-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame31(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game31-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame32(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game32-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGame33(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Game33-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
