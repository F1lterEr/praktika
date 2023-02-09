package com.example.praktika1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableColumn<adminTable, String> User_ID;
    @FXML
    private TableColumn<adminTable, String> User_login;
    @FXML
    private TableColumn<adminTable, String> User_password;
    @FXML
    private TableView<adminTable> adminTable;
    @FXML
    private Button add_Button;
    ObservableList<adminTable> adminTablesData = FXCollections.observableArrayList();
    public void initialize() throws SQLException {
        add_Button.setOnAction(actionEvent -> {add_Button.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoleController.class.getResource("Add.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Добавление фильма");
                stage.setScene(new Scene(root, 700, 400));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }});
        initAdmin();
        User_ID.setCellValueFactory(new PropertyValueFactory<>("idUsers"));
        User_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        User_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        adminTable.setItems(adminTablesData);
    }
    private void initAdmin() throws SQLException {
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.admin();
        while (resultSet.next()) {
            adminTablesData.add(new adminTable(resultSet.getString("idUsers"),
                    resultSet.getString("login"), resultSet.getString("password")));
        }
    }
}
