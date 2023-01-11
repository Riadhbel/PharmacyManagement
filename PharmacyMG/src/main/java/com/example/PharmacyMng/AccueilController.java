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
    public void goToComptoire(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("comptoire.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToUser(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToAchats(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Achats.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToStock(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Inventaire.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void GoBack(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToDashBoard(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
