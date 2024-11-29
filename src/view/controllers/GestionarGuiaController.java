package view.controllers;

import control.SystemController;
import javafx.fxml.FXML;
import models.general.SafetyGuide;
import models.services.SafetyGuideService;
import models.utils.PDFGenerator;

import java.io.IOException;

public class GestionarGuiaController {

    private SafetyGuide selectedGuide;

    @FXML
    private void deleteButtonAction() {
        SystemController controller = SystemController.getInstance();
        SafetyGuideService guideService = controller.getGuideService();

        guideService.delete(controller.getCurrentUser().getUsername(), controller.getCurrentSafetyGuide());
        SceneController.changeScene("/view/scenes/accederGuiasWindow.fxml");
    }

    @FXML
    private void editarButtonAction() {
        SystemController controller = SystemController.getInstance();
        SafetyGuideService guideService = controller.getGuideService();
        guideService.delete(controller.getCurrentUser().getUsername(), controller.getCurrentSafetyGuide());
        SceneController.changeScene("/view/scenes/guideMenuWindow.fxml");
    }

    @FXML
    private void descargarButtonAction() throws IOException {
        SystemController controller = SystemController.getInstance();
        PDFGenerator pdfGenerator = controller.getPdfGenerator();
        pdfGenerator.generatePDF(controller.getCurrentUser(), controller.getCurrentSafetyGuide());
        SceneController.changeScene("/view/scenes/accederGuiasWindow.fxml");
    }

    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
    }
}
