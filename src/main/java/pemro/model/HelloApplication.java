package pemro.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    double x,y = 0;
    @Override
    public void start(Stage stage) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);

        fxml.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        fxml.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setX(event.getScreenX() - y);
        });

        stage.setTitle("Motorbike Rent App");
        stage.setScene(new Scene(fxml));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}