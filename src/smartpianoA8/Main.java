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

            reader.readJsonConfig();

            System.out.println(reader.getDbUser());

        }catch (FileNotFoundException ignored) {
        }
    }
}
