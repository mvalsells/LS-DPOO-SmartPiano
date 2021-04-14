package smartpianoA8.persistence.dao;

import smartpianoA8.persistence.dao.sql.SQLConnector;

import java.sql.ResultSet;

public interface DBStarter {

    /**
     *
     */
    public void connect();

    /**
     *
     * @param query
     */
    public void insertQuery(String query);

    /**
     *
     * @param query
     */
    public void updateQuery(String query);

    /**
     *
     * @param query
     */
    public void deleteQuery(String query);

    /**
     *
     * @param query
     * @return
     */
    public ResultSet selectQuery(String query);

    /**
     *
     */
    public void disconnect();
}
