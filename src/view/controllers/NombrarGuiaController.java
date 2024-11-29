package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NombrarGuiaController {

    @FXML
    private TextField addNameTextField;

    @FXML
    private Button addButton;

    private static String projectTitle;

    @FXML
    public void handleAddButtonAction() {
        projectTitle = addNameTextField.getText();

        if (projectTitle == null || projectTitle.trim().isEmpty()) {
            System.out.println("El título del proyecto no puede estar vacío.");
            return;
        }

        SceneController.changeScene("/view/scenes/checklistTipoObraWindow.fxml");
    }

    public static String getProjectTitle() {
        return projectTitle;
    }
}
