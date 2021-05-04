package smartpianoA8.presentation.Controller;


import smartpianoA8.presentation.views.WellcomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeController implements ActionListener {

    WellcomeFrame wellcomeFrame;
    public WellcomeController(){


        wellcomeFrame  = new WellcomeFrame();
        wellcomeFrame.registerController(this);

    }

    public void changePanel(String string, CardLayout cards, JPanel panel){
        if(string.equals("ToRegister")){
            cards.show(panel,"RegisterView");
        }else if(string.equals("ToLogin")){
            cards.show(panel,"LoginView");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ToRegister")){
            changePanel("ToRegister",wellcomeFrame.getCards(),wellcomeFrame.getMainPanel());

        }else if(e.getActionCommand().equals("ToLogin")){
            changePanel("ToLogin",wellcomeFrame.getCards(),wellcomeFrame.getMainPanel());
        }

    }

}
