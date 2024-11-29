package view.controllers;

import control.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import models.services.MailService;

public class ChangeUserController {

    @FXML
    private TextField correoElectronicoTextField;

    @FXML
    private Button solicitarUsuarioButton;

    @FXML
    private Label goBackButton;

    @FXML
    private Label mensajeLabel;

    @FXML
    public void initialize() {
        goBackButton.setOnMouseClicked(event -> {
            SceneController.changeScene("/view/scenes/loginWindow.fxml");
        });

        solicitarUsuarioButton.setOnAction(event -> {
            validarYEnviarUsuario();
        });
    }
    @FXML
    private void validarYEnviarUsuario() {
        SystemController controller = SystemController.getInstance();
        MailService mailService = controller.getMailService();
        String correo = correoElectronicoTextField.getText();
        mailService.notifyForgottenUsername(correo);
        Alert.AlertType alertType = Alert.AlertType.INFORMATION;
        mostrarAlerta(alertType, "Envío de correo", "Correo enviado a " + correo);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
