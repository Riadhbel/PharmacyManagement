module com.example.page6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.page6 to javafx.fxml;
    exports com.example.page6;
}