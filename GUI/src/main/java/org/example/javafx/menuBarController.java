package org.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class menuBarController {
    private mainController mc;

    public void setMainController(mainController mc) {
        this.mc = mc;
    }

    @FXML
    private VBox addUpdate;

    @FXML
    private Button addUpdateButton;

    @FXML
    private ImageView addUpdateImage;

    @FXML
    private Label addUpdateText;

    @FXML
    private Button exitButton;

    @FXML
    private ImageView exitImage;

    @FXML
    private VBox favorite;

    @FXML
    private Button favoriteButton;

    @FXML
    private ImageView favoriteImage;

    @FXML
    private Label favoriteText;

    @FXML
    private VBox game;

    @FXML
    private Button gameButton;

    @FXML
    private ImageView gameImage;

    @FXML
    private Label gameText;

    @FXML
    private VBox home;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView homeImage;

    @FXML
    private Label homeText;

    @FXML
    private HBox mainButtons;

    @FXML
    private HBox menuBar;

    @FXML
    private AnchorPane menuHolder;

    @FXML
    private VBox remove;

    @FXML
    private Button removeButton;

    @FXML
    private ImageView removeImage;

    @FXML
    private Label removeText;

    @FXML
    private VBox search;

    @FXML
    private Button searchButton;

    @FXML
    private ImageView searchImage;

    @FXML
    private Label searchText;

    @FXML
    private Pane space;

    @FXML
    void setHomeAnchor(MouseEvent event) {
        mc.mainPane.setCenter(mc.homeAnchor);
    }

    @FXML
    void setAddUpdateAnchor(MouseEvent event) {
        mc.mainPane.setCenter(mc.addUpdateAnchor);
    }

    @FXML
    void setRemoveAnchor(MouseEvent event) {
        mc.mainPane.setCenter(mc.removeAnchor);
    }

    @FXML
    void setSearchAnchor(MouseEvent event) {
        mc.mainPane.setCenter(mc.searchAnchor);
    }

    @FXML
    void setGameAnchor(MouseEvent event) {
        mc.mainPane.setCenter(mc.gameAnchor);
    }

    @FXML
    void setFavoriteAnchor(MouseEvent event) {
        mc.mainPane.setCenter(mc.favoriteAnchor);
    }

    @FXML
    void quit(MouseEvent event) {
        System.exit(0);
    }
}
