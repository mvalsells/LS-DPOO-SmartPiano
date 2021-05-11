package smartpianoA8.presentation.Controller;

import smartpianoA8.persistence.MidiWritter;
import smartpianoA8.persistence.MidiWritterImpl;
import smartpianoA8.presentation.views.*;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.sound.midi.MidiChannel;
import java.awt.event.*;

public class MainController implements ActionListener , KeyListener,MouseListener {

    private MainFrame mainFrame;
    private MasterController masterController;
    private final static boolean defaultIsRecording = false;
    private final static boolean trueIsRecording = true;
    boolean isRecording = defaultIsRecording;

    MidiChannel midiChannel;
    MidiWritterImpl midiWritter = new MidiWritterImpl();

    public MainController(MainFrame mainFrame, MidiChannel midiChannel){

        this.mainFrame = mainFrame;
        this.midiChannel = midiChannel;

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
                }else{ System.out.println("ERROR patata"); }

                break;
        }

    }

    private void startRecording() {
        midiWritter.startRecording();
        System.out.println("Recording...");
    }

    private void endRecording() {
        midiWritter.endRecording();
        System.out.println("EEENNDD Recording...");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key2 = e.getKeyCode();
        System.out.println("patataKeyP");
        //WHITE KEYS
        switch (key2){
            case KeyEvent.VK_A:
                midiChannel.noteOn(48, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(48, System.currentTimeMillis());
                }
                break;
            case KeyEvent.VK_B:
                midiChannel.noteOn(50, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(50, System.currentTimeMillis());
                }
                break;
            case  KeyEvent.VK_C:
                midiChannel.noteOn(52, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(52, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_D:
                midiChannel.noteOn(53, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(53, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_E:
                midiChannel.noteOn(55, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(55, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_F:
                midiChannel.noteOn(57, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(57, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_G:
                midiChannel.noteOn(59, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(59, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_H:
                midiChannel.noteOn(60, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(60, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_I:
                midiChannel.noteOn(62, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(62, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_J:
                midiChannel.noteOn(64, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(64, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_K:
                midiChannel.noteOn(65, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(65, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_L:
                midiChannel.noteOn(67, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(67, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_M:
                midiChannel.noteOn(69, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(69, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_N:
                midiChannel.noteOn(71, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(71, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_O:
                midiChannel.noteOn(72, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(72, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_P:
                midiChannel.noteOn(74, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(74, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_Q:
                midiChannel.noteOn(76, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(76, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_R:
                midiChannel.noteOn(77, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(77, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_S:
                midiChannel.noteOn(79, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(79, System.currentTimeMillis());
                }                break;
            //BLACK KEYS
            case KeyEvent.VK_0:
                midiChannel.noteOn(49, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(49, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_1:
                midiChannel.noteOn(51, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(51, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_2:
                midiChannel.noteOn(54, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(54, System.currentTimeMillis());
                }                break;
            case  KeyEvent.VK_3:
                midiChannel.noteOn(56, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(56, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_4:
                midiChannel.noteOn(58, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(58, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_5:
                midiChannel.noteOn(61, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(61, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_6:
                midiChannel.noteOn(63, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(63, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_7:
                midiChannel.noteOn(66, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(66, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_8:
                midiChannel.noteOn(68, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(68, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_9:
                midiChannel.noteOn(70, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(70, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_SEMICOLON:
                midiChannel.noteOn(73, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(73, System.currentTimeMillis());
                }                break;
            case KeyEvent.VK_COLON:
                midiChannel.noteOn(75, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(75, System.currentTimeMillis());
                }                break;
            /*case menor que:
            channel.noteOn(75, 127);
            break;*/
            case KeyEvent.VK_EQUALS:
                midiChannel.noteOn(78, 127);
                if(midiWritter.getIsRecording()) {
                    midiWritter.setOnMessage(78, System.currentTimeMillis());
                }                break;







        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("patataKeyR");
        int key2 = e.getKeyCode();

        //WHITE KEYS
        if(key2 == KeyEvent.VK_A){
            midiChannel.noteOff(48, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(48, System.currentTimeMillis());
            }
        }
        if(key2 == KeyEvent.VK_B){
            midiChannel.noteOff(50, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(50, System.currentTimeMillis());
            }
        }
        if(key2 == KeyEvent.VK_C){
            midiChannel.noteOff(52, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(52, System.currentTimeMillis());
            }
        }
        if(key2 == KeyEvent.VK_D){
            midiChannel.noteOff(53, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(53, System.currentTimeMillis());
            }
        }

        if(key2 == KeyEvent.VK_E){
            midiChannel.noteOff(55, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(55, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_F){
            midiChannel.noteOff(57, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(57, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_G){
            midiChannel.noteOff(59, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(59, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_H){
            midiChannel.noteOff(60, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(60, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_I){
            midiChannel.noteOff(62, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(62, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_J){
            midiChannel.noteOff(64, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(64, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_K){
            midiChannel.noteOff(65, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(65, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_L){
            midiChannel.noteOff(67, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(67, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_M){
            midiChannel.noteOff(69, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(69, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_N){
            midiChannel.noteOff(71, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(71, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_O){
            midiChannel.noteOff(72, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(72, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_P){
            midiChannel.noteOff(74, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(74, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_Q){
            midiChannel.noteOff(76, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(76, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_R){
            midiChannel.noteOff(77, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(77, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_S){
            midiChannel.noteOff(79, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(79, System.currentTimeMillis());
            }        }

        //BLACK KEYS
        if(key2 == KeyEvent.VK_0){
            midiChannel.noteOff(49, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(49, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_1){
            midiChannel.noteOff(51, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(51, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_2){
            midiChannel.noteOff(54, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(54, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_3){
            midiChannel.noteOff(56, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(56, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_4){
            midiChannel.noteOff(58, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(58, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_5){
            midiChannel.noteOff(61, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(61, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_6){
            midiChannel.noteOff(63, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(63, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_7){
            midiChannel.noteOff(66, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(66, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_8){
            midiChannel.noteOff(68, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(68, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_9){
            midiChannel.noteOff(70, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(70, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_ALT+58){
            midiChannel.noteOff(73, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(73, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_ALT+59){
            midiChannel.noteOff(75, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(75, System.currentTimeMillis());
            }        }
        if(key2 == KeyEvent.VK_ALT+60){
            midiChannel.noteOff(78, 127);
            if(midiWritter.getIsRecording()) {
                midiWritter.setOffMessage(78, System.currentTimeMillis());
            }        }

    }

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
