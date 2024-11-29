package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class InformationMenuController {

    @FXML
    private Label headerLabel;

    @FXML
    private Button herramientasButton;

    @FXML
    private Button profesionalesButton;

    @FXML
    private Button obrasButton;

    @FXML
    private Button riesgosButton;

    // Método de inicialización
    @FXML
    public void initialize() {
        // Supongamos que tienes una clase Usuario que maneja la sesión
        // Aquí deberías obtener el nombre del usuario actual y actualizar el Label
        String nombreUsuario = obtenerNombreUsuarioActual();
        headerLabel.setText("¿Sobre qué aspecto te gustaría obtener más información, " + nombreUsuario + "?");
    }

    // Método para obtener el nombre del usuario actual
    // Este método debe ser implementado según cómo manejes la sesión de usuario
    private String obtenerNombreUsuarioActual() {
        // Por ejemplo, podría ser obtenido de una clase de sesión
        // return Session.getCurrentUser().getNombre();
        // Para este ejemplo, devolveremos un nombre fijo
        return "Juan Pérez";
    }

    // Método para manejar el evento de clic en el botón "Herramientas"
    @FXML
    private void handleHerramientasButtonAction() {
        System.out.println("Botón 'Herramientas' presionado.");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/controllers/HerramientasWindow.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) herramientasButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Información sobre Herramientas");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "No se pudo cargar la ventana de Herramientas.");
        }
    }

    // Método para manejar el evento de clic en el botón "Profesionales"
    @FXML
    private void handleProfesionalesButtonAction() {
        System.out.println("Botón 'Profesionales' presionado.");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/controllers/ProfesionalesWindow.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) profesionalesButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Información sobre Profesionales");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "No se pudo cargar la ventana de Profesionales.");
        }
    }

    // Método para manejar el evento de clic en el botón "Tipos de Obras"
    @FXML
    private void handleObrasButtonAction() {
        System.out.println("Botón 'Tipos de Obras' presionado.");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/controllers/TiposObrasWindow.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) obrasButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Información sobre Tipos de Obras");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "No se pudo cargar la ventana de Tipos de Obras.");
        }
    }

    // Método para manejar el evento de clic en el botón "Riesgos Comunes"
    @FXML
    private void handleRiesgosButtonAction() {
        System.out.println("Botón 'Riesgos Comunes' presionado.");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/controllers/RiesgosComunesWindow.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) riesgosButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Información sobre Riesgos Comunes");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "No se pudo cargar la ventana de Riesgos Comunes.");
        }
    }

    // Método auxiliar para mostrar alertas
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
