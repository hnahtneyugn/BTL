package com.example.english.Controller;

import com.example.english.Model.API;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

import java.io.IOException;

public class TranslateController {
    @FXML
    private MenuButton menuButton;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea outputTextArea;

    @FXML
    public void initialize() throws IOException {
        SetTranslate();
    }

    public void setEnglishVietnamese(ActionEvent event) {
        menuButton.setText("Anh - Việt");
    }

    public void setVietnameseEnglish(ActionEvent event) {
        menuButton.setText("Việt - Anh");
    }

    public void SetTranslate() throws IOException {
        inputTextArea.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String input = inputTextArea.getText();
                String output;
                if (menuButton.getText().equals("Anh - Việt")) {
                    output = API.translate("en", "vi", input);
                    outputTextArea.setText(output);
                } else {
                    output = API.translate("vi", "en", input);
                    outputTextArea.setText(output);
                }
            }
        });
        menuButton.setOnAction(event -> {
            String input = inputTextArea.getText();
            String output;
            if (menuButton.getText().equals("Anh - Việt")) {
                output = API.translate("en", "vi", input);
                outputTextArea.setText(output);
            } else {
                output = API.translate("vi", "en", input);
                outputTextArea.setText(output);
            }
        });
    }
}
