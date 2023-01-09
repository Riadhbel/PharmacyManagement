module com.example.acceuil {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.acceuil to javafx.fxml;
    exports com.example.acceuil;
}