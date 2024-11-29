package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    // Método para inicializar el controlador
    @FXML
    public void initialize() {
        // Puedes inicializar cosas aquí si es necesario
    }

    // Método para manejar el evento de clic en el botón
    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Aquí puedes agregar la lógica para verificar las credenciales
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("¡Inicio de sesión exitoso!");
            // Puedes cambiar de escena o mostrar un mensaje
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
            // Mostrar alerta o mensaje de error
        }
    }
}
