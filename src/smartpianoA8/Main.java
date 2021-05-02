package smartpianoA8;

import smartpianoA8.business.BusinessFacade;

import smartpianoA8.business.BusinessFacadeImpl;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.JsonReadable;
import smartpianoA8.persistence.JsonReader;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLConnector;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;
import smartpianoA8.presentation.views.PianoView;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int ERROR_CODE_FILE = 1;
        //BBDD v
        //rebre dades fitxer




        JsonReadable jsonReader = new JsonReader();

        try {
            jsonReader.readJsonConfig();
        }catch (FileNotFoundException f){
            System.out.println("ERROR: No s'ha pogut llegir el fitxer de configuració");
            System.exit(ERROR_CODE_FILE);
        }

        System.out.println("SmartPiano-A8\n");

        //connectar
        SQLConnector connectorSQL = new SQLConnector(jsonReader.getDbUser(),jsonReader.getDbPassword(),jsonReader.getDbAddress(),jsonReader.getDbPort(),jsonReader.getDbName());
        UserDAO userDAO = new SQLUserDAO(connectorSQL);
        User usuariJoquese = userDAO.getUserByUsername("albertgarangou@emporda.cat");
        System.out.printf("final");




        //Test register
        BusinessFacade businessFacade = new BusinessFacadeImpl(userDAO);
        Scanner sc = new Scanner(System.in);

        /*while (true) {
            System.out.print("\n\n\nUsername: ");
            String username = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            try {
                businessFacade.registerUser(username, email, password, User.TYPE_SMARTPIANO);
            } catch (PasswordException e) {
                System.out.println("Password KO");
                e.printStackTrace();
            } catch (UserManagerException e) {
                System.out.println("User KO");
                e.printStackTrace();
            }

        }*/
        /*try {
            businessFacade.login("mvalsells","Dpoo12345");
        } catch (UserManagerException e) {
            e.printStackTrace();
        }
        businessFacade.modifyCurrentUserEmail("marc.valsells@gmail.com");
        sc.nextLine();
        businessFacade.modifyCurrentUserName("marc.valsells");
        sc.nextLine();
        try {
            businessFacade.modifyCurrentUserPassword("DpoO12345");
        } catch (PasswordException e) {
            e.printStackTrace();
        }*/


        //PianoView pianoView = new PianoView();


        //pianoView.setVisible(true);
        //IniciView menuView = new IniciView();
        //menuView.setVisible(true);
        //smartpianoA8.presentation.views.LoginView loginView = new LoginView();
        ///registerView.setSize(400,400);
        /*smartpianoA8.presentation.views.RegisterView registerView = new smartpianoA8.presentation.views.RegisterView();
        registerView.setVisible(true);*/



    }
}
