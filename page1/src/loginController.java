import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static java.sql.DriverManager.println;


public class loginController{
    @FXML
    private Label errorlabel;
    @FXML
    private TextField utilisateur;
    @FXML
    private PasswordField mdp;
    @FXML
    private void onlogin(ActionEvent actionEvent){
        if (mdp.getText().isEmpty() ) { errorlabel.setText("Entrer le mot de passe");
            return ;
        }
        if (utilisateur.getText().isEmpty() ) { errorlabel.setText("Entrer le nom d'utilisateur");
            return ;
        }
        int status = Dbcon.checkLogin(utilisateur.getText().trim().toLowerCase(),mdp.getText());
         switch(status){
             case 0: errorlabel.setText("Bienvenue");break;
             case -1: errorlabel.setText("Erreur");break;
             case 1: errorlabel.setText("utilisateur ou mot de passe faux");break;
    }
}
}
