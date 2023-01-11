package com.example.PharmacyMng;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ComptoireController {
    Stage stage;
    Scene scene;
    private Parent  root;
    @FXML
    public void openClients(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionClient.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void goBack(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openStock(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Inventaire.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
