module com.example.praktika1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires java.xml.crypto;
    requires mysql.connector.j;


    opens com.example.praktika1 to javafx.fxml;
    exports com.example.praktika1;
}