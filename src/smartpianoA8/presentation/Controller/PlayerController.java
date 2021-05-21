package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPlayer;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerController implements Runnable, ActionListener {

    private ArrayList<Song> songsToBePlayed;
    private File songDirectory;
    private Sequence currentSequence;
    private Sequencer currentSequencer;
    //Runnable runnable;
    private int actionToDo = 5;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int currentSong = 0;
    private long whereWhenPaused = 0;
    JPPlayer jpPlayer;

    public PlayerController(JPPlayer jpPlayer) {
        this.jpPlayer = jpPlayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

        while (true) {

            // thread para no colapsar jeje
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (actionToDo) {
                case 0:
                    //Case 0 is being played
                    playThePlayer();
                    isPlaying = true;
                    break;
                case 1:
                    //Case 1 is pause playing
                    pauseThePlayer();
                    isPlaying = false;
                    break;
                case 2:
                    //Case 2 is go to next song
                    nextTheSong();
                    break;
                case 3:
                    //Case 3 is previous song
                    previousTheSong();
                    break;
                case 4:
                    //Case 4 is end the entire playlist
                    endThePlayer();
                    isPlaying = false;
                    break;
                default:
                    break;
            }

        }

        /*for (int i = 0; i < songsToBePlayed.size(); i++) {

            songDirectory = new File(songsToBePlayed.get(i).getDirectori());

            try {

                currentSequence = MidiSystem.getSequence(songDirectory);
                currentSequencer = MidiSystem.getSequencer();
                currentSequencer.open();
                currentSequencer.setSequence(currentSequence);

                //no hace falta modificar
                //runnable = () -> {

                    currentSequencer.start();



                    //---------------------

                    currentSequencer.start();

                    ActionListener updateListener = new ActionListener(){
                        public void actionPerformed(ActionEvent arg0) {
                            position = (int)currentSequencer.getMicrosecondPosition();
                            //jpPlayer.updateProgressBar((int)currentSequencer.getMicrosecondPosition());
                            //progress.setValue((int)currentSequencer.getMicrosecondPosition());
                        }
                    };

                    Timer timer = new Timer(40,updateListener);
                    timer.start();

                    while (currentSequencer.isRunning()) {}

                    timer.stop();
                    currentSequencer.stop();


                    //----------------



                    //final JProgressBar progress = new JProgressBar(0,(int)currentSequencer.getMicrosecondLength());
                    //ActionListener updateListener = new ActionListener(){
                    //    public void actionPerformed(ActionEvent arg0) {
                    //        progress.setValue((int)currentSequencer.getMicrosecondPosition());
                    //    }
                    //};
                    //Timer timer = new Timer(40,updateListener);
                    currentSequencer.start();
                    //timer.start();
                    while(currentSequencer.isRunning()){}
                    //JOptionPane.showMessageDialog(null, progress);
                    currentSequencer.close();
                    //timer.stop();

                //};
                //runnable.run();


                //SwingUtilities.invokeLater(runnable);

                /*currentSequencer.start();

                while(currentSequencer.isRunning()) {



                }

            } catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
                e.printStackTrace();
            }
        }*/

    }

    public void setSongsToBePlayed(ArrayList<Song> songsToBePlayed) {
        this.songsToBePlayed = songsToBePlayed;
    }

    public void setActionToDo(int actionToDo) {
        this.actionToDo = actionToDo;
    }

    private void playThePlayer() {

        while (isPlaying) {

            for(currentSong = 0; currentSong < songsToBePlayed.size(); currentSong++) {

                songDirectory = new File(songsToBePlayed.get(currentSong).getDirectori());

                //TODO SEND MILISECONDS TO DAO presentationcontroller.settaltaltal -> businessfacade.settaltaltal ..... actualitzarBBDDEstadistiques(LocalTime duradaSong, String username);

                try {
                    currentSequence = MidiSystem.getSequence(songDirectory);
                    currentSequencer = MidiSystem.getSequencer();
                    currentSequencer.open();
                    currentSequencer.setSequence(currentSequence);

                    if(isPaused == false) {
                        currentSequencer.start();
                    } else if (isPaused == true) {
                        currentSequencer.setMicrosecondPosition(whereWhenPaused);
                        currentSequencer.start();
                    }

                    isPaused = false;

                    jpPlayer.setTotalBarLong((int)currentSequencer.getMicrosecondLength());

                    //todo pasar duracion total de la cancion para

                    while (currentSequencer.isRunning()) {
                        jpPlayer.setCurrentStatus((int)currentSequencer.getMicrosecondPosition());
                        if(actionToDo == 2) {
                            //currentSong++;
                            currentSequencer.close();
                            actionToDo = 0;
                            break;
                        } else if (actionToDo == 3) {
                            //currentSong--;
                            currentSong = currentSong - 2;
                            currentSequencer.close();
                            actionToDo = 0;
                            break;
                        } else if (actionToDo == 1) {
                            whereWhenPaused = currentSequencer.getMicrosecondPosition();
                            currentSequencer.stop();
                            currentSong = currentSong - 1;
                            isPaused = true;
                            break;
                        } else if (actionToDo == 4) {
                            currentSequencer.close();
                            break;
                        }
                    }

                    currentSequencer.close();
                } catch (InvalidMidiDataException | MidiUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(new Frame(), "You don't have downloaded the song you're trying to play.\nDirectory: "+songDirectory+"\nYour program have to download it first with the HTMLScrapping feature!\nPlease, to solve this stay more time playing in the app.\nThe song will be downloaded according to the time stablished in your config file.", "FILE NOT FOUND", JOptionPane.ERROR_MESSAGE);
                    currentSong++;
                }




            }

        }

    }

    private void pauseThePlayer() {

        currentSequencer.stop();

    }

    private void nextTheSong() {

        currentSong++;
        currentSequencer.close();

    }

    private void previousTheSong() {

        currentSong--;
        currentSequencer.close();

    }

    private void endThePlayer() {

        currentSequencer.close();

    }

}
