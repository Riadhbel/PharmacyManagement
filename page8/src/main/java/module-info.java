module com.example.page8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.page8 to javafx.fxml;
    exports com.example.page8;
}