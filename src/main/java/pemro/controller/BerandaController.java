package pemro.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import pemro.model.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BerandaController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(BerandaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void homeAction (javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    public void motorAction (ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Motor.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}
