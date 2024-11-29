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
        if (ningunaCheckBox.isSelected()) {
            ChecklistController.getSelectedWorks().clear();
            ChecklistController.addSelectedWork("Ninguna");
        } else {
            if (obraCivilCheckBox.isSelected()) ChecklistController.addSelectedWork("Obra Civil");
            if (edificacionCheckBox.isSelected()) ChecklistController.addSelectedWork("Edificación");
            if (obraResidencialCheckBox.isSelected()) ChecklistController.addSelectedWork("Obra Residencial");
            if (obraIndustrialCheckBox.isSelected()) ChecklistController.addSelectedWork("Obra Industrial");
            if (obraComercialCheckBox.isSelected()) ChecklistController.addSelectedWork("Obra Comercial");
            if (obraInstitucionalCheckBox.isSelected()) ChecklistController.addSelectedWork("Obra Institucional");
            if (obraPublicaCheckBox.isSelected()) ChecklistController.addSelectedWork("Obra Pública");
        }

        boolean atLeastOneSelected = !ChecklistController.getSelectedWorks().isEmpty();

        if (atLeastOneSelected) {

            SceneController.changeScene("/view/scenes/checklistProfesionalWindow.fxml");
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
