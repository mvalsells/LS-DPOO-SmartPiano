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
    public void updateNumReproduccions(int hora, String user) {
        String query = "SELECT NumCancons FROM Stats WHERE NomUsuari LIKE '" + user + "' AND Hora = " + hora + ";";
        ResultSet result = connector.selectQuery(query);

        try{
            result.next();//get select once

            int num = result.getInt("NumCancons");
            query = "UPDATE Stats SET NumCancons " + num++ + " WHERE NomUsuari LIKE '" + user + "' AND Hora = " + hora + ";";
            connector.updateQuery(query);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQLSTATSDAO ERROR no es pot obtenir el numero de cancons");
        }
    }

    /**
     * Afegeix uns minuts al que ja hi havia
     */
    @Override
    public void updateNumMinuts(int hora, Time tempsAfegir, String user) {
        int minuts, segons;
        String query = "SELECT NumMinuts FROM Stats WHERE NomUsuari LIKE '" + user + "' AND Hora = " + hora + ";";
        ResultSet result = connector.selectQuery(query);

        try{
            result.next();//get select once

            segons = result.getInt("NumSegons") + tempsAfegir.getSeconds();
            minuts = result.getInt("NumMinuts") + tempsAfegir.getMinutes();

            if(segons >= 60) {
                minuts++;
                segons -= 60;
            }

            query = "UPDATE Stats SET NumMinuts = " + minuts + ", NumSegons = " + segons + " WHERE NumUsuari LIKE '" + user + "' " +
                    "AND Hora = " + hora + ";";
            connector.updateQuery(query);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQLSTATSDAO ERROR no es pot obtenir el numero de minuts/segons");
        }

    }

}
