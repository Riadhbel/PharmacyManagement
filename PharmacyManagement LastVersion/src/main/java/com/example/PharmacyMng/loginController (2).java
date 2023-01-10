package com.example.PharmacyMng;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class loginController {
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
   @FXML
    private void onLogin(ActionEvent event){
       if(usernameTextField.getText().matches("[a-zA-Z0-9_{4,}]")){
           return;
       }
       if(passwordPasswordField.getText().isEmpty()){
           return;
       }
       int status = UserDB.checklogin(usernameTextField.getText().trim().toLowerCase(),passwordPasswordField.getText());
       switch(status){
           case 0 :{
               Stage stage = (Stage) usernameTextField.getScene().getWindow();
               //AccueilController scene2Controller = loader.getController();
               Parent root = null;
               try {
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
                   root = loader.load();
                   AccueilController accueilController = loader.getController();
                   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
               } catch (IOException e) {

               }
               stage.setScene(new Scene(root));
           }break;
           case -1:{
               loginMessageLabel.setText("Connection to data base failed!");
           }break;
           case 1:{
               loginMessageLabel.setText("username or password wrong");
           }break;
       }
   }

}