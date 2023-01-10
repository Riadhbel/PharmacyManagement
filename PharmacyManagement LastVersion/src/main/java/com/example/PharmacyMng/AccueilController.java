package com.example.PharmacyMng;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;



public class AccueilController {
    Stage stage;
    Scene scene;
     Parent root = null;
    @FXML
    private void goToComptoire(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("comptoire.fxml"));
            root = (Parent) loader.load();
            AccueilController accueilController = loader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }
        catch (IOException e){

        }
        stage.setScene(new Scene(root));
    }
}
