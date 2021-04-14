package smartpianoA8.persistence.dao;

import smartpianoA8.persistence.dao.sql.SQLConnector;

import java.sql.ResultSet;

public interface DBStarter {

    public void connect();
    public void insertQuery(String query);
    public void updateQuery(String query);
    public void deleteQuery(String query);
    public ResultSet selectQuery(String query);
    public void disconnect();


}
