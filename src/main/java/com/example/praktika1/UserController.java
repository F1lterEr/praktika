package com.example.praktika1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserController {
    @FXML
    private TableView<filmsTable> filmsTable;
    @FXML
    private TableColumn<filmsTable, String> filmsID;
    @FXML
    private TableColumn<filmsTable, String> filmsName;
    @FXML
    private TableColumn<filmsTable, String> filmsGenre;
    @FXML
    private TableColumn<filmsTable, String> filmsYear;
    @FXML
    private TableColumn<filmsTable, String> filmsRating;
    @FXML
    private TableColumn<filmsTable, String> filmsActor;
    @FXML
    private TableColumn<filmsTable, String> filmsProducer;
    @FXML
    private TableColumn<filmsTable, String> filmsFrom;
    @FXML
    private Button filterButton;
    @FXML
    private TextField filterText;
    ObservableList<filmsTable> filmsTablesData = FXCollections.observableArrayList();
    public void initialize() throws SQLException {
        filterButton.setOnAction(event -> {
            String filtertext = filterText.getText().trim();
            if (!filtertext.equals("")) {
                try {
                    filterUse(filtertext);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("ERROR");
        });
        init();
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
    private void init() throws SQLException {
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
    private void filterUse(String filterText) throws SQLException {
        DbHandler dbHandler = new DbHandler();
        com.example.praktika1.Filter filter = new Filter();
        filter.setFilmGenre(filterText);
        ResultSet resultSet = dbHandler.getFilter(filter);
        filmsTablesData.clear();
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