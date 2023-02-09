package com.example.praktika1;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class AddController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    public TextField ActorFilm;
    @FXML
    public TextField FromFilm;
    @FXML
    public TextField GenreFilm;
    @FXML
    public TextField NameFilm;
    @FXML
    public TextField ProducerFilm;
    @FXML
    public TextField RatingFilm;
    @FXML
    public TextField YearFilm;
    @FXML
    private Button mainButton;
    @FXML
    private Button AddButton;
    @FXML
    private Button content;
    @FXML
    void initialize() {

        content.setOnAction(actionEvent -> {content.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("content.fxml"));
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

        DbHandler dbhandler = new DbHandler();
        AddButton.setOnAction(actionEvent -> {AddButton.getScene().getWindow().hide();
            try {
                dbhandler.getAdd(ActorFilm.getText(), FromFilm.getText(), GenreFilm.getText(), NameFilm.getText(),
                        ProducerFilm.getText(), RatingFilm.getText(), YearFilm.getText());
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("successAdd.fxml"));
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
        mainButton.setOnAction(actionEvent -> {mainButton.getScene().getWindow().hide();
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