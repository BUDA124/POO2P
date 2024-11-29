package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ChecklistProfesionalesController {

    @FXML
    private CheckBox albanilCheckBox;

    @FXML
    private CheckBox peonesCheckBox;

    @FXML
    private CheckBox electricistaCheckBox;

    @FXML
    private CheckBox pintoresCheckBox;

    @FXML
    private CheckBox encofradoresCheckBox;

    @FXML
    private CheckBox oficialesCheckBox;

    @FXML
    private CheckBox montadoresCheckBox;

    @FXML
    private CheckBox ningunoCheckBox;

    @FXML
    private Button siguienteButton;

    @FXML
    public void handleSiguienteButtonAction() {
        boolean atLeastOneSelected = albanilCheckBox.isSelected() ||
                peonesCheckBox.isSelected() ||
                electricistaCheckBox.isSelected() ||
                pintoresCheckBox.isSelected() ||
                encofradoresCheckBox.isSelected() ||
                oficialesCheckBox.isSelected() ||
                montadoresCheckBox.isSelected();

        if (atLeastOneSelected || ningunoCheckBox.isSelected()) {
            SceneController.changeScene("/path/to/checklistHerramientasWindow.fxml");
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se ha seleccionado ningún profesional");
            alert.setContentText("Seleccione al menos una opción para continuar.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        ningunoCheckBox.setOnAction(event -> {
            if (ningunoCheckBox.isSelected()) {
                desmarcarOtrosCheckBoxes();
            }
        });

        albanilCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
        peonesCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
        electricistaCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
        pintoresCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
        encofradoresCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
        oficialesCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
        montadoresCheckBox.setOnAction(event -> ningunoCheckBox.setSelected(false));
    }

    private void desmarcarOtrosCheckBoxes() {
        albanilCheckBox.setSelected(false);
        peonesCheckBox.setSelected(false);
        electricistaCheckBox.setSelected(false);
        pintoresCheckBox.setSelected(false);
        encofradoresCheckBox.setSelected(false);
        oficialesCheckBox.setSelected(false);
        montadoresCheckBox.setSelected(false);
    }
}
