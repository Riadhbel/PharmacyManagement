import java.sql.*;

public class Dbcon {
    private static final String UTILISATEUR = "root";
    private static final String MDP = "";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    public static final String DB_NAME = "userdata";

    public static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, UTILISATEUR, MDP);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static int checkLogin (String utilisateur , String mdp){
        Connection con = Dbcon.con;
        if (con == null) return -1;
        String sql ="SELECT * FROM users WHERE utilisateur=? AND mdp=?";
        try{
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, utilisateur);
            prest.setString(2, mdp);

            ResultSet rs = prest.executeQuery();
            while (rs.next()) { return 0;}




    } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
}
}
