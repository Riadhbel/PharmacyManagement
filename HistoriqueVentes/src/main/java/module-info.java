module com.example.historiqueventes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.historiqueventes to javafx.fxml;
    exports com.example.historiqueventes;
}