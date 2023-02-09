package com.example.praktika1;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.crypto.Data;
public class Controller {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField login_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Button register;
    @FXML
    private Button signup;
    @FXML
    void initialize() {
        signup.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();
            if (!loginText.equals("") && !passwordText.equals("")){
                loginuser(loginText, passwordText);
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
    private void loginuser(String loginText, String passwordText) {
        DbHandler dbHandler = new DbHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        dbHandler.getUser(user);
        ResultSet result = dbHandler.getUser(user);
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
            signup.setOnAction(actionEvent -> {signup.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("User.fxml"));
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