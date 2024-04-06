package org.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Objects;

public class mainController {
    @FXML
    public BorderPane mainPane;
    @FXML
    public AnchorPane menuHolder;

    @FXML
    public AnchorPane homeAnchor;

    @FXML
    public AnchorPane addUpdateAnchor;

    @FXML
    public AnchorPane removeAnchor;

    @FXML
    public AnchorPane searchAnchor;

    @FXML
    public AnchorPane gameAnchor;

    @FXML
    public AnchorPane favoriteAnchor;

    public void setContent() {
        try {
            menuHolder = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuBar.fxml")));
            homeAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            addUpdateAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add.fxml")));
            removeAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("remove.fxml")));
            searchAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
            gameAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
            favoriteAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("favorite.fxml")));
            mainPane.setTop(menuHolder);
            mainPane.setCenter(homeAnchor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
