package smartpianoA8;

import smartpianoA8.Presentation.views.PianoView;
import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.JsonReadable;
import smartpianoA8.persistence.JsonReader;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLConnector;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;

import java.io.FileNotFoundException;

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
        UserDAO user = new SQLUserDAO(connectorSQL);
        User usuariJoquese = user.getUserByUsername("albertgarangou@emporda.cat");
        System.out.printf("final");

        //PianoView pianoView = new PianoView();


        ///pianoView.setVisible(true);
        //IniciView menuView = new IniciView();
        //menuView.setVisible(true);
        //smartpianoA8.presentation.views.LoginView loginView = new LoginView();
        ///registerView.setSize(400,400);
        /*smartpianoA8.presentation.views.RegisterView registerView = new smartpianoA8.presentation.views.RegisterView();
        registerView.setVisible(true);*/


        //Per comprobar la contrasenya
        /*UserManager um = new UserManager();
        Scanner sc = new Scanner(System.in);
        User u = new User("mvalsells", "marc@valsells.me","a","1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75");
        String input;
        do {
            System.out.print("Password: ");
            input = sc.nextLine();
            try {
                if (um.checkPassword(input, u)) {
                    System.out.println("Password OK");
                    System.out.println(um.encryptPassword(input));
                }
            } catch (PasswordException e) {
                e.printStackTrace();
            }
        } while (true);*/

    }
}
