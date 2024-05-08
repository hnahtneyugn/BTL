package com.example.english.Controller;

import com.example.english.Model.DictionaryFavorite;
import com.example.english.Model.InitializeTrie;
import com.example.english.Model.Login;
import com.example.english.Model.SaveTrie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
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
    private PasswordField myConfirmPasswordField;
    @FXML
    private Button SigninButton;
    @FXML
    private Button SignupButton;

    public void initialize() {
        setSignup();
    }

    private void setSignup() {
        myTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            checkFields(myTextField.getText(), myPasswordField.getText(), myConfirmPasswordField.getText(), SignupButton);
        });
        myPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {
            checkFields(myTextField.getText(), myPasswordField.getText(), myConfirmPasswordField.getText(), SignupButton);
        });
        myConfirmPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {
            checkFields(myTextField.getText(), myPasswordField.getText(), myConfirmPasswordField.getText(), SignupButton);
        });
    }

    private void checkFields(String username, String password, String confirmpassword, Button SignupButton) {
        if (username.length() >= 8 && password.length() >= 8 && confirmpassword.length() >= 8) {
            SignupButton.setDisable(false);
        } else {
            SignupButton.setDisable(true);
        }
    }

    public void switchToSceneSignin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/english/Signin-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createAccount(ActionEvent event) throws IOException {
        String username = myTextField.getText();
        String password = myPasswordField.getText();
        String confirmpassword = myConfirmPasswordField.getText();
        if (!Login.checkUsernameContain(username)) {
            if (Login.checkConfirmPassword(password, confirmpassword)) {
                Login.SignupAccount(username, password);
                Login.saveAccount();
                InitializeTrie.createTrie("database");
                SaveTrie.saveTrie(username);
                DictionaryFavorite.saveFavorite(username);
                root = FXMLLoader.load(getClass().getResource("/com/example/english/Signin-view.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                myConfirmPasswordField.setText("");
                myConfirmPasswordField.setPromptText("Mật khẩu xác nhận không chính xác");
                SigninButton.requestFocus();
            }
        } else {
            myTextField.setText("");
            myTextField.setPromptText("Tên đăng nhập đã tồn tại");
            SigninButton.requestFocus();
        }
    }
}
