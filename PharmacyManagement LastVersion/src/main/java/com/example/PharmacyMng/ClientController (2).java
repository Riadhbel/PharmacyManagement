package com.example.PharmacyMng;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable{

    @FXML
    private TextField textFirstName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textAdresse;
    @FXML
    private TextField textAge;
    @FXML
    private TextField textNumTel;
    @FXML
    private TextField textAss;
    @FXML TextField textIdClient;

    @FXML
    private TableView<Client> tableClient;
    @FXML
    private Button btnSave;
    @FXML
    private TableColumn<Client, Integer> colIdClient;
    @FXML
    private TableColumn<Client, String> colFirstName;
    @FXML
    private TableColumn<Client, String> colLastName;
    @FXML
    private TableColumn<Client, String> colAdresse;
    @FXML
    private TableColumn<Client, Integer> colNumTel;
    @FXML
    private TableColumn<Client, Integer> colNumAss;
    @FXML
    private TableColumn<Client, Integer> colAge;


    int clientId = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showClient();
    }


    public void showClient(){

        ObservableList<Client> clientList = ClientDB.getClient();
        tableClient.setItems(clientList);
        colIdClient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idClient"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<Client, String>("prenomClient"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("nomClient"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresseClient"));
        colNumTel.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numTel"));
        colNumAss.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numAssurance"));
        colAge.setCellValueFactory(new PropertyValueFactory<Client, Integer>("age"));



    }


    @FXML
    public void createClient(ActionEvent actionEvent) {
        ClientDB.persist(textFirstName.getText(), textLastName.getText(), textAdresse.getText(),Integer.parseInt(textNumTel.getText()),Integer.parseInt(textAss.getText()),Integer.parseInt(textAge.getText()));
        showClient();
        clearFields();
    }



    @FXML
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
    }



    @FXML
    public void deleteClient(ActionEvent actionEvent) {

            ClientDB.deleteClient(Integer.parseInt(textIdClient.getText()));
            showClient();
            clearFields();

    }

    @FXML
    void getSelected (MouseEvent event){
        clientId = tableClient.getSelectionModel().getSelectedIndex();
        if (clientId <= -1){

            return;
        }
        textIdClient.setText(colIdClient.getCellData(clientId).toString());
        textFirstName.setText(colFirstName.getCellData(clientId).toString());
        textLastName.setText(colLastName.getCellData(clientId).toString());
        textAdresse.setText(colAdresse.getCellData(clientId).toString());
        textNumTel.setText(colNumTel.getCellData(clientId).toString());
        textAss.setText(colNumAss.getCellData(clientId).toString());
        textAge.setText(colAge.getCellData(clientId).toString());

    }


    @FXML
    public void clearFields(ActionEvent actionEvent){
        clearFields();
    }
    public void clearFields(){
        textIdClient.setText(null);
        textFirstName.setText(null);
        textLastName.setText(null);
        textAdresse.setText(null);
        textAss.setText(null);
        textAge.setText(null);
        textNumTel.setText(null);
        clientId = 0;
    }
}
