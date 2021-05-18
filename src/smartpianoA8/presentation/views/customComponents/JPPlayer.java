package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPPlayer extends JPanel {

    private JButton playButton;
    private JButton pauseButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton stopButton;
    private JPProgressBar progressBar;

    private static final ImageIcon playIcon = new ImageIcon("Imagen/ImagenesReproductor/playButton2.png");
    private static final ImageIcon pauseIcon = new ImageIcon("Imagen/ImagenesReproductor/pauseButton2.png");
    private static final ImageIcon previousIcon = new ImageIcon("Imagen/ImagenesReproductor/previousButton2.png");
    private static final ImageIcon nextIcon = new ImageIcon("Imagen/ImagenesReproductor/nextButton2.png");
    private static final ImageIcon stopIcon = new ImageIcon("Imagen/ImagenesReproductor/stopButton2.png");

    public JPPlayer() {
        setLayout(new BorderLayout());
        setBackground(ColorScheme.NavBar_Background);


        JPanel generalBorder = new JPanel();
        generalBorder.setOpaque(false);
        generalBorder.setLayout(new BoxLayout(generalBorder, BoxLayout.Y_AXIS));


        JPanel barraInferior = new JPanel();
        barraInferior.setOpaque(false);
        barraInferior.setLayout(new BoxLayout(barraInferior, BoxLayout.X_AXIS));

        JPanel barraSubInferior = new JPanel();
        barraSubInferior.setOpaque(false);
        barraSubInferior.setLayout(new BoxLayout(barraSubInferior, BoxLayout.X_AXIS));

        playButton = new JBPlayer(playIcon);
        pauseButton = new JBPlayer(pauseIcon);
        nextButton = new JBPlayer(nextIcon);
        previousButton = new JBPlayer(previousIcon);
        stopButton = new JBPlayer(stopIcon);


        progressBar = new JPProgressBar();

        //progressBar.setBackground(Color.GRAY);
        //progressBar.setForeground(Color.PINK);
        progressBar.setValue(80);

        barraSubInferior.add(progressBar);

        barraInferior.add(previousButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(stopButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(playButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(pauseButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(nextButton);

        generalBorder.add(Box.createVerticalStrut(4));
        generalBorder.add(barraSubInferior);
        generalBorder.add(barraInferior);

        add(generalBorder, BorderLayout.CENTER);

    }

    public void registerController(ActionListener controller){
        playButton.addActionListener(controller);
        pauseButton.addActionListener(controller);
        nextButton.addActionListener(controller);
        previousButton.addActionListener(controller);
        stopButton.addActionListener(controller);
        progressBar.addAncestorListener((AncestorListener) controller);
    }
}
