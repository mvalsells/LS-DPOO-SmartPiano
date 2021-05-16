package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.StatsDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Classe pel control de gràfiques de la bbdd
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class SQLStatsDAO implements StatsDAO {
    private SQLConnector connector;

    public SQLStatsDAO(SQLConnector connector) {
        this.connector = connector;
    }

    /**
     * Mètode que posa a 0 tots els minuts i reprod d'un usuari havent-hi 0 entrades a la seva taula abans.
     */
    @Override
    public void startupStats(String user) {
        String query;
        for (int i = 0; i < 24; i++) {
            query = "INSERT INTO Stats(NumCancons, NumMinuts, Hora, NomUsuari) VALUES ('" +
                    0 + "', '" +
                    0 + "', '" +
                    i + "', '" +
                    user + "');";
            connector.insertQuery(query);
        }
    }   //TODO cridar la funció quan es crei un nou usuari

    /**
     * incrementa +1 un num reproduccions
     */
    private void updateNumReproduccions(int hora, String user) {
        String query = "SELECT NumCancons FROM Stats WHERE NomUsuari LIKE '" + user + "' AND Hora = " + hora + ";";
        ResultSet result = connector.selectQuery(query);

        try {
            result.next();//get select once

            int num = result.getInt("NumCancons") + 1;
            query = "UPDATE Stats SET NumCancons " + num + " WHERE NomUsuari LIKE '" + user + "' AND Hora = " + hora + ";";
            connector.updateQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLSTATSDAO ERROR no es pot obtenir el numero de cancons");
        }
    }

    /**
     * Afegeix uns minuts al que ja hi havia.
     */
    private void updateNumMinuts(int hora, LocalTime tempsAfegir, String user) {
        int minuts, segons;
        String query = "SELECT NumMinuts FROM Stats WHERE NomUsuari LIKE '" + user + "' AND Hora = " + hora + ";";
        ResultSet result = connector.selectQuery(query);

        try {
            result.next();//get select once

            segons = result.getInt("NumSegons") + tempsAfegir.getSecond();
            minuts = result.getInt("NumMinuts") + tempsAfegir.getMinute();

            if (segons >= 60) {
                minuts++;
                segons -= 60;
            }

            query = "UPDATE Stats SET NumMinuts = " + minuts + ", NumSegons = " + segons + " WHERE NumUsuari LIKE '" + user + "' " +
                    "AND Hora = " + hora + ";";
            connector.updateQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLSTATSDAO ERROR no es pot obtenir el numero de minuts/segons");
        }

    }

    /**
     * Actualitza la duració i num de reproducions. S'ha de cridar cada cop que es reprodueix una cançó.
     *
     * @param duradaSong durada en LocalTime de la cançó
     * @param username   NomUsuari UserName de l'usuari que l'ha reproduit (actual)
     */
    @Override
    public void actualitzarBBDDEstadistiques(LocalTime duradaSong, String username) {    //TODO cridar la funció quan es reprodueixi
        updateNumMinuts(LocalTime.now().getHour(), duradaSong, username);
        updateNumReproduccions(LocalTime.now().getHour(), username);
    }

    /**
     * Obté una arrayList amb els valors de reproduccions
     * @return ArrayList amb els valors dits
     */
    @Override
    public ArrayList<Integer> getDataReproduccions(String user) {
        ArrayList<Integer> returner = new ArrayList<>();
        String query;
        int i = 0;
        ResultSet result;

        try {
            while (i < 24) {//del 1 al 23 fa la query
                query = "SELECT NumCancons FROM Stats WHERE NomUsuari LIKE '" + user + "' AND Hora = " + i + ";";
                result = connector.selectQuery(query);
                result.next();
                returner.add(result.getInt("NumCancons"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR CREANT ESTADISTIQUES BBDD -> getDataReproduccions. Can't SELECT.");
            return null;
        }
        return returner;
    }

    /**
     * Obté una arrayList amb els valors de minuts (amb decimals de segons /100 i no /60).
     * @return ArrayList amb els valors dits
     */
    @Override
    public ArrayList<Double> getDataMinuts(String user) {
        ArrayList<Double> returner = new ArrayList<>();
        String query;
        int i = 0;
        ResultSet result;
        try {
            while (i < 24) {//del 1 al 23 fa la query
                query = "SELECT NumMinuts, NumSegons FROM Stats WHERE NomUsuari LIKE '" + user + "' AND Hora = " + i + ";";
                result = connector.selectQuery(query);
                result.next();
                returner.add((result.getInt("NumMinuts") + result.getInt("NumSegons") / 60.0));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR CREANT ESTADISTIQUES BBDD -> getDataReproduccions. Can't SELECT.");
            return null;
        }
        return returner;
    }

}
