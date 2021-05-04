package smartpianoA8.persistence.dao;

import java.sql.Time;
import java.time.LocalTime;

public interface StatsDAO {

    /**
     * Mètode que posa a 0 tots els minuts i reprod d'un usuari havent-hi 0 entrades a la seva taula abans.
     * @param user nom de l'usuari nou creat per fer el config/constructor a la BBDD
     */
    void startupStats(String user);     //TODO cridar la funció quan es crei un nou usuari

    /**
     *  Actualitza la duració i num de reproducions. S'ha de cridar cada cop que es reprodueix una cançó.
     * @param duradaSong durada en LocalTime de la cançó
     * @param username NomUsuari UserName de l'usuari que l'ha reproduit (actual)
     */
    void actualitzarBBDDEstadistiques(LocalTime duradaSong, String username);   //TODO cridar la funció quan es reprodueixi
}