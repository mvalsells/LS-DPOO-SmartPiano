package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.StatsDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class SQLStatsDAO implements StatsDAO {
    private SQLConnector connector;
    public SQLStatsDAO(SQLConnector connector){
        this.connector = connector;
    }

    /**
     * Mètode que posa a 0 tots els minuts i reprod d'un usuari havent-hi 0 entrades a la seva taula abans
     */
    @Override
    public void startupStats(String user) {
        String query;
        for(int i=0; i<24;i++) {
            query = "INSERT INTO Stats(NumCancons, NumMinuts, Hora, NomUsuari) VALUES ('" +
                    0 + "', '" +
                    0 + "', '" +
                    i + "', '" +
                    user + "');";
            connector.insertQuery(query);
        }
    }

    /**
     * incrementa +1 un num reproduccions
     */
    @Override
    public void updateNumReproduccions(Time hora, String user) {
        String query = "SELECT NumCancons FROM Stats WHERE NomUsuari LIKE '" + user + "';";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()){

            }
        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    /**
     * Afegeix uns minuts al que ja hi havia
     */
    @Override
    public void updateNumMinuts(Time hora, Time minutsAfegir, String user) {

    }

}
