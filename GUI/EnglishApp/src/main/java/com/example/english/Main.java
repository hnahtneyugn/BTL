package com.example.english;

import com.example.english.Model.DictionaryFavorite;
import com.example.english.Model.Login;
import com.example.english.Model.SaveTrie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Signin-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Learning English Application");
            stage.show();
            Login.initializeAccount();
            stage.setOnCloseRequest(event -> {
                event.consume();
                try {
                    logout(stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(Stage stage) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Bạn muốn rời khỏi chương trình");
        alert.setContentText("Bạn muốn lưu thay đổi trước khi thoát");
        if (alert.showAndWait().get() == ButtonType.OK) {
            SaveTrie.saveTrie(Login.getUsername());
            DictionaryFavorite.saveFavorite(Login.getUsername());
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
