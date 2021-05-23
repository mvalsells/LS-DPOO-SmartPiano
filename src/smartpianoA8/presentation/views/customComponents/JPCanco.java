package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class JPCanco extends JPMainView {

    private JButton jbCancion;
    private JButton jbPapelera;
    private ImageIcon musicIcon = new ImageIcon("Imagen/ImagenesMenu/music.png");
    private ImageIcon papeleraIcon = new ImageIcon("Imagen/ImagenesMenu/eliminarCancion.png");
    public JPCanco(JButton jbCancion, String songNomText,String songInfoText,JButton jbPapelera){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        this.jbCancion = jbCancion;
        jbCancion.setIcon(musicIcon);
        jbCancion.setOpaque(false);
        jbCancion.setContentAreaFilled(false);
        jbCancion.setBorderPainted(false);

        JPMainView jpImageCanco = new JPMainView();
        jpImageCanco.setMaximumSize(new Dimension(195,180));
        jpImageCanco.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        jpImageCanco.add(jbCancion);

        this.jbPapelera = jbPapelera;
        jbPapelera.setIcon(papeleraIcon);
        jbPapelera.setOpaque(false);
        jbPapelera.setContentAreaFilled(false);
        jbPapelera.setBorderPainted(false);


        JPMainView extra1 = new JPMainView();
        extra1.setLayout(new FlowLayout());
        extra1.setMaximumSize(new Dimension(205,75));
        extra1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPMainView extra2 = new JPMainView();
        extra2.setLayout(new BoxLayout(extra2,BoxLayout.Y_AXIS));

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JLabel jlTitul = new JLColor(songNomText, ColorScheme.PRIMARY);
        JLabel jlInfo = new JLColor(songInfoText,ColorScheme.Secondary);



        extra2.add(jlTitul);
        extra2.add(jlInfo);

        extra1.add(extra2);
        extra1.add(jbPapelera);

        add(jpImageCanco);
        add(extra1);


    }

    /**
     * Getter que retornarà el ID de la canço assignat al ActionComand del botó
     * @return
     */
    public String getIDButton(){

        String[] string =  jbCancion.getActionCommand().split("-");

        return string[1];
    }

    /**
     * Funció que assignarà el ActionListener al botó referent a la canço
     * @param controller
     */
    public void registerController(ActionListener controller){

        this.jbCancion.addActionListener(controller);
        this.jbPapelera.addActionListener(controller);

    }

}
