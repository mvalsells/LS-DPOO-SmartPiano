package smartpianoA8.presentation.views;

import smartpianoA8.presentation.Controller.WellcomeController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeFrame extends JFrame {

    public static final String chgToLogin = "chgToLogin";
    public static final String chgToRegister = "chgToRegister";


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
        loginView.registerController(controller);

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

    }
/*
    public CardLayout getCards(){

        return this.cards;

    }
    public JPanel getMainPanel(){

        return this.mainPanel;

    }
*/

}
