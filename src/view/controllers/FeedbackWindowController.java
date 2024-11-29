package view.controllers;

import javafx.fxml.FXML;
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

        // Aquí puedes agregar la lógica para procesar la retroalimentación,
        // como guardarla en una base de datos o enviarla por correo electrónico.
        System.out.println("Asunto: " + asunto);
        System.out.println("Descripción: " + descripcion);

        // Limpiar los campos después de enviar
        asuntoTextField.clear();
        descripcionTextArea.clear();

        // Opcional: Mostrar una confirmación al usuario
        System.out.println("¡Gracias por tu sugerencia!");
    }
}
