module com.example.demo7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;


    opens com.example.PharmacyMng to javafx.fxml;
    exports com.example.PharmacyMng;
}