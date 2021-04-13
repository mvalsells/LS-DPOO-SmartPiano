package smartpianoA8.Presentation.Views;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    //ImageView imageView = new ImageView();
    public RegisterView(){
        conifgureInici();

    }
    private void conifgureInici(){
        ImageView panel = new ImageView(new ImageIcon("7faf81f4bf8807cfa0d1.jpg").getImage());
        JPanel CapaSuperior = new JPanel();
        JFrame frame = new JFrame();

        frame.setLayout(new CardLayout());

        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        CapaSuperior.setLayout(new BorderLayout());


        CapaSuperior.setOpaque(false);

        JButton reg = new JButton("REGISTRAR-SE");
        reg.setBackground(Color.orange);
        reg.setSize(100,30);
        reg.setVisible(true);

        CapaSuperior.add(reg,BorderLayout.EAST);
        panel.add(CapaSuperior,BorderLayout.CENTER);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add("Ref_1",panel);
        frame.pack();
        frame.setVisible(true);







    }






}
