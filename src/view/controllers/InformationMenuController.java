package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class InformationMenuController {

    @FXML
    private Label headerLabel;

    @FXML
    private Button herramientasButton;

    @FXML
    private Button profesionalesButton;

    @FXML
    private Button obrasButton;

    @FXML
    private Button riesgosButton;

    @FXML
    public void handleHerramientasButton() {
        SceneController.changeScene("/view/scenes/toolsInfoWindow.fxml");
    }
    @FXML
    public void handleProfesionalesButton() {
        SceneController.changeScene("/view/scenes/profesionalsInfoWindow.fxml");
    }
    @FXML
    public void handleObrasButton() {
        SceneController.changeScene("/view/scenes/constructionWorkInfoWindow.fxml");
    }
    @FXML
    public void handleRiesgosButton() {
        SceneController.changeScene("/view/scenes/risksInfoWindow.fxml");
    }
}
