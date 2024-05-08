package com.example.english.Controller;


import com.almasb.fxgl.entity.action.Action;
import com.example.english.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Locale;
//import javax.speech.AudioException;
//import javax.speech.Central;
//import javax.speech.EngineException;
//import javax.speech.EngineStateError;
//import javax.speech.synthesis.Synthesizer;
//import javax.speech.synthesis.SynthesizerModeDesc;

public class SearchController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField searchTextField;
    @FXML
    private ListView<String> searchListView = new ListView<>();
    @FXML
    private TextArea searchTextArea;
    @FXML
    private ListView<String> favoriteListView = new ListView<>();
    @FXML
    private Button menuButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button GameButton;
    @FXML
    private Button LogoutButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button soundButton;
    @FXML
    private Button favoriteButton;

    public void initialize() {
        setSearchTextField();
        setFavoriteListView();
    }

    public void printMenu(ActionEvent event) {
        if (searchButton.isVisible()) {
            searchButton.setVisible(false);
            updateButton.setVisible(false);
            GameButton.setVisible(false);
            LogoutButton.setVisible(false);
        } else {
            searchButton.setVisible(true);
            updateButton.setVisible(true);
            GameButton.setVisible(true);
            LogoutButton.setVisible(true);
        }
    }

    public void switchToSearch(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(getClass().getResource("/com/example/english/Search-view.fxml"));
        borderPane.setCenter(view.getCenter());
    }

    public void switchToTranslate(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/com/example/english/Translate-view.fxml"));
        borderPane.setCenter(view);
    }

    public void switchToGame(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/com/example/english/Game-view.fxml"));
        borderPane.setCenter(view);
    }

    public void switchToSceneSignin(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Bạn muốn đăng xuất khỏi tài khoản");
        if (alert.showAndWait().get() == ButtonType.OK) {
            SaveTrie.saveTrie(Login.getUsername());
            DictionaryFavorite.saveFavorite(Login.getUsername());
            root = FXMLLoader.load(getClass().getResource("/com/example/english/Signin-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void setSearchTextField() {
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            searchListView.setVisible(true);
            searchListView.getItems().clear();
            ArrayList<String> searchResults = DictionarySearch.dictionarySearch(newValue);
            for (String suggestion : searchResults) {
                searchListView.getItems().add(suggestion);
            }
        });

        searchTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                searchListView.getSelectionModel().selectNext();
                event.consume();
            } else if (event.getCode() == KeyCode.UP) {
                searchListView.getSelectionModel().selectPrevious();
                event.consume();
            } else if (event.getCode() == KeyCode.ENTER) {
                String selectedSuggestion = searchListView.getSelectionModel().getSelectedItem();
                if (selectedSuggestion != null) {
                    searchTextField.setText(selectedSuggestion);
                    searchTextArea.setText(DictionaryLookup.dictionaryLookup(selectedSuggestion));
                    searchListView.setVisible(false);
                }
                event.consume();
            }
        });


        searchTextField.setOnAction(event -> {
            String keyword = searchTextField.getText();
            searchTextArea.setText(DictionaryLookup.dictionaryLookup(keyword));
            searchListView.setVisible(false);
        });

        searchListView.setOnMouseClicked(event -> {
            String selectedSuggestion = searchListView.getSelectionModel().getSelectedItem();
            if (selectedSuggestion != null) {
                searchTextField.setText(selectedSuggestion);
                searchTextArea.setText(DictionaryLookup.dictionaryLookup(selectedSuggestion));
                searchListView.setVisible(false);
            }
        });

        searchListView.setOnMouseExited(event -> {
            searchListView.setVisible(false);
        });
    }

    public void removeWord(ActionEvent event) {
        String removeWord = searchTextField.getText();
        if (!removeWord.isEmpty()) {
            if (TrieOperation.containWord(removeWord)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Bạn chắc chắn muốn xóa từ khỏi từ điển");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    RemoveDictionary.removeHelp(removeWord);
                    DictionaryFavorite.removeFavorite(removeWord);
                    setFavoriteListView();
                    alert.close();
                }
                setFavoriteListView();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Từ này không tồn tại trong từ điển");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Bạn chưa chọn từ để xóa khỏi từ điển");
            alert.showAndWait();
        }
    }

    public void updateWord(ActionEvent event) {
        String updateWord = searchTextField.getText();
        if (searchTextArea.isEditable()) {
            String updateWordMeaning = searchTextArea.getText();
            if (updateWordMeaning.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Bạn chưa nhập thông tin của từ");
                alert.showAndWait();
            } else {
                if (TrieOperation.containWord(updateWord)) {
                    UpdateDictionary.updateDictionary(updateWord, updateWordMeaning);
                } else {
                    TrieOperation.insertTrie(updateWord, updateWordMeaning);
                }
                searchButton.setDisable(false);
                updateButton.setDisable(false);
                GameButton.setDisable(false);
                LogoutButton.setDisable(false);
                searchTextField.setDisable(false);
                favoriteListView.setDisable(false);
                removeButton.setDisable(false);
                soundButton.setDisable(false);
                favoriteButton.setDisable(false);
                searchTextArea.setEditable(false);
            }
        } else {
            if (!updateWord.isEmpty()) {
                if (TrieOperation.containWord(updateWord)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Bạn chắc chắn muốn sửa thông tin của từ");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        searchButton.setDisable(true);
                        updateButton.setDisable(true);
                        GameButton.setDisable(true);
                        LogoutButton.setDisable(true);
                        searchTextField.setDisable(true);
                        favoriteListView.setDisable(true);
                        removeButton.setDisable(true);
                        soundButton.setDisable(true);
                        favoriteButton.setDisable(true);
                        searchTextArea.setEditable(true);
                        alert.close();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Bạn chắc chắn muốn thêm từ vào từ điển");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        searchButton.setDisable(true);
                        updateButton.setDisable(true);
                        GameButton.setDisable(true);
                        LogoutButton.setDisable(true);
                        searchTextField.setDisable(true);
                        favoriteListView.setDisable(true);
                        removeButton.setDisable(true);
                        soundButton.setDisable(true);
                        favoriteButton.setDisable(true);
                        searchTextArea.setEditable(true);
                        alert.close();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Bạn chưa chọn từ để thêm vào từ điển");
                alert.showAndWait();
            }
        }
    }


    public void addFavoriteListView(ActionEvent event) {
        String wordFavorite = searchTextField.getText();
        if (!wordFavorite.isEmpty()) {
            if (DictionaryFavorite.containFavorite(wordFavorite)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Từ này đã tồn tại trong danh sách yêu thích");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Bạn chắc chắn muốn thêm từ vào danh sách yêu thích");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    DictionaryFavorite.dictionaryFavorite(wordFavorite);
                    alert.close();
                }
                setFavoriteListView();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Bạn chưa chọn từ để thêm vào danh sách yêu thích");
            alert.showAndWait();
        }
    }

    public void setFavoriteListView() {
        favoriteListView.getItems().clear();
        for (String string : DictionaryFavorite.getListFavorite()) {
            favoriteListView.getItems().add(string);
        }
        favoriteListView.setOnMouseClicked(event -> {
            String wordFavorite = favoriteListView.getSelectionModel().getSelectedItem();
            if (wordFavorite != null) {
                searchTextField.setText(wordFavorite);
                searchListView.setVisible(false);
                searchTextArea.setText(DictionaryLookup.dictionaryLookup(wordFavorite));
            }
        });
        favoriteListView.setOnContextMenuRequested(event -> {
            String wordFavorite = favoriteListView.getSelectionModel().getSelectedItem();
            if (wordFavorite != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Bạn chắc chắn muốn xóa từ khỏi danh sách yêu thích");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    DictionaryFavorite.removeFavorite(wordFavorite);
                    setFavoriteListView();
                    alert.close();
                }
            }
        });
    }

    public void textToSpeech() {
//        String string = searchTextField.getText();
//        System.setProperty("freetts.voices",
//                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//        try {
//            Central.registerEngineCentral("com.sun.speech.freetts" +
//                    ".jsapi.FreeTTSEngineCentral");
//            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc
//                    (Locale.US));
//            synthesizer.allocate();
//            synthesizer.resume();
//
//            synthesizer.speakPlainText(string, null);
//            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
//            synthesizer.deallocate();
//        } catch (EngineException | IllegalArgumentException | InterruptedException
//                 | EngineStateError | AudioException e) {
//            e.printStackTrace();
//        }
        String string = searchTextField.getText();
        SoundAPI.AudioPlay(string, "en");
    }


}
