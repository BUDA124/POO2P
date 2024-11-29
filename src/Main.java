import javafx.application.Application;
import javafx.stage.Stage;
import view.controllers.SceneController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneController.setStage(primaryStage);
        SceneController.changeScene("/view/scenes/loginWindow.fxml");
    }
    public static void main(String[] args) {
        launch(args);
    }
}