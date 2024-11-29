package view.controllers;

import control.SystemController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import models.general.BasicSafetyGuide;
import models.general.SafetyGuide;
import models.services.UserService;

public class GuideMenuController {

    @FXML
    private Button basicaButton;

    @FXML
    private Button personalizarButton;

    @FXML
    public void handleBasicaAction() {
            SystemController controller = SystemController.getInstance();
            controller.createBasicGuide();
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            mostrarAlerta(alertType, "Guía Creada", "Se ha creado la guía exitosamente. Puedes accederla en 'Acceder Guías' en el menú principal.");

    }

    @FXML
    public void handlePersonalizarAction() {
        SceneController.changeScene("/view/scenes/nombrarGuiaWindow.fxml");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
    }
}

