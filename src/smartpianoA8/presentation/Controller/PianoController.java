package smartpianoA8.presentation.Controller;

import smartpianoA8.persistence.MidiWritter;
import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.customComponents.JDPianoRegAdd;
import smartpianoA8.presentation.views.customComponents.JPPiano;
import smartpianoA8.presentation.views.customComponents.Key;
import smartpianoA8.presentation.views.customComponents.Teclas;

import javax.sound.midi.*;
import java.awt.event.*;
import java.util.HashMap;

public class PianoController implements ActionListener, MouseListener, KeyListener {
    // ---- Inici Atributs ----

    private MidiWritter midiWritter;
    private PresentationController presentationController;
    private HashMap<Integer, Teclas> hmTeclas;
    private final static boolean DEFAULT_IS_RECORDING = false;
    private final static boolean TRUE_IS_RECORDING = true;
    boolean isRecording = DEFAULT_IS_RECORDING;

    //Atributs a canviar
    MidiChannel midiChannel;
    //MidiWritterImpl midiWritter = new MidiWritterImpl();

    // ---- Fi Atributs ----
    // ---- Inici Constructor ----
    public PianoController(HashMap<Integer, Teclas> hmTeclas, MidiWritter midiWritter) {


        this.hmTeclas = hmTeclas;
        this.midiWritter = midiWritter;


        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel channels[] = synth.getChannels();
            //channel = channels[test.getChanel];
            midiChannel = channels[0];
            /*for (int i = 0; i < channels.length; i++) {
                if (channels[i] != null) {
                    channel = channels[i];
                    break;
                }
            }*/
            for (int i = 0; i < insts.length; i++) {
                if (insts[i].toString()
                        .startsWith("Instrument MidiPiano")) {
                    midiChannel.programChange(i);
                    break;
                }
            }
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }




   @Override
    public void actionPerformed(ActionEvent e) {
       switch (e.getActionCommand()) {
           //NavBar
           case JFMainFrame.SONGS:
               presentationController.changeView(JFMainFrame.SONGS);
               break;
           case JFMainFrame.FAVS:
               presentationController.changeView(JFMainFrame.FAVS);
               break;
           case JFMainFrame.PIANO:
               presentationController.changeView(JFMainFrame.PIANO);
               break;
           case JFMainFrame.PROFILE:
               presentationController.changeView(JFMainFrame.PROFILE);
               break;
               //Piano View
           case JPPiano.START_RECORDING:
               //Christian aqui tu action listener
               if(!isRecording){
                   //StartRecording
                   presentationController.pianoViewSetRecordingPressedIcon();
                   isRecording = TRUE_IS_RECORDING;
                   System.out.println("IS RECORDING...");
                   midiWritter.startRecording();
               }else if (isRecording){
                   //StopRecording
                   presentationController.pianoViewSetRecordingUnpressedIcon();
                   System.out.println("IS NOT RECORDING...");
                   isRecording = DEFAULT_IS_RECORDING;
                   midiWritter.endRecording();
                   presentationController.pianoViewJDRun();

               }else{ System.out.println("ERROR patata"); }
               break;
           case JDPianoRegAdd.GuardarRec:

               if(presentationController.pianoViewJDIsCheckBoxSelected()&&!(presentationController.pianoViewJDGetTextFieldString().equals(""))){
                   //Guardar record i ferla publica
                   //todo modify username and add song to database
                   midiWritter.saveRecording("pepito", presentationController.pianoViewJDGetTextFieldString());
                   //todo modify stop
                   midiWritter.stopPlayingRecording();
                   //la funcio que retorna la string es: JFMainFrame.jdGetTextFieldString();
                   presentationController.pianoViewJDClose();
               }else if(!(presentationController.pianoViewJDGetTextFieldString().equals(""))){
                   //Guardar record i NO ferla publica
                   //todo modify username and add song to database
                   midiWritter.saveRecording("pepito", presentationController.pianoViewJDGetTextFieldString());
                   //todo modify stop
                   midiWritter.stopPlayingRecording();
                   //la funcio que retorna la string es: JFMainFrame.jdGetTextFieldString();
                   presentationController.pianoViewJDClose();
               }else if(presentationController.pianoViewJDGetTextFieldString().equals("")){

                   //todo remove play
                   midiWritter.playRecording();
                   presentationController.showWarningDialog("Introduzca un nombre a la grabacion");
               }
               break;
           case JDPianoRegAdd.DiscardRec:

               //Borrar recording(no guardar)
               presentationController.pianoViewJDClose();
               break;
           /*case JPPiano.PLAY_BUTTON:
               presentationController*/
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        int key2 = e.getKeyCode();

        try {
            if (!hmTeclas.get(key2).isPlaying()) {
                midiChannel.noteOn(hmTeclas.get(key2).getNota(), 127);
                hmTeclas.get(key2).setIsPlaying(Teclas.trueIsPlaying);
                if (midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(hmTeclas.get(key2).getNota(), System.currentTimeMillis());
                }
            }
        }catch (NullPointerException epa){
            System.err.println("PATATA OUT OF BOUNDS");
        }



    }


    public void keyReleased(KeyEvent e) {
        int key2 = e.getKeyCode();

        try {
            if(hmTeclas.get(key2).isPlaying()){
                midiChannel.noteOff(hmTeclas.get(key2).getNota(),127);
                hmTeclas.get(key2).setIsPlaying(Teclas.defaultIsPlaying);
                if (midiWritter.getIsRecording()) {
                    midiWritter.setOffMessage(hmTeclas.get(key2).getNota(), System.currentTimeMillis());
                }
            }
        }catch (NullPointerException epa){
            System.err.println("PATATA OUT OF BOUNDS");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Key key = (Key) e.getSource();
        midiChannel.noteOn(key.getNote(), 127);
        if(midiWritter.getIsRecording()) {
            midiWritter.setOnMessage(key.getNote(), System.currentTimeMillis());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        midiChannel.noteOff(key.getNote(),127);
        if(midiWritter.getIsRecording()) {
            midiWritter.setOffMessage(key.getNote(), System.currentTimeMillis());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
