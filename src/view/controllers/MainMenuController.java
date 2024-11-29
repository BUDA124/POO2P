package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    @FXML
    private Button generarGuiaButton;

    @FXML
    private Button accederGuiaButton;

    @FXML
    private Button conocerRiesgosButton;

    @FXML
    private Button feedbackButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void handleGenerarGuiaAction() {
        SceneController.changeScene("/view/scenes/guideMenuWindow.fxml");
    }

    @FXML
    public void handleConocerRiesgosAction() {
        SceneController.changeScene("/view/scenes/informationMenuWindow.fxml");
    }

    @FXML
    public void handleFeedbackAction() {
        SceneController.changeScene("/view/scenes/feedbackWindow.fxml");
    }

    @FXML
    public void handleLogoutAction() {
        SceneController.changeScene("/view/scenes/loginWindow.fxml");
    }
}
