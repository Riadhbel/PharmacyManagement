package com.example.PharmacyMng;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
    private TableColumn<User, Integer> colIdUser;
    @FXML
    private TableColumn<User, String> colUsername;
    @FXML
    private TableColumn<User, String> colPassword;
    @FXML
    private TableColumn<User, Integer> colTypeUser;



    int userId = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showUser();
    }


    public void showUser(){

        ObservableList<User> userList = UserDB.getUser();
        tableUser.setItems(userList);
        colIdUser.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colTypeUser.setCellValueFactory(new PropertyValueFactory<User, Integer>("typeUser"));

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

        UserDB.deleteUser(Integer.parseInt(textIdUser.getText()));
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
    Stage stage;
    Scene scene;
    @FXML
    public void goBack(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}