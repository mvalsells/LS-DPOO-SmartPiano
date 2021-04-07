package smartpianoA8.Persistence;

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

    public String readDatabaseData(String whatToRead) throws FileNotFoundException {

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

    private String readName(JsonObject rootObject) {
        return rootObject.get("dbName").getAsString();
    }
    private String readAddress(JsonObject rootObject) {
        return rootObject.get("dbAddress").getAsString();
    }
    private String readPort(JsonObject rootObject) {
        return rootObject.get("dbPort").getAsString();
    }
    private String readUser(JsonObject rootObject) {
        return rootObject.get("dbUser").getAsString();
    }
    private String readPassword(JsonObject rootObject) {
        return rootObject.get("dbPassword").getAsString();
    }
    private String readScrapping(JsonObject rootObject) {
        return rootObject.get("timeScrapping").getAsString();
    }


}
