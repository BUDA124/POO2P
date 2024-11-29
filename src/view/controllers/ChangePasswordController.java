package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ChangePasswordController {

    @FXML
    private TextField correoElectronicoTextField;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Label goBackButton;

    @FXML
    private Label mensajeLabel;

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
        String correo = correoElectronicoTextField.getText();

        if (correo == null || correo.isEmpty()) {
            mostrarMensaje("Ingresa un correo electrónico.", Color.RED);
            return;
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            mostrarMensaje("Tu correo no parece estar en el formato correcto.", Color.RED);
            return;
        }

        enviarCorreo(correo);
        mostrarMensaje("Se ha enviado un enlace a tu correo.", Color.GREEN);
    }

    @FXML
    private void enviarCorreo(String correo) {
        System.out.println("Correo enviado a: " + correo); // Simulación de envío
    }

    @FXML
    private void mostrarMensaje(String mensaje, Color color) {
        if (mensajeLabel == null) {
            mensajeLabel = new Label();
            mensajeLabel.setFont(new Font(12));
            mensajeLabel.setTextFill(color);
            mensajeLabel.setLayoutX(500);
            mensajeLabel.setLayoutY(550);
            ((AnchorPane) correoElectronicoTextField.getParent()).getChildren().add(mensajeLabel);
        }
        mensajeLabel.setTextFill(color);
        mensajeLabel.setText(mensaje);
    }
}
