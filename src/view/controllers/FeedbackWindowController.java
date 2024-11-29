package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FeedbackWindowController {

    @FXML
    private TextField asuntoTextField;

    @FXML
    private TextArea descripcionTextArea;

    @FXML
    private Button enviarButton;

    @FXML
    private void initialize() {
        // Inicialización si es necesaria
        enviarButton.setOnAction(event -> enviarFeedback());
    }

    private void enviarFeedback() {
        String asunto = asuntoTextField.getText();
        String descripcion = descripcionTextArea.getText();

        if (asunto.isEmpty() || descripcion.isEmpty()) {
            // Manejar el caso de campos vacíos, por ejemplo, mostrar un mensaje de error
            System.out.println("Por favor, completa todos los campos.");
            return;
        }

        Alert.AlertType alertType = Alert.AlertType.INFORMATION;
        mostrarAlerta(alertType, "Feedback recibido", "Tomaremos en cuenta su opinión.");

        // Limpiar los campos después de enviar
        asuntoTextField.clear();
        descripcionTextArea.clear();


    }
    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
