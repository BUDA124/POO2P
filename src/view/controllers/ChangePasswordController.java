package view.controllers;

import control.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.general.User;
import models.services.MailService;
import models.services.UserService;

import java.util.Optional;

public class ChangePasswordController {

    @FXML
    private TextField correoElectronicoTextField;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Label goBackButton;

    @FXML
    public void initialize() {

        goBackButton.setOnMouseClicked(event -> {
            SceneController.changeScene("/view/scenes/loginWindow.fxml");
        });

        changePasswordButton.setOnAction(event -> {
            validarYEnviarCorreo();
        });
    }

    @FXML
    private void validarYEnviarCorreo() {
        User user;
        SystemController controller = SystemController.getInstance();
        MailService mailService = controller.getMailService();

        String correo = correoElectronicoTextField.getText();

        if (correo != null && !correo.isEmpty()) {
            mailService.notifyPasswordChange(correo);
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            mostrarAlerta(alertType, "Correo inválido", "Rellene la información adecuadamente, con un correo válido.");
        } else {
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            mostrarAlerta(alertType, "Correo enviado", "El correo con las intrucciones se ha enviado, puede revisarlo.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
