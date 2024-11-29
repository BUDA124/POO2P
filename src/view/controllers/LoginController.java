package view.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {


        @FXML
        private TextField usernameTextField;

        @FXML
        private TextField passwordTextField;

        @FXML
        private Button loginButton;

        @FXML
        private Label registerButton;

        @FXML
        private Label forgotPasswordButton;



        @FXML
        public void initialize() {

        }

    @FXML
    private void handleLoginButtonAction() {
        SceneController.changeScene("/view/scenes/mainMenuWindow.fxml");
    }

    @FXML
    private void handleRegisterButtonAction() {
        SceneController.changeScene("/view/scenes/registerWindow.fxml");
    }

    @FXML
    private void handleForgotPasswordButtonAction() {
        SceneController.changeScene("/view/scenes/changePasswordWindow.fxml");
    }

    @FXML
    private void handleForgotUserButtonAction() {
        SceneController.changeScene("/view/scenes/changeUserWindow.fxml");
    }



    }


