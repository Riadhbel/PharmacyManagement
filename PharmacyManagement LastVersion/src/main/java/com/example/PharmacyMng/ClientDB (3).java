package com.example.PharmacyMng;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDB extends Client {

    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static ObservableList<Client> getClient() {

        ObservableList<Client> clients = FXCollections.observableArrayList();

        String query = "select * from client";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int clientId = resultSet.getInt("id_client");
                String firstName = resultSet.getString("prenom_client");
                String lastName = resultSet.getString("nom_client");
                String adresseClient = resultSet.getString("adresse_client");
                int numTel = resultSet.getInt("num_tel");
                int numAssurance = resultSet.getInt("num_assurance");
                int ageClient = resultSet.getInt("age_client");
                Client client = new Client(clientId, firstName, lastName);
                client.setAdresseClient(adresseClient);
                client.setNumAssurance(numAssurance);
                client.setNumTel(numTel);
                client.setAge(ageClient);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    public static void persist(String firstName, String lastName, String adresse, int num_tel, int num_assurance, int age) {
        String query = "insert into client(nom_client, prenom_client, adresse_client, num_tel, num_assurance,age_client) values(?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, adresse);
            statement.setInt(4, num_tel);
            statement.setInt(5, num_assurance);
            statement.setInt(6, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

    }




    public static void deleteClient(int id) {
        String query = "delete from client where id_Client = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




