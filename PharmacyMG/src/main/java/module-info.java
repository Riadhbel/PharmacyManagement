module com.example.pharmacymg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.PharmacyMng to javafx.fxml;
    exports com.example.PharmacyMng;
}