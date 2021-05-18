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

/**
 * Classe pel controlador de la vista del piano
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 * @see MouseListener
 * @see KeyListener
 */
public class PianoController implements ActionListener, MouseListener, KeyListener {
    // ---- Inici Atributs ----

    private MidiWritter midiWritter;
    private PresentationController presentationController;
    private HashMap<Integer, Teclas> hmTeclas;
    private final static boolean DEFAULT_IS_RECORDING = false;
    private final static boolean TRUE_IS_RECORDING = true;
    boolean isRecording = DEFAULT_IS_RECORDING;
    private long endTime = 0;



    //Atributs a canviar
    MidiChannel midiChannel;
    //MidiWritterImpl midiWritter = new MidiWritterImpl();

    // ---- Fi Atributs ----
    // ---- Inici Constructor ----

    /**
     * Constructor amb el teclat
     * @param hmTeclas hashmap de tecles
     * @param midiWritter editor de midi
     */
    public PianoController(HashMap<Integer, Teclas> hmTeclas, MidiWritter midiWritter) {

        this.hmTeclas = hmTeclas;
        this.midiWritter = midiWritter;


        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel[] channels = synth.getChannels();
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

    /**
     * Mètode per registrar la classe a la presentació
     * @param presentationController presentaicó
     */
    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }


    /**
     * Mètode per intercanviar la finestra actual
     * @param e action event
     */
   @Override
    public void actionPerformed(ActionEvent e) {
       switch (e.getActionCommand()) {
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
           case JPPiano.PLAY_BUTTON:
               
               break;
           case JDPianoRegAdd.GuardarRec:

               endTime = System.currentTimeMillis();

               if(presentationController.pianoViewJDIsCheckBoxSelected()&&!(presentationController.pianoViewJDGetTextFieldString().equals(""))){
                   //Guardar record i ferla publica
                   //todo modify username and add song to database
                   midiWritter.saveRecording(presentationController.getCurrentUser().getUsername(), presentationController.pianoViewJDGetTextFieldString(), true, endTime);
                   //la funcio que retorna la string es: JFMainFrame.jdGetTextFieldString();
                   presentationController.pianoViewJDClose();
               }else if(!(presentationController.pianoViewJDGetTextFieldString().equals(""))){
                   //Guardar record i NO ferla publica
                   //todo modify username and add song to database
                   midiWritter.saveRecording(presentationController.getCurrentUser().getUsername(), presentationController.pianoViewJDGetTextFieldString(), false, endTime);
                   //la funcio que retorna la string es: JFMainFrame.jdGetTextFieldString();
                   presentationController.pianoViewJDClose();
               }else if(presentationController.pianoViewJDGetTextFieldString().equals("")){
                   presentationController.showWarningDialog("Introduzca un nombre a la grabacion");
               }
               break;
           case JDPianoRegAdd.DiscardRec:

               //Borrar recording(no guardar)
               presentationController.pianoViewJDClose();
               break;
           case JDPianoRegAdd.playRec:
               midiWritter.playRecording();
               break;
           case JDPianoRegAdd.pauseRec:
               midiWritter.stopPlayingRecording();
           /*case JPPiano.PLAY_BUTTON:
               presentationController*/
       }
    }

    /**
     * Mètode per quan s'ha clicat una tecla
     * @param e key event
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Mètode per quan es clica una tecla
     * @param e
     */
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

    /**
     * Mètode per quan es desactiva una tecla
     * @param e key event
     */
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

    /**
     * Mètode per quan es clica el ratolí
     * @param e mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Mètode per quan es manté el ratolí en una tecla
     * @param e mouse event
     */
    @Override
    public void mousePressed(MouseEvent e) {

        Key key = (Key) e.getSource();
        midiChannel.noteOn(key.getNote(), 127);
        if(midiWritter.getIsRecording()) {
            midiWritter.setOnMessage(key.getNote(), System.currentTimeMillis());
        }
    }

    /**
     * Mètode per quan es deixa de clicar amb el ratolí una tecla
     * @param e mouse event
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        midiChannel.noteOff(key.getNote(),127);
        if(midiWritter.getIsRecording()) {
            midiWritter.setOffMessage(key.getNote(), System.currentTimeMillis());
        }
    }

    /**
     * Mètode per quan s'acosta el ratolí
     * @param e mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Mètode per quan s'envà el ratolí
     * @param e mouse event
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }


}
