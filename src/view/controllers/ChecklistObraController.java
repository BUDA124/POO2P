package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ChecklistObraController {
    @FXML
    private CheckBox obraCivilCheckBox;

    @FXML
    private CheckBox edificacionCheckBox;

    @FXML
    private CheckBox obraResidencialCheckBox;

    @FXML
    private CheckBox obraIndustrialCheckBox;

    @FXML
    private CheckBox obraComercialCheckBox;

    @FXML
    private CheckBox obraInstitucionalCheckBox;

    @FXML
    private CheckBox obraPublicaCheckBox;

    @FXML
    private CheckBox ningunaCheckBox;


    @FXML
    private Button siguienteButton;

    @FXML
    public void handleSiguienteButtonAction() {
        boolean atLeastOneSelected = obraCivilCheckBox.isSelected() ||
                edificacionCheckBox.isSelected() ||
                obraResidencialCheckBox.isSelected() ||
                obraIndustrialCheckBox.isSelected() ||
                obraComercialCheckBox.isSelected() ||
                obraInstitucionalCheckBox.isSelected() ||
                obraPublicaCheckBox.isSelected();

        if (atLeastOneSelected || ningunaCheckBox.isSelected()) {

            SceneController.changeScene("/path/to/checklistProfesionalWindow.fxml");
        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se ha seleccionado ningún tipo de obra");
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

        obraCivilCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        edificacionCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        obraResidencialCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        obraIndustrialCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        obraComercialCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        obraInstitucionalCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
        obraPublicaCheckBox.setOnAction(event -> ningunaCheckBox.setSelected(false));
    }

    private void desmarcarOtrosCheckBoxes() {
        obraCivilCheckBox.setSelected(false);
        edificacionCheckBox.setSelected(false);
        obraResidencialCheckBox.setSelected(false);
        obraIndustrialCheckBox.setSelected(false);
        obraComercialCheckBox.setSelected(false);
        obraInstitucionalCheckBox.setSelected(false);
        obraPublicaCheckBox.setSelected(false);
    }
}
