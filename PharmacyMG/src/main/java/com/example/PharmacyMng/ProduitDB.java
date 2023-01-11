package com.example.PharmacyMng;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProduitDB extends Produit {

    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static ObservableList<Produit> getProduit() {

        ObservableList<Produit> produits = FXCollections.observableArrayList();

        String query = "select * from produit";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int produitId = resultSet.getInt("id_produit");
                String nomProduit = resultSet.getString("nom_produit");
                String lotProduit = resultSet.getString("lot_produit");
                int pAchatProduit = resultSet.getInt("pachat_produit");
                int pVenteProduit = resultSet.getInt("pvente_produit");
                int qteProduit = resultSet.getInt("qte_produit");
                String familleProduit = resultSet.getString("famille_produit");
                Produit produit = new Produit(produitId,nomProduit,lotProduit,pAchatProduit,pVenteProduit,qteProduit,familleProduit);
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return produits;
    }
    public static ObservableList<Produit> getProduitSearch(String produitToSearch) {

        ObservableList<Produit> produits = FXCollections.observableArrayList();

        String query = "select * from produit where nom_produit =?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, produitToSearch);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int produitId = resultSet.getInt("id_produit");
                String nomProduit = resultSet.getString("nom_produit");
                String lotProduit = resultSet.getString("lot_produit");
                int pAchatProduit = resultSet.getInt("pachat_produit");
                int pVenteProduit = resultSet.getInt("pvente_produit");
                int qteProduit = resultSet.getInt("qte_produit");
                String familleProduit = resultSet.getString("famille_produit");
                Produit produit = new Produit(produitId,nomProduit,lotProduit,pAchatProduit,pVenteProduit,qteProduit,familleProduit);
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return produits;
    }









}




