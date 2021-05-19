package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.Song;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Interfície pel control de gràfiques
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
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


    /**
     * Obté una arrayList amb els valors de reproduccions
     * @return ArrayList amb els valors dits
     */
    ArrayList<Integer> getDataReproduccions(String user);

    /**
     * Obté una arrayList amb els valors de minuts (amb decimals de segons /100 i no /60).
     * @return ArrayList amb els valors dits
     */
    ArrayList<Double> getDataMinuts(String user);
}