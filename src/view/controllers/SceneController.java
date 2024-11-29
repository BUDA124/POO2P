package view.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void changeScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneController.class.getResource(fxmlFile));
            Parent root = loader.load();
            stage.setScene(new Scene(root, 1204, 840));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

