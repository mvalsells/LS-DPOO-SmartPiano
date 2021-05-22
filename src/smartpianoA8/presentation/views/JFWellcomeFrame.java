package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.BordersView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el frame donde se encuentran los paneles asociados al wellcome,
 * además también podemos encotnrar los register controllers al igual que sus resoectivas acciones.
 * para controlar que los datos se creen correctamente.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JFWellcomeFrame extends JFrame {

    public static final String chgToLogin = "chgToLogin";
    public static final String chgToRegister = "chgToRegister";
    public static final String registerViewString = "JPRegisterView";
    public static final String loginViewString = "JPLoginView";


    private CardLayout cards;
    private JPanel mainPanel;
    private BordersView bordersView;
    private JPLoginView jpLoginView;
    private JPRegisterView jpRegisterView;

    /**
     * Constructor del JWellcomeFrame.
     */
    public JFWellcomeFrame(){
        setTitle("Wellcome - SmartPiano");
        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        bordersView = new BordersView();
        jpRegisterView = new JPRegisterView();
        jpLoginView = new JPLoginView();
        createAndShowGUI();
    }//Cierre del constructor

    /**
     * Método donde se le añaden los paneles al wellcomeFrame.
     */
    public void createAndShowGUI(){

        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,820));


        /*ImageView JPRegisterView;
        JPRegisterView = this.CreateRegisterView();

        ImageView JPLoginView;
        JPLoginView = this.CreateLoginView();*/

        mainPanel.add(jpRegisterView.runRegister(),registerViewString);
        mainPanel.add(jpLoginView.runLogin(),loginViewString);

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }//Cierre del método


    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller controlador asocioado a los botones.
     */
    public void registerController(ActionListener controller){
        jpRegisterView.registerController(controller);
        jpLoginView.registerController(controller);

    }//Cierre del método
    //Canvi panel view

    /**
     * Método para cambiar de vistas del login al register.
     */
    public void changeToRegister(){
        cards.show(mainPanel,registerViewString);
    }//Cierre del método

    /**
     * Método para cambiar de vistas del register al login.
     */
    public void changeToLogin(){
        cards.show(mainPanel,loginViewString);
    }//Cierre del método

    /**
     * Método que aplica la acción de cambiar de vista.
     * @param panel Panel de la vista a cambiar.
     */
    public void changePanel(String panel){
        switch (panel) {
            case chgToLogin:
                changeToLogin();
                break;
            case chgToRegister:
                changeToRegister();
                break;
        }

    }//Cierre del método
/*
    public CardLayout getCards(){

        return this.cards;

    }
    public JPanel getMainPanel(){

        return this.mainPanel;

    }
*/
    //Getters register
   /* public String getRegisterNomString(){ return jpRegisterView.getNomString(); }
    public String getRegisterCorreuString(){
        return jpRegisterView.getCorreuString();
    }
    public String getRegisterContrasenyaString(){
        return jpRegisterView.getContrasenyaString();
    }
    public Boolean isRegisterCheckBoxAcceptTandC(){return jpRegisterView.isCheckBoxAcceptTandC();}
    public String getRegisterRepetirContrasenyaString(){
        return jpRegisterView.getRepetirContrasenyaString();
    }
*/

    /**
     * Método donde almacena la información del register.
     * @return La información del register.
     */
    public ArrayList<String> getRegisterData() {
        return jpRegisterView.getData();
    }//Cierre del método.

    //Getters login
   /* public String getLoginNomString(){ return jpLoginView.getNomString();}
    public String getLoginCorreuString(){
        return jpLoginView.getCorreuString();
    }
    public String getLoginContrasenyaString(){
        return jpLoginView.getContrasenyaString();
    }*/

    /**
     * Método donde contiene la información del login almacenada en el arraylist de login.
     * @return La información del login almacenada en el arraylist de login.
     */
    public ArrayList<String> getLoginData() {
        return jpLoginView.getData();
    }//Cierre del método
}//Cierre del método
