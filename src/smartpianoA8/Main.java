package smartpianoA8;

import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;

public class Main {
    public static void main(String[] args) {
        System.out.println("SmartPiano-A8\n");


        //IniciView menuView = new IniciView();
        //menuView.setVisible(true);
        smartpianoA8.presentation.views.LoginView loginView = new LoginView();
        //registerView.setSize(400,400);
        //RegisterView registerView = new RegisterView();
        //registerView.setVisible(true);


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
