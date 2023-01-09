module com.example.historiqueachats {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.historiqueachats to javafx.fxml;
    exports com.example.historiqueachats;
}