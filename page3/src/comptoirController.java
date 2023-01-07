import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static java.sql.DriverManager.println;


public class comptoirController {
    @FXML
    private Label nomclient;

    @FXML
    private Label ancsolde;

    @FXML
    private Button f8;

    @FXML
    private Button f9;

    @FXML
    private TextField codebarre;

    @FXML
    private TextField produit;

    @FXML
    private TextField prix;

    @FXML
    private TextField quant;

    @FXML
    private Button stock;

    @FXML
    private Button valider;

    @FXML
    private Button supp;

    @FXML
    private Button annuler;

    @FXML
    private Label per;

    @FXML
    private Label lot;

    @FXML
    private Label nbrproduit;

    @FXML
    private Label versement;

    @FXML
    private Label totalsansremise;

    @FXML
    private Label prixgreen;

    @FXML
    private TextField remise;

    @FXML
    private Button ouvrirtiroir;

    @FXML
    private Button reinitialiser;

    @FXML
    private Button validercomp;

    @FXML
    private RadioButton cash;

    @FXML
    private RadioButton credit;

    @FXML
    private Label heure;

    @FXML
    private Label client;

    @FXML
    private Label total;

    @FXML
    private Label verse;

    @FXML
    private Label rendu;

    @FXML
    private TableView<tableau> tableaucomp;

    @FXML
    private TableColumn<tableau,String> produittab;

    @FXML
    private TableColumn<tableau,Double> prixtab;

    @FXML
    private TableColumn<tableau,Integer> quanttab;

    @FXML
    private TableColumn<tableau,Integer> lottab;

    @FXML
    private TableColumn<tableau,Integer> peremptab;

    @FXML
    private TableColumn<tableau,Double> totaltab;

    @FXML
    private TableColumn<tableau,Integer> stocktab;


}
