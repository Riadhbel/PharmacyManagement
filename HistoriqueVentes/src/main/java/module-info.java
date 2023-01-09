module com.example.historiqueventes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.historiqueventes to javafx.fxml;
    exports com.example.historiqueventes;
}