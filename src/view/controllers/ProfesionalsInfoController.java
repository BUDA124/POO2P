package view.controllers;

import javafx.fxml.FXML;

public class ProfesionalsInfoController {



    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/informationMenuWindow.fxml");
    }
}
