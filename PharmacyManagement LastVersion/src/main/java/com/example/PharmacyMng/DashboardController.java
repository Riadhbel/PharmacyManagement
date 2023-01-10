package com.example.PharmacyMng;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
}
