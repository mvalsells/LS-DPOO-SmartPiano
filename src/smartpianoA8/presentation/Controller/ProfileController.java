package smartpianoA8.presentation.Controller;

import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.presentation.views.JPProfileView;
import smartpianoA8.presentation.views.customComponents.piano.Key;
import smartpianoA8.presentation.views.customComponents.Tecla;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe controller del perfil
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 */
public class ProfileController implements ActionListener, MouseListener, KeyListener {
    // ---- Inici Atributs ----
    private PresentationController presentationController;
    private HashMap<Integer, Tecla> hmReal;
    private HashMap<Integer, Integer> hmProfile;
    private boolean dialogShown;
    private int ultimaNota;
    // ---- Fi Atributs ----
    // ---- Inici Constructor ----

    /**
     * Consructor buit
     */
    public ProfileController(){
        dialogShown=false;
    }


    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    /**
     * Mètode per registrar el controller a la presentació
     * @param presentationController la presentació
     */
    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
        hmReal = presentationController.getHMteclas();
        hmProfile = new HashMap<>();
        for (Map.Entry<Integer, Tecla> en: hmReal.entrySet()){
            hmProfile.put(en.getValue().getNota(),en.getKey());
        }
    }

    /**
     * Mètode per detectar i canviar de vista
     * @param e action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            //Profile View
            case JPProfileView.LOGOUT:
                presentationController.logout();
                break;
            case JPProfileView.SAVE_SETTING:
                saveSettings();
                break;
            case JPProfileView.STATS:
                //new JFStatisticsView(presentationController.getNumMinutsCurrentUser(), presentationController.getNumReproducionsCurrentUser());
                presentationController.showStatistics();
                break;
            case JPProfileView.TOP_5:
                //new JFTop5View(presentationController.getTop5());
                presentationController.showTop5();
                break;
            case JPProfileView.DELETE_ACCOUNT:
                presentationController.removeCurrentUser();
                break;
        }
    }


    private void saveSettings() {
        ArrayList<String> data = presentationController.profileViewGetData();
        StringBuilder message = new StringBuilder();
        try {
            if (data.get(0) != null) {
                if(presentationController.updateUsername(data.get(0))){
                    message.append("·Nombre de usuari actualizado\n");
                } else {
                    message.append("·Nombre de usuario incorrecto o ya en uso\n");
                }
            }
            if (data.get(1) != null) {
                if(presentationController.updateEmail(data.get(1))) {
                    message.append("·Email actualizado\n");
                } else {
                    message.append("·Email incorrecto o ya en uso\n");
                }
            }
            if (data.get(2) != null && data.get(3) != null) {
                presentationController.updatePassword(data.get(2), data.get(3));
                message.append("·Contraseña actualizada\n");
            }
        } catch (PasswordException exeception){
            if (exeception.isPasswordsDifferent()){
                message.append("· Las contraseñas no coinciden\n");
            } else {
                message.append("· La contraseña no cumple con los requisitos:\n");
                if (exeception.isHasNotLowerCase()) {
                    message.append("- No tiene minuscula/s\n");
                }
                if (exeception.isHasNotNumber()) {
                    message.append("- No tiene numero/s\n");
                }
                if (exeception.isHasNotUpperCase()) {
                    message.append("\t- No tiene mayuscula/s\n");
                }
                if (exeception.isPasswordToShort()) {
                    message.append("\t- Es demasiado corta\n");
                }
            }
        }
        if (!message.toString().equals("")){
            presentationController.showWarningDialog(message.toString());
        }
        presentationController.profileViewUpdateText();
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

        //hmProfile: Key= int Nota Value= int VK_TECLA
        //hmReal: Key= int VK_TECLA Value= Tecla

        Key key = (Key) e.getSource();
        ultimaNota = key.getNote();
        //Show dialog
        dialogShown = true;
        presentationController.profileViewShowDialog("Presione la tecla a assignar a la tecla del piano numero " + (ultimaNota-47),"");

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {

        //hmProfile: Key=int nota Value= int VK_TECLA
        //hmReal: Key=int VK_TEcla Value= int Tecla

        if (dialogShown) {
            int presseKey = e.getKeyCode();
            //Check if key alredy in use
            if (hmReal.get(presseKey) == null) {
                //No exsiteix, actualitzar
                int teclaVKAntiga = hmProfile.get(ultimaNota);
                Tecla teclaPiano = hmReal.get(teclaVKAntiga);
                hmReal.remove(teclaVKAntiga);
                teclaPiano.setNota(ultimaNota);
                hmReal.put(presseKey, teclaPiano);
                hmProfile.replace(ultimaNota, presseKey);

                presentationController.profileViewCloseDialog();
                presentationController.setHMteclas(hmReal);
                dialogShown=false;
            } else {
                int notaPressedKey = hmReal.get(presseKey).getNota()-47;
                presentationController.profileViewShowDialog("Tecla ya assignada a la tecla numero " + notaPressedKey + " del piano","Prueba otra");
            }
        }

        //Integer lletra del teclat fisica
        //Tecla

        /*
        Buscar la Tecla (classe piano) que te la nota key.getNote() i assignar-ho al Integer del teclat físic
         */
        //hmTecles.get(key); //Quina nota a actualitzar
        //System.out.println("E: " + e.getSource());
        //System.out.println("Key " + key.getNote());
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
