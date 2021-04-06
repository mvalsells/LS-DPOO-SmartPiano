package smartpianoA8.Business;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonReader {

    /*private String      dbName;
    private String      dbAddress;
    private int         dbPort;
    private String      dbUser;
    private String      dbPassword;
    private int         timeScrapping; //In seconds*/

    public JsonReader(){}

    public static String readDatabaseData(String whatToRead) throws FileNotFoundException {

        FileInputStream configFile = new FileInputStream("resources/config.json");
        Reader reader = new InputStreamReader(configFile);
        JsonElement rootElement = JsonParser.parseReader(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();

        return switch (whatToRead) {
            case "Name" -> readName(rootObject.getAsJsonObject("SmartPiano-A8"));
            case "Address" -> readAddress(rootObject.getAsJsonObject("SmartPiano-A8"));
            case "Port" -> readPort(rootObject.getAsJsonObject("SmartPiano-A8"));
            case "User" -> readUser(rootObject.getAsJsonObject("SmartPiano-A8"));
            case "Password" -> readPassword(rootObject.getAsJsonObject("SmartPiano-A8"));
            case "Scrapping" -> readScrapping(rootObject.getAsJsonObject("SmartPiano-A8"));
            default -> null;
        };

    }

    private static String readName(JsonObject rootObject) {

    }
    private static String readAddress(JsonObject rootObject) {

    }
    private static String readPort(JsonObject rootObject) {

    }
    private static String readUser(JsonObject rootObject) {

    }
    private static String readPassword(JsonObject rootObject) {

    }
    private static String readScrapping(JsonObject rootObject) {

    }


}
