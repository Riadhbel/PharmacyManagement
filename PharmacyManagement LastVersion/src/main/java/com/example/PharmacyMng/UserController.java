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

public class UserController implements Initializable{

    @FXML
    private TextField textIdUser;

    @FXML
    private TextField textUsername;

    @FXML
    private TextField textPassword;
    @FXML
    private TextField textType;


    @FXML
    private TableView<User> tableUser;
    @FXML
    private Button btnSaveUser;
    @FXML
    private TableColumn<Client, Integer> colIdUser;
    @FXML
    private TableColumn<Client, String> colUsername;
    @FXML
    private TableColumn<Client, String> colPassword;
    @FXML
    private TableColumn<Client, String> colTypeUser;



    int userId = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showUser();
    }


    public void showUser(){

        ObservableList<User> userList = UserDB.getUser();
        tableUser.setItems(userList);
        //colIdUser.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));
       // colFirstName.setCellValueFactory(new PropertyValueFactory<Client, String>("prenomClient"));
       //colLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("nomClient"));
        //colAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresseClient"));
        //colNumTel.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numTel"));
       // colNumAss.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numAssurance"));
       // colAge.setCellValueFactory(new PropertyValueFactory<Client, Integer>("age"));




    }


    @FXML
    public void createUser(ActionEvent actionEvent) {
        UserDB.persist(textUsername.getText(), textPassword.getText(), Integer.parseInt(textIdUser.getText()));
        showUser();
        clearFields();
    }



    @FXML
    public void editUser(ActionEvent actionEvent) {

        UserDB.updateUser(Integer.parseInt(textIdUser.getText()),
                textUsername.getText(),
                textPassword.getText(),
                Integer.parseInt(textIdUser.getText()));

        showUser();
        clearFields();
    }



    @FXML
    public void deleteUser(ActionEvent actionEvent) {

        ClientDB.deleteClient(Integer.parseInt(textIdUser.getText()));
        showUser();
        clearFields();

    }

    @FXML
    void getSelected (MouseEvent event){
        userId = tableUser.getSelectionModel().getSelectedIndex();
        if (userId <= -1){

            return;
        }
        textIdUser.setText(colIdUser.getCellData(userId).toString());
        textUsername.setText(colUsername.getCellData(userId).toString());
        textPassword.setText(colPassword.getCellData(userId).toString());
        textType.setText(colTypeUser.getCellData(userId).toString());

    }


    @FXML
    public void clearFields(ActionEvent actionEvent){
        clearFields();
    }
    public void clearFields(){
        textIdUser.setText(null);
        textUsername.setText(null);
        textPassword.setText(null);
        textIdUser.setText(null);

        userId = 0;
    }
}