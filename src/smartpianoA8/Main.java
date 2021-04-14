package smartpianoA8;

import smartpianoA8.Presentation.views.RegisterView;
import smartpianoA8.persistence.JsonReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("SmartPiano-A8\n");

        JsonReader reader = new JsonReader();
        RegisterView registerView = new RegisterView();
        //registerView.setSize(400,400);
        //registerView.setVisible(true);


        try {

            reader.readJsonConfig();

            System.out.println(reader.getDbUser());

        }catch (FileNotFoundException ignored) {
        }
    }
}
