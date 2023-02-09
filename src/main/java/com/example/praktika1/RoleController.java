package com.example.praktika1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RoleController {

    @FXML
    private Button admin_button;

    @FXML
    private Button user_button;

    @FXML
    private Button reg_button;

    @FXML
    void initialize() {

        admin_button.setOnAction(actionEvent -> {admin_button.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("AdminSignUp.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Администратор");
                stage.setScene(new Scene(root, 600, 486));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }});
        reg_button.setOnAction(actionEvent -> {reg_button.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("Register.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Регистрация");
                stage.setScene(new Scene(root, 600, 486));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }});
        user_button.setOnAction(actionEvent -> {user_button.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("sample.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Пользователь");
                stage.setScene(new Scene(root, 600, 486));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }});
    }
}
