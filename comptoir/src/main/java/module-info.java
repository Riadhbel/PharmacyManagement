module com.example.comptoir {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comptoir to javafx.fxml;
    exports com.example.comptoir;
}