package com.example.PharmacyMng;
import java.sql.*;

public class DatabaseConnection {
    private static final String USERNAME = "root";
    private static final String databasePassword = "";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String databaseName = "pharmacie";
    public static Connection con;
        static {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + databaseName,USERNAME,databasePassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static int checklogin(String username,String password){
            Connection con = DatabaseConnection.con;
            if(con == null) return -1;
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            try{
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1,username);
                prest.setString(2,password);
                ResultSet rs = prest.executeQuery();
                while(rs.next()){
                    return 0;
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
                return 1;
        }
}
