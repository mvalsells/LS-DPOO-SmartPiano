package smartpianoA8.presentation.views;

import smartpianoA8.presentation.Controller.WellcomeController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeFrame extends JFrame {

    WellcomeController wellcomeController;

    CardLayout cards;
    JPanel mainPanel;
    BordersView bordersView;
    LoginView loginView;
    RegisterView registerView;

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
        loginView.getRegistrarse().addActionListener(controller);
        registerView.getIniciarSessio().addActionListener(controller);
        registerView.getRegisterButton().addActionListener(controller);
    }



    public CardLayout getCards(){

        return this.cards;

    }
    public JPanel getMainPanel(){

        return this.mainPanel;

    }

    public RegisterView getRegisterView(){
        return this.registerView;
    }

}
