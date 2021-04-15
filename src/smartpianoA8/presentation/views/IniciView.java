package smartpianoA8.Presentation.views;

import javax.swing.*;
import java.awt.*;

public class IniciView extends JFrame {
    public IniciView(){
        configureMenu();
    }

    private void configureMenu(){
        JFrame jFrameMenu = new JFrame();
        jFrameMenu.setLayout(new CardLayout());

        /*Panell principal on anira imatge*/
        JPanel PanelMenu = new JPanel();
        PanelMenu.setBackground(Color.GRAY);
        PanelMenu.setLayout(new BorderLayout());

        JPanel PanelLateral = new JPanel();
        //PanelLateral.setOpaque(true);
        PanelLateral.setBackground(Color.BLUE);
        PanelLateral.setLayout(new BorderLayout());

        JPanel Botons = new JPanel(); //Panel per situar els botons del Nord a la dreta
        Botons.setOpaque(false);
        Botons.setLayout(new FlowLayout());

        JButton BotoCanço = new JButton("Iniciar sesion");
        BotoCanço.setForeground(new Color(255,255,255));
        BotoCanço.setBackground(new Color(249,171,15));
        BotoCanço.setPreferredSize(new Dimension(130,35));
        BotoCanço.setBorderPainted(false);
        BotoCanço.setOpaque(true);
        BotoCanço.setVisible(true);

        Botons.add(BotoCanço);

        PanelLateral.add(Botons,BorderLayout.NORTH);

        PanelMenu.add(PanelLateral,BorderLayout.WEST);


        jFrameMenu.setResizable(false);
        jFrameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameMenu.getContentPane().add("Ref_1",PanelMenu);
        jFrameMenu.setPreferredSize(new Dimension(1000,820));
        jFrameMenu.pack();
        jFrameMenu.setVisible(true);

    }
}
