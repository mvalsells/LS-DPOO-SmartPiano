package smartpianoA8.presentation.Controller;

import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.JPProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfileController implements ActionListener {
    private MasterController masterController;
    public ProfileController(MasterController masterController){
        this.masterController = masterController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case JPProfile.Logout:
                //masterController.logout();
                break;
            case JPProfile.SaveSettings:
                ArrayList<String> data = null; //masterController.profileGetData();
                //try {
                    if (!data.get(0).equals("New username")) {
                        //masterController.updateUsername(data.get(0));
                    }
                    if (!data.get(1).equals("New email")) {
                        //masterController.updateEmail(data.get(1));
                    }
                    if (!data.get(2).equals("New password")) {
                        //masterController.updatePassword(data.get(2), data.get(3));
                    }
                /*} catch (PasswordException exeception){
                    StringBuilder sb = new StringBuilder();

                    if (e.isHasNotLowerCase()) {
                        sb.append("- No tiene minuscula/s\n");
                    }
                    if (e.isHasNotNumber()) {
                        sb.append("- No tiene numero/s\n");
                    }
                    if (e.isHasNotUpperCase()) {
                        sb.append("- No tiene mayuscula/s\n");
                    }
                    if (e.isPasswordToShort()) {
                        sb.append("- Es demasiado corta\n");
                    }

                    JOptionPane.showMessageDialog(wellcomeFrame,sb.toString(),"Contraseña incorrecta",JOptionPane.WARNING_MESSAGE);
                } catch (UserManagerException exception){

                }*/
                break;
        }
    }
}
