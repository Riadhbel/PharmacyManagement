package com.example.PharmacyMng;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AchatsController implements Initializable{

    @FXML
    private TextField textFournisseur;

    @FXML
    private TextField textType;
    @FXML
    private TextField textprixA;

    @FXML
    private TextField textProduit;
    @FXML
    private TextField textprixV;
    @FXML
    private TextField textQte;
    @FXML
    private TextField textFamille;
    @FXML TextField textidachats ;


    @FXML
    private TableView<Achats> tableAchats;


    @FXML
    private TableColumn<Achats, Integer> colAchatsID;
    @FXML
    private TableColumn<Achats, String> colFournisseur;
    @FXML
    private TableColumn<Achats, String> colType;
    @FXML
    private TableColumn<Achats, Integer> colPrixA;
    @FXML
    private TableColumn<Achats, String> colProduit;

    @FXML
    private TableColumn<Achats, Integer> colPrixV;
    @FXML
    private TableColumn <Achats,Integer> colQte;
    @FXML
    private TableColumn <Achats ,String> colFamille;


    int AchatsID = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAchats();
    }


    public void showAchats(){

        ObservableList<Achats> achatslist = AchatsDB.getAchats();
        tableAchats.setItems(achatslist);
        colAchatsID.setCellValueFactory(new PropertyValueFactory<Achats, Integer>("AchatsID"));
        colProduit.setCellValueFactory(new PropertyValueFactory<Achats, String>("Produit"));
        colType.setCellValueFactory(new PropertyValueFactory<Achats, String>("User"));
        colPrixA.setCellValueFactory(new PropertyValueFactory<Achats, Integer>("PrixAchats"));
        colPrixV.setCellValueFactory(new PropertyValueFactory<Achats, Integer>("PrixVente"));
        colFournisseur.setCellValueFactory(new PropertyValueFactory<Achats, String>("Fournisseur"));
        colQte.setCellValueFactory(new PropertyValueFactory<Achats, Integer>("Qte"));
        colFamille.setCellValueFactory(new PropertyValueFactory<Achats, String>("Famille"));

    }


    @FXML
    public void creatAchats(ActionEvent actionEvent) {
        AchatsDB.persist(
                textProduit.getText(),
                textType.getText(),
                Integer.parseInt(textprixA.getText()),
                Integer.parseInt(textprixV.getText()),
                textFournisseur.getText(),
                Integer.parseInt(textQte.getText()),
                textFamille.getText()
        );
        showAchats();
        clearFields();
    }



 /*   @FXML
    public void editClient(ActionEvent actionEvent) {

        ClientDB.updateClient(Integer.parseInt(textIdClient.getText()),
                textFirstName.getText(),
                textLastName.getText(),
                textAdresse.getText(),
                Integer.parseInt(textNumTel.getText()),
                Integer.parseInt(textAss.getText()),
                Integer.parseInt(textAge.getText()));
        showClient();
        clearFields();
    }*/

    @FXML
    void getSelected (MouseEvent event){
        AchatsID = tableAchats.getSelectionModel().getSelectedIndex();
        if (AchatsID <= -1){

            return;
        }
        textidachats.setText(colAchatsID.getCellData(AchatsID).toString());
        textFournisseur.setText(colFournisseur.getCellData(AchatsID).toString());
        textType.setText(colType.getCellData(AchatsID).toString());
        textprixA.setText(colPrixA.getCellData(AchatsID).toString());
        textProduit.setText(colProduit.getCellData(AchatsID).toString());
        textprixV.setText(colPrixV.getCellData(AchatsID).toString());
        textQte.setText(colQte.getCellData(AchatsID).toString());
        textFamille.setText(colFamille.getCellData(AchatsID).toString());

    }


    @FXML
    public void clearFields(ActionEvent actionEvent){
        clearFields();
    }
    public void clearFields(){
        textidachats.setText(null);
        textprixA.setText(null);
        textprixV.setText(null);
        textProduit.setText(null);
        textFournisseur.setText(null);
        textType.setText(null);
        textFamille.setText(null);
        textQte.setText(null);
        AchatsID = 0;
    }
}
