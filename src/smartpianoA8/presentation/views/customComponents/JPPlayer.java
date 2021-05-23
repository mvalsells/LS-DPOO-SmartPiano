package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.customComponents.profile.JPProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Esta clase se encarga de contener y crear toda la vista asociada al apartado de la opción de reproducir la música.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JPPlayer extends JPanel {

    int totalBarLong = 0;

    private JButton playButton;
    private JButton pauseButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton stopButton;
    private JButton uploadButton;

    private JComboBox<String> jComboBox;

    private JPProgressBar progressBar;

    private static final ImageIcon playIcon = new ImageIcon("Imagen/ImagenesReproductor/playButton2.png");
    private static final ImageIcon pauseIcon = new ImageIcon("Imagen/ImagenesReproductor/pauseButton2.png");
    private static final ImageIcon previousIcon = new ImageIcon("Imagen/ImagenesReproductor/previousButton2.png");
    private static final ImageIcon nextIcon = new ImageIcon("Imagen/ImagenesReproductor/nextButton2.png");
    private static final ImageIcon stopIcon = new ImageIcon("Imagen/ImagenesReproductor/stopButton2.png");
    private static final ImageIcon uploadIcon = new ImageIcon("Imagen/ImagenesReproductor/uploadButton.png");

    public static final String PLAY_BUTTON = "PLAY";
    public static final String PAUSE_BUTTON = "PAUSE";
    public static final String NEXT_BUTTON = "NEXT";
    public static final String PREVIOUS_BUTTON = "PREVIOUS";
    public static final String STOP_BUTTON = "STOP";
    public static final String UPLOAD_BUTTON = "UPLOAD";

    /**
     * Constructor de la clase el cual contiene los tipos para crear las vistas.
     */
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

        JPanel barraSubSelector = new JPanel();
        barraSubSelector.setOpaque(false);
        barraSubSelector.setLayout(new BoxLayout(barraSubSelector, BoxLayout.LINE_AXIS));

        playButton = new JBPlayer(playIcon);
        playButton.setActionCommand(PLAY_BUTTON);
        pauseButton = new JBPlayer(pauseIcon);
        pauseButton.setActionCommand(PAUSE_BUTTON);
        nextButton = new JBPlayer(nextIcon);
        nextButton.setActionCommand(NEXT_BUTTON);
        previousButton = new JBPlayer(previousIcon);
        previousButton.setActionCommand(PREVIOUS_BUTTON);
        stopButton = new JBPlayer(stopIcon);
        stopButton.setActionCommand(STOP_BUTTON);
        uploadButton = new JBPlayer(uploadIcon);
        uploadButton.setActionCommand(UPLOAD_BUTTON);

        jComboBox = new JComboBox<>();

        //jComboBox.addItem("If you want to play your playlist you must select it before and update pressing the button ---->");

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

        barraSubSelector.add(jComboBox);
        barraSubSelector.add(Box.createHorizontalStrut(BordersView.NavPlayer_Space));
        barraSubSelector.add(uploadButton);

        generalBorder.add(Box.createVerticalStrut(4));

        generalBorder.add(barraSubSelector);
        generalBorder.add(barraSubInferior);
        generalBorder.add(barraInferior);
        generalBorder.add(Box.createVerticalStrut(8));



        add(generalBorder, BorderLayout.CENTER);

    }//Cierre del constructor

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller Parámetro ascoiado al ActionListener
     */
    public void registerController(ActionListener controller){
        playButton.addActionListener(controller);
        pauseButton.addActionListener(controller);
        nextButton.addActionListener(controller);
        previousButton.addActionListener(controller);
        stopButton.addActionListener(controller);
        uploadButton.addActionListener(controller);
    }//Cierre del método

    /**
     * Método que envia el estado actual para actualizar la progres bar
     * @param status El estado actual para actualizar la progres bar.
     */
    public void setCurrentStatus(int status) {

        int status2 = status / 1000;
        status2 = status2 / 1000;

        //System.out.println("Total: "+totalBarLong);
        //System.out.println("Current: " +status2);

        progressBar.setValue((status2*100)/totalBarLong);


        //progressBar.revalidate();
        //progressBar.repaint();
        //pasar status y maximo y hacer regla de tres
    }//Cierre del método

    /**
     * Método que envia el nombre de la playlist.
     * @param playlistsNames nombre de la playlist.
     */
    public void setPlaylistsNames(ArrayList<String> playlistsNames) {
        //this.playlistsNames = playlistsNames;

        jComboBox.removeAllItems();


        jComboBox.addItem("If you want to play your playlist you must select it before and update pressing the button ---->");
        try {
            for(int i = 0; i < playlistsNames.size(); i++) {
                jComboBox.addItem(playlistsNames.get(i));
            }
        } catch (NullPointerException er) {
            System.err.println("NO SONGS LOADED");
        }

        jComboBox.revalidate();
        jComboBox.repaint();

    }//Cierre del método

    /**
     * Método que añade un item cuando el action event es pulsado.
     * @param e añade un item cuando el action event es pulsado.
     */
    public void actionPerformed(ActionEvent e) {

        jComboBox.addItem("ay");

    }//Cierre del método

    /**
     * Método que envia la longitud total de la barra.
     * @param totalBarLong longitud total de la barra.
     */
    public void setTotalBarLong(int totalBarLong) {
        this.totalBarLong = totalBarLong / 1000;
        this.totalBarLong = this.totalBarLong / 1000;
    }//Cierre del método

    /**
     * Método que recibe que comboBox ha sido seleccionado.
     * @return Devuelve el nombre del item selecionado.
     */
    public String getJComboBoxStringSelected() {
        return Objects.requireNonNull(jComboBox.getSelectedItem()).toString();
    }//Cierre del método
}//Cierre de la clase
