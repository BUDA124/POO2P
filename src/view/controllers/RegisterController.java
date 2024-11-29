package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class RegisterController {

    @FXML
    private TextField nombreCompletoTextField;

    @FXML
    private TextField nombreUsuarioTextField;

    @FXML
    private TextField correoElectronicoTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField confirmationPasswordTextField;

    @FXML
    private Button createAccountButton;

    @FXML
    private Label loginButton;

    @FXML
    private Label mensajeLabel;

    @FXML
    public void initialize() {

        loginButton.setOnMouseClicked(event -> {
            handleGoToLogin();
        });


        createAccountButton.setOnAction(event -> {
            handleCreateAccount();
        });
    }

    @FXML
    private void handleGoToLogin() {
        SceneController.changeScene("/path/to/loginWindow.fxml");
    }

    @FXML
    private void handleCreateAccount() {
        String password = passwordTextField.getText();
        String confirmPassword = confirmationPasswordTextField.getText();

        if (password == null || confirmPassword == null || password.isEmpty() || confirmPassword.isEmpty()) {
            mostrarMensaje("Completa todos los campos.", Color.RED);
            return;
        }

        if (!password.equals(confirmPassword)) {
            mostrarMensaje("Las contraseñas no coinciden.", Color.RED);
            return;
        }

        if (!validarContraseña(password)) {
            mostrarMensaje("La contraseña debe tener entre 5 y 10 caracteres e incluir un número o carácter especial.", Color.RED);
            return;
        }

        mostrarMensaje("Cuenta creada exitosamente.", Color.BLUE);
        System.out.println("Bienvenido(a) " + nombreUsuarioTextField.getText());
    }

    private boolean validarContraseña(String password) {
        if (password.length() < 5 || password.length() > 10) {
            return false;
        }
        return password.matches(".*[0-9!@#$%^&*].*");
    }

    private void mostrarMensaje(String mensaje, Color color) {
        mensajeLabel.setTextFill(color);
        mensajeLabel.setText(mensaje);
    }
}
