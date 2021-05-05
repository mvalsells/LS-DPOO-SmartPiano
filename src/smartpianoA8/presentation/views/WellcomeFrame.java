package smartpianoA8.presentation.views;

import smartpianoA8.presentation.Controller.WellcomeController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeFrame extends JFrame {


    CardLayout cards;
    JPanel mainPanel;
    BordersView bordersView;
    LoginView loginView;
    RegisterView registerView;
    public static final String chgToLogin = "chgToLogin";
    public static final String chgToRegister = "chgToRegister";

    public WellcomeFrame(){
        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        bordersView = new BordersView();
        loginView = new LoginView();
        registerView = new RegisterView();
        createAndShowGUI();
    }

    public void createAndShowGUI(){

        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,820));


        /*ImageView registerView;
        registerView = this.CreateRegisterView();

        ImageView loginView;
        loginView = this.CreateLoginView();*/

        mainPanel.add(registerView.runRegister(),"RegisterView");
        mainPanel.add(loginView.runLogin(),"LoginView");

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

    public void registerController(ActionListener controller){
        registerView.registerController(controller);

        loginView.getRegistrarse().addActionListener(controller);
        //registerView.getIniciarSessio().addActionListener(controller);
        //registerView.getRegisterButton().addActionListener(controller);
    }
    //Canvi panel view
    public void changeToRegister(){
        cards.show(mainPanel,"RegisterView");
    }
    public void changeToLogin(){
        cards.show(mainPanel,"LoginView");
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

       /* if(panel.equals("ToRegister")){
            changeToRegister();
        }else if(panel.equals(RegisterView.toLogin)){
            changeToLogin();
        }*/
    }
/*
    public CardLayout getCards(){

        return this.cards;

    }
    public JPanel getMainPanel(){

        return this.mainPanel;

    }
*/
    public String getRegisterViewNomString(){
        return this.registerView.getNom().getText();
    }
    public String getRegisterViewCorreuString(){
        return this.registerView.getCorreu().getText();
    }
    public String getRegisterViewContrasenyaString(){
        return this.registerView.getContrasenya().getText();
    }
    public String getRegisterViewRepetirContrasenyaString(){
        return this.registerView.getRepetirContrasenya().getText();
    }
    public String getLoginViewNomString(){
        return this.loginView.getNom().getText();
    }
    public String getLoginViewCorreuString(){
        return this.loginView.getCorreu().getText();
    }
    public String getLoginViewContrasenyaString(){
        return this.loginView.getContrasenya().getText();
    }
}
