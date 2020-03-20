import java.sql.*;

public class JDBC {
    private String username = "";
    private String password = "";
    private Connection con = null;
    private Statement stmt = null;
    private static final String URL = "jdbc:mysql://localhost/school?serverTimezone=UTC";

    public JDBC(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;
        openConnection();
        this.stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    public Connection openConnection() throws SQLException {
            this.con = DriverManager.getConnection(URL, username, password);
        return this.con;
    }

    public Connection getConnection() {
        return this.con;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

    public ResultSet select(String table, String column) throws SQLException {
        return stmt.executeQuery("SELECT " + column + " FROM " + table + ";");
    }

    public ResultSet select(String table, String column, String where) throws SQLException {
        return stmt.executeQuery("SELECT " + column + " FROM " + table + " WHERE " + where + ";");
    }

    public boolean insert(String table, String columns[], String values[]) throws SQLException {
        String queryColumns = "(";

        for (int i = 0; i < columns.length - 1; i++) {
            queryColumns += columns[i] + ", ";
        }
        queryColumns += columns[columns.length - 1] + ")";

        String queryValues = "(";

        for (int i = 0; i < values.length - 1; i++) {
            if(Integer.getInteger(values[i]) == null) {
                values[i] = "\"" + values[i] + "\"";
            }
            queryValues += values[i] + ", ";
        }
        if(Integer.getInteger(values[values.length - 1]) == null) {
            values[values.length - 1] = "\"" + values[values.length - 1] + "\"";
        }
        queryValues += values[values.length - 1] + ")";

        stmt.executeUpdate("INSERT INTO " + table + " " + queryColumns + " VALUES " + queryValues);

        return false;
    }

    public boolean update(String table, String columns[], String values[]) {
        return false;
    }

    public boolean delete(String table, String column) {
        return false;
    }

    public void print(ResultSet rs) throws SQLException {
        while(rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }

}
