package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.general.SafetyGuide;
import control.SystemController;

import java.util.List;

public class AccederGuiasController {

    @FXML
    private VBox guidesContainer;

    @FXML
    private Label errorMessage;

    private final SystemController systemController = SystemController.getInstance();

    @FXML
    public void initialize() {
        loadSavedGuides();
    }

    private void loadSavedGuides() {
        List<SafetyGuide> guideList = systemController.getSavedGuidesForCurrentUser();

        guidesContainer.getChildren().clear();

        if (guideList == null || guideList.isEmpty()) {
            errorMessage.setText("No tienes guías guardadas.");
            return;
        }

        errorMessage.setText("");

        for (SafetyGuide guide : guideList) {
            Button guideButton = new Button("Guía: " + guide.getId() + " (Fecha: " + guide.getCreationDate() + ")");
            guideButton.setStyle("-fx-font-size: 16; -fx-background-color: #E5B93F; -fx-text-fill: white;");
            guideButton.setOnAction(event -> openGuideDetails(guide));
            guidesContainer.getChildren().add(guideButton);
        }
    }

    private void openGuideDetails(SafetyGuide guide) {
        SystemController systemController = SystemController.getInstance();
        systemController.setCurrentSafetyGuide(guide);
        SceneController.changeScene("/view/scenes/gestionarGuiaWindow.fxml");
    }

    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
    }
}
