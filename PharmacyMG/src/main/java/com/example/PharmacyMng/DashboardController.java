package com.example.PharmacyMng;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{
    @FXML
    Label labelTotalAchat;
    @FXML
    Label labelTotalVente;
    @FXML
    Label labelTotalQte;
    @FXML
    Label labelBenefice;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showStat();
    }
    public void showStat(){
        labelTotalAchat.setText(Integer.toString(DashboardDB.getPrixTotalAchat()));
        labelTotalVente.setText(Integer.toString(DashboardDB.getPrixTotalVente()));
        labelTotalQte.setText(Integer.toString(DashboardDB.getTotalQte()));
        labelBenefice.setText(Integer.toString(DashboardDB.getBenifice()));

    }
    Stage stage;
    Scene scene;
    @FXML
    public void GoBack(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
