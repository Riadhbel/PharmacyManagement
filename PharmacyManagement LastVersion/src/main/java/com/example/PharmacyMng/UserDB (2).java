package com.example.PharmacyMng;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDB extends User {
    public static ObservableList<User> getUser() {

        ObservableList<User> users = FXCollections.observableArrayList();

        String query = "select * from user";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int typeUser = resultSet.getInt("typeUser");
                User user = new User(idUser, username, password,typeUser);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static void persist(String username, String password,  int typeUser) {
        String query = "insert into user(username, password, typeUser) values(?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, typeUser);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateUser(int id,String username, String password, int typeUser){

        String query = "update user set username = ?, password = ?, typeUser= ?  where id_client = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, typeUser);
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void deleteUser(int id) {
        String query = "delete from user where idUser = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int checklogin(String username,String password){
        if(connection == null) return -1;
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return 0;
            }
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return 1;
    }

}
