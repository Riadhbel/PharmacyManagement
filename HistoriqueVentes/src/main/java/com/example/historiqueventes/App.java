package com.example.historiqueventes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("employees.fmxl"));
        //Parent parent = FXMLLoader.load(getClass().getResource("employees.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Employees");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
