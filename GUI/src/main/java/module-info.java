module com.example.english {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires jlayer;
//    requires jsapi;

    opens com.example.english to javafx.fxml;
    exports com.example.english;

    opens com.example.english.Controller to javafx.fxml;
    exports com.example.english.Controller;
}
