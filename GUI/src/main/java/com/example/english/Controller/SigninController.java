package com.example.english.Controller;

import com.example.english.Model.DictionaryFavorite;
import com.example.english.Model.InitializeTrie;
import com.example.english.Model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SigninController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TextField myTextField;
    @FXML
    private PasswordField myPasswordField;
    @FXML
    private Button SigninButton;
    @FXML
    private Button UserButton;

    @FXML
    public void initialize() {
        setSignin();
    }

    private void setSignin() {
        myTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            checkFields(myTextField.getText(), myPasswordField.getText(), SigninButton);
        });
        myPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {
            checkFields(myTextField.getText(), myPasswordField.getText(), SigninButton);
        });
    }

    private void checkFields(String username, String password, Button SigninButton) {
        if (username.length() >= 8 && password.length() >= 8) {
            SigninButton.setDisable(false);
        } else {
            SigninButton.setDisable(true);
        }
    }

    public void Signin(ActionEvent event) throws IOException {
        String username = myTextField.getText();
        String password = myPasswordField.getText();
        if (Login.checkUsernameContain(username)) {
            if (Login.checkPasswordCorrect(username, password)) {
                Login.setUsername(username);
                InitializeTrie.createTrie(username);
                DictionaryFavorite.initializeFavorite(username);
                root = FXMLLoader.load(getClass().getResource("/com/example/english/Search-view.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                myPasswordField.setText("");
                myPasswordField.setPromptText("Mật khẩu không chính xác");
                UserButton.requestFocus();
            }
        } else {
            myTextField.setText("");
            myTextField.setPromptText("Tên đăng nhập không tồn tại");
            UserButton.requestFocus();
        }
    }


    public void switchToSceneHome(ActionEvent event) throws IOException {
        Login.setUsername("user");
        InitializeTrie.createTrie("user");
        DictionaryFavorite.initializeFavorite("user");
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Search-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneSignup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Signup-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
