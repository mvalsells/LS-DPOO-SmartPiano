package smartpianoA8.business.dao.sql;

import java.sql.*;

/**
 * The SQLConnector class will abstract the specifics of the connection to a MySQL database.
 */
public class SQLConnector {
    private static SQLConnector instance = null;

    // Attributes to connect to the database.
    private static String username;
    private static String password;
    private static String ip;
    private static int port;
    private final String url;
    private static Connection conn;
    private static String database;

    // Parametrized constructor
    private SQLConnector(String username, String password, String ip, int port, String database) {
        SQLConnector.username = username;
        SQLConnector.password = password;
        SQLConnector.port = port;
        SQLConnector.ip = ip;
        SQLConnector.database = database;
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    }


    /**
     * Static method that returns the shared instance managed by the singleton.
     *
     * @return The shared SQLConnector instance.
     */
    public static SQLConnector getInstance(){
        if (instance == null ){
            // NOT a good practice to hardcode connection data! Be aware of this for your project delivery ;)
            instance = new SQLConnector(username, password, ip, port, database);
            instance.connect();
        }
        return instance;
    }




    /**
     * Method that starts the inner connection to the database. Ideally, users would disconnect after
     * using the shared instance.
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.err.println("Couldn't connect to --> " + url + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes an insertion query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void insertQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when inserting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes an update query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void updateQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problema when updating --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes a deletion query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void deleteQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when deleting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }

    }


    /**
     * Method that executes a selection query to the connected database.
     *
     * @param query String representation of the query to execute.
     * @return The results of the selection.
     */
    public ResultSet selectQuery(String query){
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when selecting data --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
        return rs;
    }


    /**
     * Method that closes the inner connection to the database. Ideally, users would disconnect after
     * using the shared instance.
     */
    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem when closing the connection --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }
}
