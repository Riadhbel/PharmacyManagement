package com.example.PharmacyMng;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AchatsDB extends Achats {

    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static ObservableList<Achats> getAchats() {

        ObservableList<Achats> achats = FXCollections.observableArrayList();

        String query = "select * from achats";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int AchatsID = resultSet.getInt("AchatsID");
                String Produit = resultSet.getString("Produit");
                String Type = resultSet.getString("LOT");
                int PrixAchats = resultSet.getInt("PrixAchats");
                int PrixVente = resultSet.getInt("PrixVente");
                String Fournisseur = resultSet.getString("Fournisseur");
                int Qte= resultSet.getInt("Qte");
                String Famille = resultSet.getString("Famille");
                Achats achat = new Achats(AchatsID, Fournisseur, Type , PrixAchats ,Produit, PrixVente,Qte, Famille );
                achats.add(achat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return achats;
    }

    public static void persist(String Produit, String Type, int PrixA, int PrixV, String Fournisseur, int Qte , String Famille) {
        String query = "insert into achats ( Fournisseur, Lot, PrixAchats, Produit, PrixVente, Qte ,Famille) values(?, ?, ?, ?, ?,? ,?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, Fournisseur);
            statement.setString(2, Type);
            statement.setInt(3, PrixA);
            statement.setString(4, Produit);
            statement.setInt(5, PrixV);
            statement.setInt(6,Qte);
            statement.setString(7,Famille);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
/*
    public static void updateClient(int id,String firstName, String lastName, String adresse,int num_tel,int num_assurance,int age){

        String query = "update client set nom_client = ?, prenom_client = ?, adresse_client = ? ,num_tel = ?,num_assurance = ?,age_client = ? where id_client = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, adresse);
            statement.setInt(4, num_tel);
            statement.setInt(5, num_assurance);
            statement.setInt(6, age);
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }*/

}




