package smartpianoA8;

import smartpianoA8.Persistence.*;
//import smartpianoA8.Business.*;
//import smartpianoA8.Presentation.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("SmartPiano-A8\n");

        JsonReader reader = new JsonReader();

        try {

            System.out.println(reader.readDatabaseData("Name"));
            System.out.println(reader.readDatabaseData("Address"));
            System.out.println(reader.readDatabaseData("Port"));
            System.out.println(reader.readDatabaseData("User"));
            System.out.println(reader.readDatabaseData("Password"));
            System.out.println(reader.readDatabaseData("Scrapping"));

        }catch (FileNotFoundException ignored) {
        }
    }
}
