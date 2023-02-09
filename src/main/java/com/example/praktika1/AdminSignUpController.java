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
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminSignUpController {
    @FXML
    private TextField login_field_admin;
    @FXML
    private PasswordField password_field_admin;
    @FXML
    private Button register;
    @FXML
    private Button signUpAdmin;
    @FXML
    void initialize() {
        signUpAdmin.setOnAction(event -> {
            String loginText = login_field_admin.getText().trim();
            String passwordText = password_field_admin.getText().trim();
            if (!loginText.equals("") && !passwordText.equals("")){
                loginAdmin(loginText, passwordText);
            }
            else
                System.out.println("ERROR");
        });
        register.setOnAction(event -> {
            register.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Register.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
    private void loginAdmin(String loginText, String passwordText) {
        DbHandler dbHandler = new DbHandler();
        Admin admin = new Admin();
        admin.setAdminName(loginText);
        admin.setAdminPassword(passwordText);
        dbHandler.getAdmin(admin);
        ResultSet result = dbHandler.getAdmin(admin);
        int counter = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1){
            signUpAdmin.setOnAction(actionEvent -> {signUpAdmin.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("Admin.fxml"));
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
        }
    }
}
