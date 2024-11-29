package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
        String correo = correoElectronicoTextField.getText();


        if (correo == null || correo.isEmpty()) {
            mostrarMensaje("Ingresa un correo electrónico.", Color.RED);
            return;
        }


        if (!correo.contains("@") || !correo.contains(".")) {
            mostrarMensaje("Tu correo no parece estar en el formato correcto.", Color.RED);
            return;
        }


        enviarUsuario(correo);
        mostrarMensaje("Tu usuario ha sido enviado al correo dado.", Color.GREEN);
    }
    @FXML
    private void enviarUsuario(String correo) {

        System.out.println("Nombre de usuario enviado a: " + correo);
    }
    @FXML
    private void mostrarMensaje(String mensaje, Color color) {
        mensajeLabel.setTextFill(color);
        mensajeLabel.setText(mensaje);
    }
}
