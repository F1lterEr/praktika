package com.example.praktika1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private Button mainButton;
    @FXML
    private TextField login_reg;
    @FXML
    private Button register_button;
    @FXML
    private PasswordField password_reg;
    @FXML
    void initialize() {
        DbHandler dbhandler = new DbHandler();
        register_button.setOnAction(actionEvent -> {register_button.getScene().getWindow().hide();
            try {
                dbhandler.signUpUser(login_reg.getText(), password_reg.getText());
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("success.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Регистрация успешна");
                stage.setScene(new Scene(root, 600, 486));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }});
        mainButton.setOnAction(actionEvent -> {mainButton.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("Role.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Выбор роли");
                stage.setScene(new Scene(root, 600, 486));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }});
    }
}
