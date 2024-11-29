package view.controllers;

import javafx.fxml.FXML;

public class RisksInfoController {




    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/informationMenuWindow.fxml");
    }
}
