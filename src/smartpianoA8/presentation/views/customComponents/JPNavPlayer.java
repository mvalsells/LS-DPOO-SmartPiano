package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPNavPlayer extends JPanel {

    private JButton playButton;
    private JButton pauseButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton stopButton;

    private static final ImageIcon playIcon = new ImageIcon("Imagen/ImagenesReproductor/playButton.png");
    private static final ImageIcon pauseIcon = new ImageIcon("Imagen/ImagenesReproductor/pauseButton.png");
    private static final ImageIcon previousIcon = new ImageIcon("Imagen/ImagenesReproductor/previousButton.png");
    private static final ImageIcon nextIcon = new ImageIcon("Imagen/ImagenesReproductor/nextButton.png");
    private static final ImageIcon stopIcon = new ImageIcon("Imagen/ImagenesReproductor/stopButton.png");

    public JPNavPlayer() {
        setLayout(new BorderLayout());
        setBackground(ColorScheme.NavBar_Background);

        JPanel barraInferior = new JPanel();
        barraInferior.setOpaque(false);
        barraInferior.setLayout(new BoxLayout(barraInferior, BoxLayout.X_AXIS));

        playButton = new JBNavPlayer(playIcon);
        pauseButton = new JBNavPlayer(pauseIcon);
        nextButton = new JBNavPlayer(nextIcon);
        previousButton = new JBNavPlayer(previousIcon);
        stopButton = new JBNavPlayer(stopIcon);

        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(playButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(pauseButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(nextButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(previousButton);
        barraInferior.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraInferior.add(stopButton);

        add(barraInferior,BorderLayout.NORTH);

    }

    public void registerController(ActionListener controller){
        playButton.addActionListener(controller);
        pauseButton.addActionListener(controller);
        nextButton.addActionListener(controller);
        previousButton.addActionListener(controller);
        stopButton.addActionListener(controller);
    }
}
