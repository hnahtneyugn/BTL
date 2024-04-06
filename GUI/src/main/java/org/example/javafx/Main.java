package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        BorderPane root = fxmlLoader.load();
        mainController mc = fxmlLoader.getController();
        mc.setContent();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menuBar.fxml"));
        AnchorPane menuBar = menuLoader.load();
        menuBarController mbc = menuLoader.getController();
        mbc.setMainController(mc);

        root.setTop(menuBar);

        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("stylesheet.css")).toExternalForm());
        stage.setTitle("English Learner GUI v2.0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}