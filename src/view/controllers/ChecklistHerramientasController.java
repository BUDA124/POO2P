package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ChecklistHerramientasController {

    @FXML
    private CheckBox generadorCheckBox;

    @FXML
    private CheckBox hormigoneraCheckBox;

    @FXML
    private CheckBox placaCheckBox;

    @FXML
    private CheckBox carretillaCheckBox;

    @FXML
    private CheckBox pistolaCheckBox;

    @FXML
    private CheckBox nivelCheckBox;

    @FXML
    private CheckBox llavesCheckBox;

    @FXML
    private CheckBox serruchoCheckBox;

    @FXML
    private CheckBox taladroCheckBox;

    @FXML
    private CheckBox ningunaCheckBox;

    @FXML
    private Button siguienteButton;

    @FXML
    public void handleSiguienteButtonAction() {
        boolean atLeastOneSelected = generadorCheckBox.isSelected() ||
                hormigoneraCheckBox.isSelected() ||
                placaCheckBox.isSelected() ||
                carretillaCheckBox.isSelected() ||
                pistolaCheckBox.isSelected() ||
                nivelCheckBox.isSelected() ||
                llavesCheckBox.isSelected() ||
                serruchoCheckBox.isSelected() ||
                taladroCheckBox.isSelected();

        if (atLeastOneSelected || ningunaCheckBox.isSelected()) {
            SceneController.changeScene("/path/to/guardarGuiaWindow.fxml");
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se ha seleccionado ninguna herramienta");
            alert.setContentText("Seleccione al menos una opción para continuar.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        ningunaCheckBox.setOnAction(event -> {
            if (ningunaCheckBox.isSelected()) {
                desmarcarOtrosCheckBoxes();
            }
        });

        generadorCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        hormigoneraCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        placaCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        carretillaCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        pistolaCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        nivelCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        llavesCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        serruchoCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        taladroCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
    }

    private void desmarcarOtrosCheckBoxes() {
        generadorCheckBox.setSelected(false);
        hormigoneraCheckBox.setSelected(false);
        placaCheckBox.setSelected(false);
        carretillaCheckBox.setSelected(false);
        pistolaCheckBox.setSelected(false);
        nivelCheckBox.setSelected(false);
        llavesCheckBox.setSelected(false);
        serruchoCheckBox.setSelected(false);
        taladroCheckBox.setSelected(false);
    }
}
