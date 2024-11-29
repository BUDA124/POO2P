package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GuardarGuiaController {

    @FXML
    private Button leerButton;

    @FXML
    private Button descargarButton; // Asegúrate de que sea un Button en el FXML

    @FXML
    private Button chequearButton;

    @FXML
    private Button saveButton;

    @FXML
    private void initialize() {
        // Asignar manejadores de eventos a los botones
        leerButton.setOnAction(event -> leerRiesgosDetectados());
        chequearButton.setOnAction(event -> chequearPrevencionesDefinidas());
        saveButton.setOnAction(event -> guardarGuia());
        descargarButton.setOnAction(event -> descargarReportePDF());
    }

    /**
     * Método para manejar la acción de leer riesgos detectados.
     */
    private void leerRiesgosDetectados() {
        // Lógica para leer y mostrar los riesgos detectados y sus prevenciones
        // Por ejemplo, abrir una nueva ventana o mostrar en una sección de la UI
        mostrarAlerta(AlertType.INFORMATION, "Leer Riesgos", "Se han leído los riesgos detectados junto a sus prevenciones.");
        // Implementa la lógica real según tus necesidades
    }

    /**
     * Método para manejar la acción de chequear prevenciones definidas.
     */
    private void chequearPrevencionesDefinidas() {
        // Lógica para chequear las prevenciones definidas en la guía de seguridad
        mostrarAlerta(AlertType.INFORMATION, "Chequear Prevenciones", "Se han chequeado las prevenciones definidas en tu guía de seguridad.");
        // Implementa la lógica real según tus necesidades
    }

    /**
     * Método para manejar la acción de guardar la guía.
     */
    private void guardarGuia() {
        // Lógica para guardar la guía de seguridad
        mostrarAlerta(AlertType.INFORMATION, "Guardar Guía", "La guía de seguridad ha sido guardada exitosamente.");
        // Implementa la lógica real según tus necesidades, como guardar en una base de datos o en un archivo
    }

    /**
     * Método para manejar la acción de descargar el reporte PDF.
     */
    private void descargarReportePDF() {
        // Lógica para generar y descargar el reporte PDF
        mostrarAlerta(AlertType.INFORMATION, "Descargar Reporte", "El reporte PDF ha sido descargado exitosamente.");
        // Implementa la lógica real según tus necesidades, como generar el PDF y guardarlo en una ubicación específica
    }

    /**
     * Método auxiliar para mostrar alertas.
     *
     * @param tipo    Tipo de alerta (ERROR, INFORMATION, etc.)
     * @param titulo  Título de la alerta
     * @param mensaje Mensaje de la alerta
     */
    private void mostrarAlerta(AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
