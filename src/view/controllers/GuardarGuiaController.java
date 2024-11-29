package view.controllers;

import control.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GuardarGuiaController {

    @FXML
    private Button leerButton;

    @FXML
    private Button chequearButton;

    @FXML
    private void initialize() {}


    @FXML
    private void handleleerButton() {
        SystemController controller = SystemController.getInstance();

    }


    @FXML
    private void handlechequearButton() {

    }
    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
    }

}
