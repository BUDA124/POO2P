package view.controllers;

import control.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import models.general.User;
import models.services.MailService;
import models.services.SafetyGuideService;
import models.services.UserService;

import java.util.HashMap;

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
        SceneController.changeScene("/view/scenes/loginWindow.fxml");
    }

    @FXML
    private void handleCreateAccount() {

        SystemController controller = SystemController.getInstance();
        UserService userService = controller.getUserService();
        SafetyGuideService guideService = controller.getGuideService();

        // Cargar usuarios existentes como un HashMap
        HashMap<String, User> userHashMap = userService.findAll();

        String nombreCompleto = nombreCompletoTextField.getText();
        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            mostrarAlerta(alertType, "Nombre vacio", "No puede dejar vacío el espacio de ingresar nombre completo.");
            return;
        }

        String nombreUsuario;
        while (true) {
            nombreUsuario = nombreUsuarioTextField.getText();

            if (nombreUsuario == null || nombreUsuario.isEmpty()) {
                Alert.AlertType alertType = Alert.AlertType.ERROR;
                mostrarAlerta(alertType, "Nombre de usuario vacio", "No puede dejar vacío el espacio de ingresar nombre de usuario.");
                return;
            }

            // Verificar si el nombre de usuario ya existe
            if (userHashMap.containsKey(nombreUsuario)) {
                Alert.AlertType alertType = Alert.AlertType.ERROR;
                mostrarAlerta(alertType, "Nombre de usuario existente", "Elija otro nombre de usuario que esté disponible.");
                return;
            } else {
                break; // Nombre de usuario válido
            }
        }

        String contrasena;
        String confirmarContrasena;
        while (true) {
            contrasena = passwordTextField.getText();
            confirmarContrasena = confirmationPasswordTextField.getText();

            if (contrasena == null || confirmarContrasena == null || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                Alert.AlertType alertType = Alert.AlertType.ERROR;
                mostrarAlerta(alertType, "Contraseña vacía", "No puede dejar vacío el espacio de ingresar contraseña.");
                return;
            }

            if (!contrasena.equals(confirmarContrasena)) {
                Alert.AlertType alertType = Alert.AlertType.ERROR;
                mostrarAlerta(alertType, "Contraseñas no coinciden", "Asegúrese que ingresó la misma contraseña en los dos espacios.");
                return;
            } else {
                break; // Contraseña válida
            }
        }

        // Crear un nuevo usuario
        User nuevoUsuario = new User(nombreCompleto, nombreUsuario, contrasena);

        // Agregar el nuevo usuario al HashMap
        userService.save(nuevoUsuario);
        guideService.createArrayForUser(nuevoUsuario.getUsername());

        Alert.AlertType alertType = Alert.AlertType.INFORMATION;
        mostrarAlerta(alertType, "Nuevo usuario creado", "Bienvenido(a), tu usuario se ha creado exitosamente.");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
