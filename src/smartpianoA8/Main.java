package smartpianoA8;

import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;
import smartpianoA8.persistence.JsonReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("SmartPiano-A8\n");

        //RegisterView registerView = new RegisterView();
        smartpianoA8.presentation.views.LoginView loginView = new LoginView();
        //registerView.setSize(400,400);
        //registerView.setVisible(true);

    }
}
