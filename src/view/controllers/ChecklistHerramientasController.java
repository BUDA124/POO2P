package view.controllers;

import control.SystemController;
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
    private Button crearButton;

    @FXML
    public void handleCrearButtonAction() {
        if (ningunaCheckBox.isSelected()) {
            ChecklistController.getSelectedTools().clear();
            ChecklistController.addSelectedTool("Ninguna");
        } else {
            if (generadorCheckBox.isSelected()) ChecklistController.addSelectedTool("Generador");
            if (hormigoneraCheckBox.isSelected()) ChecklistController.addSelectedTool("Hormigonera");
            if (placaCheckBox.isSelected()) ChecklistController.addSelectedTool("Placa Vibratoria");
            if (carretillaCheckBox.isSelected()) ChecklistController.addSelectedTool("Carretilla");
            if (pistolaCheckBox.isSelected()) ChecklistController.addSelectedTool("Pistola de Clavos");
            if (nivelCheckBox.isSelected()) ChecklistController.addSelectedTool("Nivel Láser");
            if (llavesCheckBox.isSelected()) ChecklistController.addSelectedTool("Llaves de Mano");
            if (serruchoCheckBox.isSelected()) ChecklistController.addSelectedTool("Serrucho");
            if (taladroCheckBox.isSelected()) ChecklistController.addSelectedTool("Taladro");
        }

        boolean atLeastOneSelected = !ChecklistController.getSelectedTools().isEmpty();

        if (atLeastOneSelected) {
            SystemController systemController = SystemController.getInstance();
            systemController.createCustomGuide();
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            mostrarAlerta(alertType, "Guía Creada", "Se ha creado la guía exitosamente. Puedes accederla en 'Acceder Guías' en el menú principal.");
            SceneController.changeScene("/view/scenes/guideMenuWindow.fxml");
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
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
