package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.BordersView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


    public JFWellcomeFrame(){
        setTitle("Wellcome - SmartPiano");
        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        bordersView = new BordersView();
        jpRegisterView = new JPRegisterView();
        jpLoginView = new JPLoginView();
        createAndShowGUI();
    }

    public void createAndShowGUI(){

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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

    }



    public void registerController(ActionListener controller){
        jpRegisterView.registerController(controller);
        jpLoginView.registerController(controller);

    }
    //Canvi panel view
    public void changeToRegister(){
        cards.show(mainPanel,registerViewString);
    }
    public void changeToLogin(){
        cards.show(mainPanel,loginViewString);
    }

    public void changePanel(String panel){
        switch (panel) {
            case chgToLogin:
                changeToLogin();
                break;
            case chgToRegister:
                changeToRegister();
                break;
        }

    }
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
    public ArrayList<String> getRegisterData() {
        return jpRegisterView.getData();
    }

    //Getters login
   /* public String getLoginNomString(){ return jpLoginView.getNomString();}
    public String getLoginCorreuString(){
        return jpLoginView.getCorreuString();
    }
    public String getLoginContrasenyaString(){
        return jpLoginView.getContrasenyaString();
    }*/
    public ArrayList<String> getLoginData() {
        return jpLoginView.getData();
    }
}
