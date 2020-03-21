import java.sql.*;

public class JDBC {
    private String username = "";
    private String password = "";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String URL = "jdbc:mysql://localhost/school?serverTimezone=UTC";

    public JDBC(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;
    }

    public Connection openConnection() throws SQLException {
        this.con = DriverManager.getConnection(URL, username, password);
        this.stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return this.con;
    }

    public Connection getConnection() {
        return this.con;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

    public ResultSet getResultSet() {
        return rs;
    }

    public void setResultSet(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSet select(String table, String column) throws SQLException {
        rs = stmt.executeQuery("SELECT " + column + " FROM " + table + ";");
        rs.next();
        return rs;
    }

    public ResultSet select(String table, String column, String where) throws SQLException {
        rs = stmt.executeQuery("SELECT " + column + " FROM " + table + " WHERE " + where + ";");
        rs.next();
        return rs;
    }

    // Insert metode som tager imod table, array af columns og values
    // Første for loop iterer igennem column arrayet og laver en del af querien ud fra dette via queryValues
    // Andet for loop iterer igennem values arrayet og undersøger om hver værdi er en int for at undgå fejl ved indsætning i database (ift. int/varchar osv. datatyper)
    public void insert(String table, String columns[], String values[]) throws SQLException {
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
        queryValues += values[values.length - 1] + ");";

        stmt.executeUpdate("INSERT INTO " + table + " " + queryColumns + " VALUES " + queryValues);
    }

    public void update(String table, String column, String expression, String where) throws SQLException {

        if (Integer.getInteger(expression) == null) {
            expression = "\"" + expression + "\"";
        }

        stmt.executeUpdate("UPDATE " + table + " SET " + column + " = " + expression + " WHERE " + where + ";");
    }

    public void delete(String table, String where) throws SQLException {
        stmt.executeQuery("DELETE FROM " + table + " WHERE " + where + ";");
    }

    // Deji laver en bedre
    public void populateDB() throws SQLException {
        insert("class", new String[]{"color_name"}, new String[]{"rød"});
        insert("class", new String[]{"color_name"}, new String[]{"gul"});
        insert("class", new String[]{"color_name"}, new String[]{"blå"});
        insert("class", new String[]{"color_name"}, new String[]{"grøn"});

        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Jesus", "Immergeil", "1"});
        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Benny", "Immer", "1"});
        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Manfred", "Geil", "3"});
        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Mulle", "Grænseoverskridende", "4"});
        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Gert", "Gang", "1"});
        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Sven", "Bent", "2"});
        insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Søren", "Nielsen", "2"});

        insert("guardian", new String[]{"first_name", "last_name", "class"}, new String[]{"Søren", "Nielsen", "2"});
    }

    // Til at teste
    public void print(ResultSet rs) throws SQLException {
        while(rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }
}