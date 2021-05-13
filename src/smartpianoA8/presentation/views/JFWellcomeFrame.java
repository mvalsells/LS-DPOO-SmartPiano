package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.BordersView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFWellcomeFrame extends JFrame {

    public static final String chgToLogin = "chgToLogin";
    public static final String chgToRegister = "chgToRegister";
    public static final String registerViewString = "JPRegisterView";
    public static final String loginViewString = "JPLoginView";


    private CardLayout cards;
    private JPanel mainPanel;
    private BordersView bordersView;
    private JPLoginView JPLoginView;
    private JPRegisterView JPRegisterView;


    public JFWellcomeFrame(JPRegisterView JPRegisterView, JPLoginView JPLoginView){
        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        bordersView = new BordersView();
        this.JPRegisterView = JPRegisterView;
        this.JPLoginView = JPLoginView;
        createAndShowGUI();
    }

    public void createAndShowGUI(){

        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,820));


        /*ImageView JPRegisterView;
        JPRegisterView = this.CreateRegisterView();

        ImageView JPLoginView;
        JPLoginView = this.CreateLoginView();*/

        mainPanel.add(JPRegisterView.runRegister(),registerViewString);
        mainPanel.add(JPLoginView.runLogin(),loginViewString);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }



    public void registerController(ActionListener controller){
        JPRegisterView.registerController(controller);
        JPLoginView.registerController(controller);

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
    public String getRegisterNomString(){ return JPRegisterView.getNomString(); }
    public String getRegisterCorreuString(){
        return JPRegisterView.getCorreuString();
    }
    public String getRegisterContrasenyaString(){
        return JPRegisterView.getContrasenyaString();
    }
    public Boolean isRegisterCheckBoxAcceptTandC(){return JPRegisterView.isCheckBoxAcceptTandC();}
    public String getRegisterRepetirContrasenyaString(){
        return JPRegisterView.getRepetirContrasenyaString();
    }

    //Getters login
    public String getLoginNomString(){ return JPLoginView.getNomString();}
    public String getLoginCorreuString(){
        return JPLoginView.getCorreuString();
    }
    public String getLoginContrasenyaString(){
        return JPLoginView.getContrasenyaString();
    }


}
