package view.controllers;

import javafx.fxml.FXML;

public class ConstructionWorkInfoController {

    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/informationMenuWindow.fxml");
    }
}
