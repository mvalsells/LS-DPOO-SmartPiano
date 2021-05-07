package smartpianoA8.presentation.views;

import smartpianoA8.presentation.Controller.WellcomeController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeFrame extends JFrame {

    public static final String chgToLogin = "chgToLogin";
    public static final String chgToRegister = "chgToRegister";
    public static final String registerViewString = "RegisterView";
    public static final String loginViewString = "LoginView";


    private CardLayout cards;
    private JPanel mainPanel;
    private BordersView bordersView;
    private LoginView loginView;
    private RegisterView registerView;


    public WellcomeFrame(RegisterView registerView,LoginView loginView){
        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        bordersView = new BordersView();
        this.registerView = registerView;
        this.loginView = loginView;
        createAndShowGUI();
    }

    public void createAndShowGUI(){

        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,820));


        /*ImageView registerView;
        registerView = this.CreateRegisterView();

        ImageView loginView;
        loginView = this.CreateLoginView();*/

        mainPanel.add(registerView.runRegister(),registerViewString);
        mainPanel.add(loginView.runLogin(),loginViewString);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }



    public void registerController(ActionListener controller){
        registerView.registerController(controller);
        loginView.registerController(controller);

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
    public String getRegisterNomString(){ return registerView.getNomString(); }
    public String getRegisterCorreuString(){
        return registerView.getCorreuString();
    }
    public String getRegisterContrasenyaString(){
        return registerView.getContrasenyaString();
    }
    public Boolean isRegisterCheckBoxAcceptTandC(){return registerView.isCheckBoxAcceptTandC();}
    public String getRegisterRepetirContrasenyaString(){
        return registerView.getRepetirContrasenyaString();
    }

    //Getters login
    public String getLoginNomString(){ return loginView.getNomString();}
    public String getLoginCorreuString(){
        return loginView.getCorreuString();
    }
    public String getLoginContrasenyaString(){
        return loginView.getContrasenyaString();
    }

}
