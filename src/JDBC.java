import java.sql.*;

public class JDBC {
    private String username = "";
    private String password = "";
    private static final String URL = "jdbc:mysql://localhost/login?serverTimezone=UTC";

    public JDBC(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Connection openConnection() throws SQLException {
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public Boolean Insert(String table, String columns[], String values[]){
        return null;
    }

    public void closeConnection(Connection con) throws SQLException {
        con.close();
    }
    
}
