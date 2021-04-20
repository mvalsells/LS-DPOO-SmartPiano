package smartpianoA8;

import smartpianoA8.business.*;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.presentation.views.IniciView;
import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("SmartPiano-A8\n");


        //IniciView menuView = new IniciView();
        //menuView.setVisible(true);
        //smartpianoA8.presentation.views.LoginView loginView = new LoginView();
        //registerView.setSize(400,400);
        RegisterView registerView = new RegisterView();
        //registerView.setVisible(true);


        //Per comprobar la contrasenya
        /* um = new UserManager();
        Scanner sc = new Scanner(System.in);

        do {
            User u = new User();
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            try {
                um.registerUser(username, email, password, User.TYPE_SMARTPIANO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        */
    }
}
