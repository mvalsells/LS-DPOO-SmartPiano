package smartpianoA8.persistence;

import java.io.FileNotFoundException;

/**
 * Interficie per l'obtenció de dades del fitxer de configuració
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface JsonReadable {

    /**
     * Getter del nom de la bbdd
     * @return nom de la bbdd
     */
    public String getDbName();

    /**
     * Getter de l'url de la bbdd
     * @return url
     */
    public String getDbAddress();

    /**
     * Getter del port de la bbdd
     * @return port
     */
    public int getDbPort();

    /**
     * Getter de l'username de la bbdd
     * @return username
     */
    public String getDbUser();

    /**
     * Getter de la contra de la bbdd
     * @return contrassenya
     */
    public String getDbPassword();

    /**
     * Getter del temps de refresc de l'scrapper
     * @return temps de refresc
     */
    public int gettimeScrapping();

    /**
     * Mètode per llegir el fitxer de configuració
     * @throws FileNotFoundException Control d'errors del fitxer
     */
    public void readJsonConfig() throws FileNotFoundException;

}
