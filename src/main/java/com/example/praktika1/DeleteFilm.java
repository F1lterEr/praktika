package com.example.praktika1;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class DeleteFilm {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button DelButton;
    @FXML
    private TextField DelText;
    @FXML
    private TableColumn<filmsTable, String> filmsActor;
    @FXML
    private TableColumn<filmsTable, String> filmsFrom;
    @FXML
    private TableColumn<filmsTable, String> filmsGenre;
    @FXML
    private TableColumn<filmsTable, String> filmsID;
    @FXML
    private TableColumn<filmsTable, String> filmsName;
    @FXML
    private TableColumn<filmsTable, String> filmsProducer;
    @FXML
    private TableColumn<filmsTable, String> filmsRating;
    @FXML
    private TableView<filmsTable> filmsTable;
    @FXML
    private TableColumn<filmsTable, String> filmsYear;
    ObservableList<filmsTable> filmsTablesData = FXCollections.observableArrayList();
    @FXML
    void initialize() throws SQLException {
        DelButton.setOnAction(event -> {
            String delFilm = DelText.getText().trim();
            if (!delFilm.equals("")) {
                try {
                    deleteUse(delFilm);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("ERROR");
        });
        initF();
        filmsID.setCellValueFactory(new PropertyValueFactory<>("filmID"));
        filmsName.setCellValueFactory(new PropertyValueFactory<>("filmName"));
        filmsGenre.setCellValueFactory(new PropertyValueFactory<>("filmGenre"));
        filmsYear.setCellValueFactory(new PropertyValueFactory<>("filmYear"));
        filmsRating.setCellValueFactory(new PropertyValueFactory<>("filmRating"));
        filmsActor.setCellValueFactory(new PropertyValueFactory<>("filmActor"));
        filmsProducer.setCellValueFactory(new PropertyValueFactory<>("filmProducer"));
        filmsFrom.setCellValueFactory(new PropertyValueFactory<>("filmFrom"));
        filmsTable.setItems(filmsTablesData);
    }
    private void initF() throws SQLException {
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.table();
        while (resultSet.next()) {
            filmsTablesData.add(new filmsTable(resultSet.getString("filmID"),
                    resultSet.getString("filmName"), resultSet.getString("filmGenre"),
                    resultSet.getString("filmYear"), resultSet.getString("filmRating"),
                    resultSet.getString("filmActor"), resultSet.getString("filmProducer"),
                    resultSet.getString("filmFrom")));
        }
    }
    private void deleteUse(String DelText) throws SQLException {
        DbHandler dbHandler = new DbHandler();
        com.example.praktika1.Delete delete = new Delete();
        delete.setIdFilm(DelText);
        ResultSet resultSet = dbHandler.getDel(delete);
        while (resultSet.next()) {
            filmsTablesData.add(new filmsTable(resultSet.getString("filmID"),
                    resultSet.getString("filmName"), resultSet.getString("filmGenre"),
                    resultSet.getString("filmYear"), resultSet.getString("filmRating"),
                    resultSet.getString("filmActor"), resultSet.getString("filmProducer"),
                    resultSet.getString("filmFrom")));
        }
        filmsTable.setItems(filmsTablesData);
    }
}