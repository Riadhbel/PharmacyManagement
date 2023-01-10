package com.example.PharmacyMng;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InventaireController implements Initializable{

    @FXML
    private TextField textProduit;
    @FXML
    private TableView<Produit> tableProduit;
    @FXML
    private TableColumn<Produit, Integer> colIdProduit;
    @FXML
    private TableColumn<Produit, String> colNomProduit;
    @FXML
    private TableColumn<Produit, String> colLotProduit;
    @FXML
    private TableColumn<Produit, Integer> colPAchatProduit;
    @FXML
    private TableColumn<Produit, Integer> colPVenteProduit;
    @FXML
    private TableColumn<Produit, Integer> colQteProduit;
    @FXML
    private TableColumn<Produit, Integer> colFamilleProduit;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showProduit();
    }


    public void showProduit(){

        ObservableList<Produit> produitList = ProduitDB.getProduit();
        tableProduit.setItems(produitList);
        colIdProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("idProduit"));
        colNomProduit.setCellValueFactory(new PropertyValueFactory<Produit, String>("nomProduit"));
        colLotProduit.setCellValueFactory(new PropertyValueFactory<Produit, String>("lotProduit"));
        colPAchatProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("pAchatProduit"));
        colPVenteProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("pVenteProduit"));
        colQteProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("qteProduit"));
        colFamilleProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("familleProduit"));

        FilteredList<Produit> filteredData = new FilteredList<>(produitList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        textProduit.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(produit -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (produit.getNomProduit().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                    /*
                } else if (employee.getDepartment().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(employee.getSalary()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                    */
                }
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Produit> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableProduit.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableProduit.setItems(sortedData);
    }











}
