package smartpianoA8.persistence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Classe per la lectura i configuració de la bbdd i el fitxer de configuració
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see JsonReadable
 */
public class JsonReadableImpl implements JsonReadable {

    private String      dbName;
    private String      dbAddress;
    private int         dbPort;
    private String      dbUser;
    private String      dbPassword;
    private int         timeScrapping; //In seconds

    /**
     * Constructor buit
     */
    public JsonReadableImpl(){}

    /**
     * Mètode per llegir el fitxer de configuració
     * @throws FileNotFoundException Exepció de control d'errors
     */
    public void readJsonConfig() throws FileNotFoundException {

        FileInputStream configFile = new FileInputStream("resources/config.json");
        Reader reader = new InputStreamReader(configFile);
        JsonElement rootElement = JsonParser.parseReader(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject smartPianoA8 = rootObject.getAsJsonObject("SmartPiano-A8");

        dbName = smartPianoA8.get("dbName").getAsString();
        dbAddress = smartPianoA8.get("dbAddress").getAsString();
        dbPort = smartPianoA8.get("dbPort").getAsInt();
        dbUser = smartPianoA8.get("dbUser").getAsString();
        dbPassword = smartPianoA8.get("dbPassword").getAsString();
        timeScrapping = smartPianoA8.get("timeScrapping").getAsInt();

    }

    /**
     * Getter del nom de la bbdd
     * @return nom de la bbdd
     */
    @Override
    public String getDbName() {
        return dbName;
    }

    /**
     * Getter de l'url de la bbdd
     * @return url
     */
    @Override
    public String getDbAddress() {
        return dbAddress;
    }

    /**
     * Getter del port de la bbdd
     * @return port
     */
    @Override
    public int getDbPort() {
        return dbPort;
    }

    /**
     * Getter de l'username de la bbdd
     * @return username
     */
    @Override
    public String getDbUser() {
        return dbUser;
    }

    /**
     * Getter de la contrassenya de la bbdd
     * @return contrassenya
     */
    @Override
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * Getter del temps de refresc de cançons
     * @return temps de refresc
     */
    @Override
    public int gettimeScrapping() {
        return timeScrapping;
    }

}
