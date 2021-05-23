package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.Song;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Interfície pel control de gràfiques
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface StatsDAO {

    /**
     * Mètode que posa a 0 tots els minuts i reprod d'un usuari havent-hi 0 entrades a la seva taula abans.
     * @param user nom de l'usuari nou creat per fer el config/constructor a la BBDD
     */
    void startupStats(String user);

    /**
     * Mètode per actualitzar els valors des del programa a la bbdd de les reproduccions i minuts
     * @param minutsAfegir minuts extres a afegir
     * @param segonsAfegir segons extres a afegir
     * @param username nom d'usuari a modificar
     */
    void actualitzarBBDDEstadistiques(int minutsAfegir, int segonsAfegir, String username);   //TODO cridar la funció quan es reprodueixi


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