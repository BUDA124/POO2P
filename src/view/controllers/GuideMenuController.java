package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class GuideMenuController {

    @FXML
    private Button basicaButton;

    @FXML
    private Button personalizarButton;

    @FXML
    public void handleBasicaAction() {
        SceneController.changeScene("/view/scenes/guardarGuiaWindow.fxml");
    }

    @FXML
    public void handlePersonalizarAction() {
        SceneController.changeScene("/view/scenes/nombrarGuiaWindow.fxml");
    }
}
