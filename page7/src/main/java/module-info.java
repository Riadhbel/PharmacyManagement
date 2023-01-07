module com.example.page7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.page7 to javafx.fxml;
    exports com.example.page7;
}