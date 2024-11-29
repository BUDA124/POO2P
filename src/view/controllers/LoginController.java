package view.controllers;
import control.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.general.SafetyGuide;
import models.general.User;
import models.repositories.FileBasedUserRepository;
import models.services.UserService;

import java.util.Optional;

public class LoginController {

        @FXML
        private TextField usernameTextField;

        @FXML
        private TextField passwordTextField;

        @FXML
        private Button loginButton;

        @FXML
        private Label registerButton;

        @FXML
        private Label forgotPasswordButton;

        @FXML
        public void initialize() {}

    @FXML
    private void handleLoginButtonAction() {

        SystemController controller = SystemController.getInstance();
        UserService userService = controller.getUserService();

        // Obtener los datos ingresados en los campos de texto
        String currentUsername = usernameTextField.getText();
        String contrasena = passwordTextField.getText();

        Optional<User> optionalUser = userService.findById(currentUsername);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Validar contraseña
            if (user.validatePassword(contrasena)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + user.getName());
                controller.setCurrentUser(user);
                SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
            } else {
                Alert.AlertType alertType = Alert.AlertType.ERROR;
                mostrarAlerta(alertType, "Contraseña incorrecta", "Revise los datos o cree una cuenta.");
            }
        } else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            mostrarAlerta(alertType, "Usuario no encontrado", "Revise los datos o cree una cuenta.");
        }
    }

    @FXML
    private void handleRegisterButtonAction() {
        SceneController.changeScene("/view/scenes/registerWindow.fxml");
    }

    @FXML
    private void handleForgotPasswordButtonAction() {
        SceneController.changeScene("/view/scenes/changePasswordWindow.fxml");
    }

    @FXML
    private void handleForgotUserButtonAction() {
        SceneController.changeScene("/view/scenes/changeUserWindow.fxml");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}


