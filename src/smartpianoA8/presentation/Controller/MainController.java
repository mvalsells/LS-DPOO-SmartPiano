package smartpianoA8.presentation.Controller;

import smartpianoA8.persistence.MidiWritterImpl;
import smartpianoA8.presentation.views.*;
import smartpianoA8.presentation.views.customComponents.JDPianoRegAdd;
import smartpianoA8.presentation.views.customComponents.JPPiano;
import smartpianoA8.presentation.views.customComponents.Teclas;

import javax.sound.midi.MidiChannel;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class MainController implements ActionListener , KeyListener,MouseListener {

    private MainFrame mainFrame;
    private MasterController masterController;
    private final static boolean defaultIsRecording = false;
    private final static boolean trueIsRecording = true;
    boolean isRecording = defaultIsRecording;

    private final int valorMusicalDefault = 48;
    private final int codeTeclaDefault = KeyEvent.VK_A;

    MidiChannel midiChannel;
    MidiWritterImpl midiWritter = new MidiWritterImpl();

    private HashMap<Integer, Teclas> hmTeclas;

    public MainController(MainFrame mainFrame, MidiChannel midiChannel){

        this.mainFrame = mainFrame;
        this.midiChannel = midiChannel;

        this.hmTeclas = new HashMap<>();

        int valorMusical = valorMusicalDefault;
        int codeTecla = codeTeclaDefault;

        for(int i = 0; i<JPPiano.OCTAVES;i++){

            for(int j=0; j<12;j++){

                StringBuilder sb = new StringBuilder();

                sb.append(i);
                sb.append('_');
                sb.append(j);

                hmTeclas.put(codeTecla,new Teclas(/*sb.toString(),*/valorMusical));
                valorMusical++;
                codeTecla++;
                if(codeTecla==KeyEvent.VK_Z+1){
                    codeTecla = KeyEvent.VK_0;
                }
            }
        }
    }

    public void registerController(MasterController masterController){
        this.masterController =masterController;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case MainView.chgToPiano:

                mainFrame.changePanel(MainView.chgToPiano);
                break;
            case MainView.chgToProfile:
                mainFrame.changePanel(MainView.chgToProfile);
                break;
            case MainView.chgToSongs:
                mainFrame.changePanel(MainView.chgToSongs);
                break;
            case MainView.chgToFavs:
                mainFrame.changePanel(MainView.chgToFavs);
                break;
            case JPPiano.startRecording:
                //Christian aqui tu action listener
                if(!isRecording){
                    //StartRecording
                    mainFrame.jpSetRecordingPressedIcon();
                    isRecording = trueIsRecording;
                    System.out.println("IS RECORDING...");
                    midiWritter.startRecording();
                }else if (isRecording){
                    //StopRecording
                    mainFrame.jpSetRecordingUnpressedIcon();
                    System.out.println("IS NOT RECORDING...");
                    isRecording = defaultIsRecording;
                    midiWritter.endRecording();
                    mainFrame.jdRun();

                }else{ System.out.println("ERROR patata"); }
                break;
            case JDPianoRegAdd.GuardarRec:

                if(mainFrame.jdIsCheckBoxSelected()&&!(mainFrame.jdGetTextFieldString().equals(""))){
                    //Guardar record i ferla publica
                    //la funcio que retorna la string es: mainFrame.jdGetTextFieldString();
                    mainFrame.jdClose();
                }else if(!(mainFrame.jdGetTextFieldString().equals(""))){
                    //Guardar record i NO ferla publica
                    //la funcio que retorna la string es: mainFrame.jdGetTextFieldString();
                    mainFrame.jdClose();
                }else if(mainFrame.jdGetTextFieldString().equals("")){

                    JOptionPane.showMessageDialog(mainFrame,"Introduzca un nombre a la grabacion","Titulo no valido", JOptionPane.WARNING_MESSAGE);

                }
                break;
            case JDPianoRegAdd.DiscardRec:

                //Borrar recording(no guardar)
                mainFrame.jdClose();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //NO OBRIR NOMES PAU I CLARIMON
    @Override//NO OBRIR NOMES PAU I CLARIMON
    public void keyPressed(KeyEvent e) {
        int key2 = e.getKeyCode();
        System.out.println("patataKeyP");
        //WHITE KEYS

        if(!hmTeclas.get(key2).isPlaying()){
            midiChannel.noteOn(hmTeclas.get(key2).getNota(),127);
            hmTeclas.get(key2).setIsPlaying(Teclas.trueIsPlaying);
            if (midiWritter.getIsRecording()) {
                midiWritter.setOnMessage(hmTeclas.get(key2).getNota(), System.currentTimeMillis());
            }
        }

        /*switch (key2) {
            case KeyEvent.VK_ENTER:
                if(!hmTeclas.get(KeyEvent.VK_ENTER).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_ENTER).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_ENTER).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_ENTER).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_BACK_SPACE:
                if(!hmTeclas.get(KeyEvent.VK_BACK_SPACE).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_BACK_SPACE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_BACK_SPACE).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_BACK_SPACE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_TAB:
                if(!hmTeclas.get(KeyEvent.VK_TAB).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_TAB).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_TAB).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_TAB).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CANCEL:
                if(!hmTeclas.get(KeyEvent.VK_CANCEL).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_CANCEL).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CANCEL).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_CANCEL).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CLEAR:
                if(!hmTeclas.get(KeyEvent.VK_CLEAR).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_CLEAR).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CLEAR).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_CLEAR).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SHIFT:
                if(!hmTeclas.get(KeyEvent.VK_SHIFT).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_SHIFT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SHIFT).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_SHIFT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CONTROL:
                if(!hmTeclas.get(KeyEvent.VK_CONTROL).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_CONTROL).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CONTROL).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_CONTROL).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_ALT:
                if(!hmTeclas.get(KeyEvent.VK_ALT).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_ALT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_ALT).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_ALT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PAUSE:
                if(!hmTeclas.get(KeyEvent.VK_PAUSE).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_PAUSE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PAUSE).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_PAUSE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CAPS_LOCK:
                if(!hmTeclas.get(KeyEvent.VK_CAPS_LOCK).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_CAPS_LOCK).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CAPS_LOCK).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_CAPS_LOCK).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_ESCAPE:
                if(!hmTeclas.get(KeyEvent.VK_ESCAPE).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_ESCAPE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_ESCAPE).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_ESCAPE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SPACE:
                if(!hmTeclas.get(KeyEvent.VK_SPACE).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_SPACE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SPACE).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_SPACE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PAGE_UP:
                if(!hmTeclas.get(KeyEvent.VK_PAGE_UP).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_PAGE_UP).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PAGE_UP).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_PAGE_UP).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PAGE_DOWN:
                if(!hmTeclas.get(KeyEvent.VK_PAGE_DOWN).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_PAGE_DOWN).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PAGE_DOWN).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_PAGE_DOWN).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_END:
                if(!hmTeclas.get(KeyEvent.VK_END).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_END).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_END).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_END).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_HOME:
                if(!hmTeclas.get(KeyEvent.VK_HOME).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_HOME).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_HOME).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_HOME).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if(!hmTeclas.get(KeyEvent.VK_LEFT).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_LEFT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_LEFT).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_LEFT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_UP:
                if(!hmTeclas.get(KeyEvent.VK_UP).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_UP).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_UP).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_UP).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(!hmTeclas.get(KeyEvent.VK_RIGHT).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_RIGHT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_RIGHT).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_RIGHT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if(!hmTeclas.get(KeyEvent.VK_DOWN).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_DOWN).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_DOWN).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_DOWN).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_COMMA:
                if(!hmTeclas.get(KeyEvent.VK_COMMA).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_COMMA).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_COMMA).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_COMMA).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_MINUS:
                if(!hmTeclas.get(KeyEvent.VK_MINUS).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_MINUS).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_MINUS).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_MINUS).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PERIOD:
                if(!hmTeclas.get(KeyEvent.VK_PERIOD).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_PERIOD).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PERIOD).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_PERIOD).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SLASH:
                if(!hmTeclas.get(KeyEvent.VK_SLASH).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_SLASH).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SLASH).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_SLASH).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_0:
                if(!hmTeclas.get(KeyEvent.VK_0).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_0).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_0).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_0).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_1:
                if(!hmTeclas.get(KeyEvent.VK_1).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_1).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_1).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_1).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_2:
                if(!hmTeclas.get(KeyEvent.VK_2).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_2).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_2).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_2).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_3:
                if(!hmTeclas.get(KeyEvent.VK_3).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_3).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_3).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_3).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_4:
                if(!hmTeclas.get(KeyEvent.VK_4).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_4).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_4).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_4).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_5:
                if(!hmTeclas.get(KeyEvent.VK_5).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_5).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_5).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_5).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_6:
                if(!hmTeclas.get(KeyEvent.VK_6).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_6).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_6).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_6).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_7:
                if(!hmTeclas.get(KeyEvent.VK_7).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_7).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_7).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_7).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_8:
                if(!hmTeclas.get(KeyEvent.VK_8).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_8).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_8).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_8).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_9:
                if(!hmTeclas.get(KeyEvent.VK_9).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_9).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_9).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_9).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SEMICOLON:
                if(!hmTeclas.get(KeyEvent.VK_SEMICOLON).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_SEMICOLON).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SEMICOLON).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_SEMICOLON).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_EQUALS:
                if(!hmTeclas.get(KeyEvent.VK_EQUALS).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_EQUALS).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_EQUALS).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_EQUALS).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_A:
                if(!hmTeclas.get(KeyEvent.VK_A).isPlaying()) {
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_A).getNota(), 127);
                    hmTeclas.get(KeyEvent.VK_A).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_A).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_B:
                if(!hmTeclas.get(KeyEvent.VK_B).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_B).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_B).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_B).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_C:
                if(!hmTeclas.get(KeyEvent.VK_C).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_C).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_C).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_C).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_D:
                if(!hmTeclas.get(KeyEvent.VK_D).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_D).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_D).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_D).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_E:
                if(!hmTeclas.get(KeyEvent.VK_E).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_E).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_E).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_E).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_F:
                if(!hmTeclas.get(KeyEvent.VK_F).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_F).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_F).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_F).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_G:
                if(!hmTeclas.get(KeyEvent.VK_G).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_G).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_G).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_G).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_H:
                if(!hmTeclas.get(KeyEvent.VK_H).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_H).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_H).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_H).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_I:
                if(!hmTeclas.get(KeyEvent.VK_I).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_I).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_I).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_I).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_J:
                if(!hmTeclas.get(KeyEvent.VK_J).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_J).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_J).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_J).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_K:
                if(!hmTeclas.get(KeyEvent.VK_K).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_K).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_K).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_K).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_L:
                if(!hmTeclas.get(KeyEvent.VK_L).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_L).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_L).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_L).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_M:
                if(!hmTeclas.get(KeyEvent.VK_M).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_M).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_M).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_M).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_N:
                if(!hmTeclas.get(KeyEvent.VK_N).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_N).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_N).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_N).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_O:
                if(!hmTeclas.get(KeyEvent.VK_O).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_O).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_O).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_O).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_P:
                if(!hmTeclas.get(KeyEvent.VK_P).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_P).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_P).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_P).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_Q:
                if(!hmTeclas.get(KeyEvent.VK_Q).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_Q).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_Q).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_Q).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_R:
                if(!hmTeclas.get(KeyEvent.VK_R).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_R).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_R).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_R).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_S:
                if(!hmTeclas.get(KeyEvent.VK_S).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_S).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_S).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_S).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_T:
                if(!hmTeclas.get(KeyEvent.VK_T).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_T).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_T).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_T).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_U:
                if(!hmTeclas.get(KeyEvent.VK_U).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_U).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_U).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_U).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_V:
                if(!hmTeclas.get(KeyEvent.VK_V).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_V).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_V).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_V).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_W:
                if(!hmTeclas.get(KeyEvent.VK_W).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_W).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_W).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_W).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_X:
                if(!hmTeclas.get(KeyEvent.VK_X).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_X).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_X).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_X).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_Y:
                if(!hmTeclas.get(KeyEvent.VK_Y).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_Y).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_Y).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_Y).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_Z:
                if(!hmTeclas.get(KeyEvent.VK_Z).isPlaying()){
                    midiChannel.noteOn(hmTeclas.get(KeyEvent.VK_Z).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_Z).setIsPlaying(Teclas.trueIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOnMessage(hmTeclas.get(KeyEvent.VK_Z).getNota(), System.currentTimeMillis());
                    }
                }
                break;

        }*/

    }//NO OBRIR NOMES PAU I CLARIMON
    //NO OBRIR NOMES PAU I CLARIMON
    //NO OBRIR NOMES PAU I CLARIMON
    @Override//NO OBRIR NOMES PAU I CLARIMON
    public void keyReleased(KeyEvent e) {
        System.out.println("patataKeyR");
        int key2 = e.getKeyCode();

        if(hmTeclas.get(key2).isPlaying()){
            midiChannel.noteOff(hmTeclas.get(key2).getNota(),127);
            hmTeclas.get(key2).setIsPlaying(Teclas.defaultIsPlaying);
            if (midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(hmTeclas.get(key2).getNota(), System.currentTimeMillis());
            }
        }

        /*switch (key2) {
            case KeyEvent.VK_ENTER:
                if(hmTeclas.get(KeyEvent.VK_ENTER).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_ENTER).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_ENTER).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_ENTER).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_BACK_SPACE:
                if(hmTeclas.get(KeyEvent.VK_BACK_SPACE).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_BACK_SPACE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_BACK_SPACE).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_BACK_SPACE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_TAB:
                if(hmTeclas.get(KeyEvent.VK_TAB).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_TAB).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_TAB).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_TAB).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CANCEL:
                if(hmTeclas.get(KeyEvent.VK_CANCEL).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_CANCEL).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CANCEL).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_CANCEL).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CLEAR:
                if(hmTeclas.get(KeyEvent.VK_CLEAR).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_CLEAR).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CLEAR).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_CLEAR).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SHIFT:
                if(hmTeclas.get(KeyEvent.VK_SHIFT).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_SHIFT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SHIFT).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_SHIFT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CONTROL:
                if(hmTeclas.get(KeyEvent.VK_CONTROL).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_CONTROL).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CONTROL).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_CONTROL).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_ALT:
                if(hmTeclas.get(KeyEvent.VK_ALT).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_ALT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_ALT).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_ALT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PAUSE:
                if(hmTeclas.get(KeyEvent.VK_PAUSE).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_PAUSE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PAUSE).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_PAUSE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_CAPS_LOCK:
                if(hmTeclas.get(KeyEvent.VK_CAPS_LOCK).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_CAPS_LOCK).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_CAPS_LOCK).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_CAPS_LOCK).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_ESCAPE:
                if(hmTeclas.get(KeyEvent.VK_ESCAPE).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_ESCAPE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_ESCAPE).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_ESCAPE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SPACE:
                if(hmTeclas.get(KeyEvent.VK_SPACE).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_SPACE).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SPACE).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_SPACE).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PAGE_UP:
                if(hmTeclas.get(KeyEvent.VK_PAGE_UP).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_PAGE_UP).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PAGE_UP).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_PAGE_UP).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PAGE_DOWN:
                if(hmTeclas.get(KeyEvent.VK_PAGE_DOWN).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_PAGE_DOWN).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PAGE_DOWN).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_PAGE_DOWN).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_END:
                if(hmTeclas.get(KeyEvent.VK_END).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_END).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_END).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_END).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_HOME:
                if(hmTeclas.get(KeyEvent.VK_HOME).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_HOME).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_HOME).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_HOME).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if(hmTeclas.get(KeyEvent.VK_LEFT).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_LEFT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_LEFT).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_LEFT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_UP:
                if(hmTeclas.get(KeyEvent.VK_UP).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_UP).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_UP).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_UP).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(hmTeclas.get(KeyEvent.VK_RIGHT).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_RIGHT).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_RIGHT).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_RIGHT).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if(hmTeclas.get(KeyEvent.VK_DOWN).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_DOWN).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_DOWN).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_DOWN).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_COMMA:
                if(hmTeclas.get(KeyEvent.VK_COMMA).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_COMMA).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_COMMA).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_COMMA).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_MINUS:
                if(hmTeclas.get(KeyEvent.VK_MINUS).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_MINUS).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_MINUS).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_MINUS).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_PERIOD:
                if(hmTeclas.get(KeyEvent.VK_PERIOD).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_PERIOD).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_PERIOD).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_PERIOD).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SLASH:
                if(hmTeclas.get(KeyEvent.VK_SLASH).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_SLASH).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SLASH).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_SLASH).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_0:
                if(hmTeclas.get(KeyEvent.VK_0).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_0).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_0).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_0).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_1:
                if(hmTeclas.get(KeyEvent.VK_1).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_1).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_1).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_1).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_2:
                if(hmTeclas.get(KeyEvent.VK_2).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_2).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_2).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_2).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_3:
                if(hmTeclas.get(KeyEvent.VK_3).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_3).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_3).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_3).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_4:
                if(hmTeclas.get(KeyEvent.VK_4).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_4).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_4).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_4).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_5:
                if(hmTeclas.get(KeyEvent.VK_5).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_5).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_5).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_5).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_6:
                if(hmTeclas.get(KeyEvent.VK_6).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_6).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_6).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_6).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_7:
                if(hmTeclas.get(KeyEvent.VK_7).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_7).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_7).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_7).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_8:
                if(hmTeclas.get(KeyEvent.VK_8).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_8).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_8).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_8).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_9:
                if(hmTeclas.get(KeyEvent.VK_9).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_9).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_9).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_9).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_SEMICOLON:
                if(hmTeclas.get(KeyEvent.VK_SEMICOLON).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_SEMICOLON).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_SEMICOLON).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_SEMICOLON).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_EQUALS:
                if(hmTeclas.get(KeyEvent.VK_EQUALS).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_EQUALS).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_EQUALS).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_EQUALS).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_A:
                if(hmTeclas.get(KeyEvent.VK_A).isPlaying()) {
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_A).getNota(), 127);
                    hmTeclas.get(KeyEvent.VK_A).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_A).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_B:
                if(hmTeclas.get(KeyEvent.VK_B).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_B).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_B).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_B).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_C:
                if(hmTeclas.get(KeyEvent.VK_C).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_C).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_C).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_C).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_D:
                if(hmTeclas.get(KeyEvent.VK_D).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_D).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_D).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_D).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_E:
                if(hmTeclas.get(KeyEvent.VK_E).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_E).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_E).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_E).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_F:
                if(hmTeclas.get(KeyEvent.VK_F).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_F).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_F).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_F).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_G:
                if(hmTeclas.get(KeyEvent.VK_G).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_G).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_G).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_G).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_H:
                if(hmTeclas.get(KeyEvent.VK_H).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_H).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_H).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_H).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_I:
                if(hmTeclas.get(KeyEvent.VK_I).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_I).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_I).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_I).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_J:
                if(hmTeclas.get(KeyEvent.VK_J).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_J).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_J).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_J).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_K:
                if(hmTeclas.get(KeyEvent.VK_K).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_K).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_K).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_K).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_L:
                if(hmTeclas.get(KeyEvent.VK_L).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_L).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_L).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_L).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_M:
                if(hmTeclas.get(KeyEvent.VK_M).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_M).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_M).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_M).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_N:
                if(hmTeclas.get(KeyEvent.VK_N).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_N).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_N).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_N).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_O:
                if(hmTeclas.get(KeyEvent.VK_O).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_O).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_O).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_O).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_P:
                if(hmTeclas.get(KeyEvent.VK_P).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_P).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_P).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_P).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_Q:
                if(hmTeclas.get(KeyEvent.VK_Q).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_Q).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_Q).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_Q).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_R:
                if(hmTeclas.get(KeyEvent.VK_R).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_R).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_R).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_R).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_S:
                if(hmTeclas.get(KeyEvent.VK_S).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_S).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_S).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_S).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_T:
                if(hmTeclas.get(KeyEvent.VK_T).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_T).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_T).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_T).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_U:
                if(hmTeclas.get(KeyEvent.VK_U).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_U).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_U).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_U).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_V:
                if(hmTeclas.get(KeyEvent.VK_V).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_V).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_V).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_V).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_W:
                if(hmTeclas.get(KeyEvent.VK_W).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_W).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_W).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_W).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_X:
                if(hmTeclas.get(KeyEvent.VK_X).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_X).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_X).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_X).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_Y:
                if(hmTeclas.get(KeyEvent.VK_Y).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_Y).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_Y).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_Y).getNota(), System.currentTimeMillis());
                    }
                }
                break;
            case KeyEvent.VK_Z:
                if(hmTeclas.get(KeyEvent.VK_Z).isPlaying()){
                    midiChannel.noteOff(hmTeclas.get(KeyEvent.VK_Z).getNota(),127);
                    hmTeclas.get(KeyEvent.VK_Z).setIsPlaying(Teclas.defaultIsPlaying);
                    if (midiWritter.getIsRecording()) {
                        midiWritter.setOffMessage(hmTeclas.get(KeyEvent.VK_Z).getNota(), System.currentTimeMillis());
                    }
                }
                break;
        }*/

    }//NO OBRIR NOMES PAU I CLARIMON
    //NO OBRIR NOMES PAU I CLARIMON
    //NO OBRIR NOMES PAU I CLARIMON
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("patataMouseP");
        Key key = (Key) e.getSource();
        midiChannel.noteOn(key.getNote(), 127);
        if(midiWritter.getIsRecording()) {
            midiWritter.setOnMessage(key.getNote(), System.currentTimeMillis());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("patataMouseR");
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
