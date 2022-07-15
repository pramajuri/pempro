module model.pemrograman {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.logging;
    requires java.sql;

    opens pemro.model to javafx.fxml;
    exports pemro.model;
    exports pemro.controller;
    opens pemro.controller to javafx.fxml;
}