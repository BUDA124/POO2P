package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ToolsInfoController {

    @FXML
    private ImageView toolImage;

    @FXML
    private Button nextButton;

    private Image[] images;
    private int currentIndex = 0;

    @FXML
    public void initialize() {
        images = new Image[]{
                new Image(getClass().getResourceAsStream("view/scenes/images/tools1.PNG")),
                new Image(getClass().getResourceAsStream("view/scenes/images/tools2.PNG")),
                new Image(getClass().getResourceAsStream("view/scenes/images/tools3.PNG")),
                new Image(getClass().getResourceAsStream("view/scenes/images/tools4.PNG")),
                new Image(getClass().getResourceAsStream("view/scenes/images/tools5.PNG")),
                new Image(getClass().getResourceAsStream("view/scenes/images/tools6.PNG")),
                new Image(getClass().getResourceAsStream("view/scenes/images/tools7.PNG"))
        };

        toolImage.setImage(images[currentIndex]);

        nextButton.setOnAction(event -> rotateImage());
    }

    public void rotateImage() {
        currentIndex = (currentIndex + 1) % images.length;
        toolImage.setImage(images[currentIndex]);
    }

    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/informationMenuWindow.fxml");
    }

}
