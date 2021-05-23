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
/**
Classe que carrega el reproductor inferior per les playlists
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 * @see Runnable
 */
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
    private boolean isClosed = false;
    JPPlayer jpPlayer;
    private int countError = 1;
    private PresentationController presentationController;

    /**
     * Constructor que només carrega el panell de fons
     * @param jpPlayer panell de fons
     */
    public PlayerController(JPPlayer jpPlayer) {
        this.jpPlayer = jpPlayer;
    }

    /**
     * No s'implemtna aquest mètode
     * @param e --
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Mètode run del thread
     */
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
                    countError = 1;
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

    }

    /**
     * Setter que modifica la canción a ser reproducida
     * @param songsToBePlayed
     */
    public void setSongsToBePlayed(ArrayList<Song> songsToBePlayed) {
        this.songsToBePlayed = songsToBePlayed;
    }

    /**
     * Setter que modifica la acción a hacer
     * @param actionToDo
     */
    public void setActionToDo(int actionToDo) {
        this.actionToDo = actionToDo;
        if(actionToDo == 4) {
            isClosed = true;
        }
    }

    /**
     * Mètode per executar el PLAY del botó
     */
    private void playThePlayer() {

        isClosed = false;
        while (isPlaying) {

            for(currentSong = 0; currentSong < songsToBePlayed.size(); currentSong++) {

                songDirectory = new File(songsToBePlayed.get(currentSong).getDirectori());

                try {
                    if(!isClosed) {
                        currentSequence = MidiSystem.getSequence(songDirectory);
                        currentSequencer = MidiSystem.getSequencer();
                        currentSequencer.open();
                        currentSequencer.setSequence(currentSequence);

                        presentationController.actualitzarEstadistiques(currentSequence.getMicrosecondLength());
                        presentationController.updateStatsView();
                        presentationController.songPlayed(songsToBePlayed.get(currentSong).getIdSong());

                        if(isPaused == false) {
                            currentSequencer.start();
                        } else if (isPaused == true) {
                            currentSequencer.setMicrosecondPosition(whereWhenPaused);
                            currentSequencer.start();
                        }

                        isPaused = false;

                        jpPlayer.setTotalBarLong((int)currentSequencer.getMicrosecondLength());

                        while (currentSequencer.isRunning()) {
                            jpPlayer.setCurrentStatus((int)currentSequencer.getMicrosecondPosition());
                            if(actionToDo == 2) {
                                //currentSong++;
                                currentSequencer.close();
                                actionToDo = 0;
                                break;
                            } else if (actionToDo == 3) {
                                //currentSong--;
                                if(currentSong == 0) {
                                    currentSong = songsToBePlayed.size()-1;
                                }else {
                                    currentSong = currentSong - 2;
                                    currentSequencer.close();
                                }
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
                                isClosed = true;
                                isPlaying = false;
                                break;
                            }
                        }

                        currentSequencer.close();
                    }


                } catch (FileNotFoundException e) {
                    //if(!isClosed) {
                    JOptionPane.showMessageDialog(new Frame(), "You don't have downloaded the song you're trying to play.\nDirectory: " + songDirectory + "\nYour program have to download it first with the HTMLScrapping feature if it's a program song.\nPlease, to solve this stay more time playing in the app. The song will be downloaded according to the time stablished in your config file.\nIf it's a user song and you don't have the midi file you can't play it.\n\nThe player will auto close in 4 failed attempts. Current:"+countError, "FILE NOT FOUND", JOptionPane.ERROR_MESSAGE);
                    //isPlaying = false;
                    countError = countError + 1;
                    if(countError == 4) {
                        actionToDo = 4;
                        isClosed = true;
                        isPlaying = false;
                        //currentSequencer.close();
                    }
                    break;

                } catch (InvalidMidiDataException | MidiUnavailableException | IOException e) {
                    e.printStackTrace();
                }


            }

        }

    }

    /**
     * Mètode per pausar el reproductor
     */
    private void pauseThePlayer() {

    }

    /**
     * Mètode per accedir a la seguent cançó
     */
    private void nextTheSong() {

        currentSong++;

    }

    /**
     * Mètode per recular de cançó
     */
    private void previousTheSong() {

        currentSong--;

    }

    /**
     * Mètode per sortir del reproductor
     */
    private void endThePlayer() {


    }

    /**
     * Método para registrar el controlador
     * @param presentationController controlador de la presentació
     */
    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

}
