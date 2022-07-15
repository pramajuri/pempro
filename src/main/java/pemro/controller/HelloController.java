package pemro.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pemro.model.HelloApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    public AnchorPane rootVBox;
    @FXML
    private Label notif;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void openAction(ActionEvent actionEvent) throws IOException {
        DBConn connectNew = new DBConn();
        Connection connectDB = connectNew.getConnection();

        String verifikasiLogin = "SELECT COUNT(1) FROM user WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";

        try {
            Statement statement     = connectDB.createStatement();
            ResultSet queryResult   = statement.executeQuery(verifikasiLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("Beranda.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Home Rent App");
                    stage.setScene(new Scene(root));
                    stage.initOwner(rootVBox.getScene().getWindow());
                    stage.show();
                } else {
                    notif.setText("Gagal Login, Coba Lagi");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeAction(ActionEvent actionEvent) {
        Stage keluar = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        keluar.close();
    }

}

