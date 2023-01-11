package com.example.PharmacyMng;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DashboardDB {

    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static int getPrixTotalAchat() {

        int prixTotalAchat=0;
        String query = "SELECT SUM(pachat_produit * qte_produit) AS PrixAchatTotal FROM produit";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                prixTotalAchat = resultSet.getInt("PrixAchatTotal");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prixTotalAchat;
    }
    public static int getPrixTotalVente() {

        int prixTotalVente=0;
        String query = "SELECT SUM(pvente_produit * qte_produit) AS PrixVenteTotal FROM produit";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                prixTotalVente = resultSet.getInt("PrixVenteTotal");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prixTotalVente;
    }
    public static int getTotalQte() {

        int qte=0;
        String query = "SELECT SUM(qte_produit) AS qteTotal FROM produit";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
               qte = resultSet.getInt("qteTotal");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return qte;
    }
    public static int getBenifice() {

        int benefice=0;
        String query = "SELECT SUM(pvente_produit * qte_produit) - SUM(pachat_produit * qte_produit) AS gain FROM produit";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                benefice = resultSet.getInt("gain");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return benefice;
    }

}
