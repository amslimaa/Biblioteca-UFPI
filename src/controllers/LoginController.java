package controllers;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {


    public TextField textFieldLogin = null;
    public PasswordField pwInput = null;
    public void onLoginClick(MouseEvent mouseEvent) {
        System.out.println(textFieldLogin.getText() + " " + pwInput.getText());
    }

    public void onCadClick(MouseEvent mouseEvent) {
        System.out.println("Cadastrar");

    }
}
