package view.controllers;

import control.SafetyGuideController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private void handleOpenWindow(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la segunda ventana
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/scenes/SecondWindow.fxml"));
            Parent root = fxmlLoader.load();

            // Crear un nuevo stage
            Stage stage = new Stage();
            stage.setTitle("Second Window");
            stage.setScene(new Scene(root));

            // Hacer que la ventana sea modal
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait(); // Espera hasta que se cierre

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}