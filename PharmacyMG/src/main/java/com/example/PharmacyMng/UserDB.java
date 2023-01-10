package com.example.PharmacyMng;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDB extends User {
    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;



    public static ObservableList<User> getUsers(){
        ObservableList<User> users = FXCollections.observableArrayList();

        String query = "select * from user";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int userId = resultSet.getInt("userId");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int typeUser = resultSet.getInt("typeUser");
                User user = new User(userId,username, password, typeUser);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
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
