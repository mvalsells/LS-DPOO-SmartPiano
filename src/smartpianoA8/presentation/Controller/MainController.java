package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.Key;
import smartpianoA8.presentation.views.MainFrame;

import javax.sound.midi.MidiChannel;
import java.awt.event.*;

public class MainController implements ActionListener , KeyListener,MouseListener {

    private MainFrame mainFrame;
    private MasterController masterController;
    MidiChannel midiChannel;

    public MainController(MainFrame mainFrame, MidiChannel midiChannel){

        this.mainFrame = mainFrame;
        this.midiChannel = midiChannel;

    }

    public void registerController(MasterController masterController){
        this.masterController =masterController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        Key key = (Key) e.getSource();
        midiChannel.noteOn(key.getNote(), 127);
    }

    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        midiChannel.noteOff(key.getNote(),127);
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key2 = e.getKeyCode();

        //WHITE KEYS
        if(key2 == KeyEvent.VK_A){
            midiChannel.noteOn(48, 127);
        }
        if(key2 == KeyEvent.VK_B){
            midiChannel.noteOn(50, 127);
        }
        if(key2 == KeyEvent.VK_C){
            midiChannel.noteOn(52, 127);
        }
        if(key2 == KeyEvent.VK_D){
            midiChannel.noteOn(53, 127);
        }
        if(key2 == KeyEvent.VK_E){
            midiChannel.noteOn(55, 127);
        }
        if(key2 == KeyEvent.VK_F){
            midiChannel.noteOn(57, 127);
        }
        if(key2 == KeyEvent.VK_G){
            midiChannel.noteOn(59, 127);
        }
        if(key2 == KeyEvent.VK_H){
            midiChannel.noteOn(60, 127);
        }
        if(key2 == KeyEvent.VK_I){
            midiChannel.noteOn(62, 127);
        }
        if(key2 == KeyEvent.VK_J){
            midiChannel.noteOn(64, 127);
        }
        if(key2 == KeyEvent.VK_K){
            midiChannel.noteOn(65, 127);
        }
        if(key2 == KeyEvent.VK_L){
            midiChannel.noteOn(67, 127);
        }
        if(key2 == KeyEvent.VK_M){
            midiChannel.noteOn(69, 127);
        }
        if(key2 == KeyEvent.VK_N){
            midiChannel.noteOn(71, 127);
        }
        if(key2 == KeyEvent.VK_O){
            midiChannel.noteOn(72, 127);
        }
        if(key2 == KeyEvent.VK_P){
            midiChannel.noteOn(74, 127);
        }
        if(key2 == KeyEvent.VK_Q){
            midiChannel.noteOn(76, 127);
        }
        if(key2 == KeyEvent.VK_R){
            midiChannel.noteOn(77, 127);
        }
        if(key2 == KeyEvent.VK_S){
            midiChannel.noteOn(79, 127);
        }

        //BLACK KEYS
        if(key2 == KeyEvent.VK_0){
            midiChannel.noteOn(49, 127);
        }
        if(key2 == KeyEvent.VK_1){
            midiChannel.noteOn(51, 127);
        }
        if(key2 == KeyEvent.VK_2){
            midiChannel.noteOn(54, 127);
        }
        if(key2 == KeyEvent.VK_3){
            midiChannel.noteOn(56, 127);
        }
        if(key2 == KeyEvent.VK_4){
            midiChannel.noteOn(58, 127);
        }
        if(key2 == KeyEvent.VK_5){
            midiChannel.noteOn(61, 127);
        }
        if(key2 == KeyEvent.VK_6){
            midiChannel.noteOn(63, 127);
        }
        if(key2 == KeyEvent.VK_7){
            midiChannel.noteOn(66, 127);
        }
        if(key2 == KeyEvent.VK_8){
            midiChannel.noteOn(68, 127);
        }
        if(key2 == KeyEvent.VK_9){
            midiChannel.noteOn(70, 127);
        }
        if(key2 == KeyEvent.VK_ALT+58){
            midiChannel.noteOn(73, 127);
        }
        if(key2 == KeyEvent.VK_ALT+59){
            midiChannel.noteOn(75, 127);
        }
        if(key2 == KeyEvent.VK_ALT+60){
            midiChannel.noteOn(78, 127);
        }




    }

    public void keyReleased(KeyEvent e) {
        /*Key key2 = (Key) e.getSource();
        channel.noteOff(key2.getNote());*7

         */
        int key2 = e.getKeyCode();

        //WHITE KEYS
        if(key2 == KeyEvent.VK_A){
            midiChannel.noteOff(48, 127);
        }
        if(key2 == KeyEvent.VK_B){
            midiChannel.noteOff(50, 127);
        }
        if(key2 == KeyEvent.VK_C){
            midiChannel.noteOff(52, 127);
        }
        if(key2 == KeyEvent.VK_D){
            midiChannel.noteOff(53, 127);
        }
        if(key2 == KeyEvent.VK_E){
            midiChannel.noteOff(55, 127);
        }
        if(key2 == KeyEvent.VK_F){
            midiChannel.noteOff(57, 127);
        }
        if(key2 == KeyEvent.VK_G){
            midiChannel.noteOff(59, 127);
        }
        if(key2 == KeyEvent.VK_H){
            midiChannel.noteOff(60, 127);
        }
        if(key2 == KeyEvent.VK_I){
            midiChannel.noteOff(62, 127);
        }
        if(key2 == KeyEvent.VK_J){
            midiChannel.noteOff(64, 127);
        }
        if(key2 == KeyEvent.VK_K){
            midiChannel.noteOff(65, 127);
        }
        if(key2 == KeyEvent.VK_L){
            midiChannel.noteOff(67, 127);
        }
        if(key2 == KeyEvent.VK_M){
            midiChannel.noteOff(69, 127);
        }
        if(key2 == KeyEvent.VK_N){
            midiChannel.noteOff(71, 127);
        }
        if(key2 == KeyEvent.VK_O){
            midiChannel.noteOff(72, 127);
        }
        if(key2 == KeyEvent.VK_P){
            midiChannel.noteOff(74, 127);
        }
        if(key2 == KeyEvent.VK_Q){
            midiChannel.noteOff(76, 127);
        }
        if(key2 == KeyEvent.VK_R){
            midiChannel.noteOff(77, 127);
        }
        if(key2 == KeyEvent.VK_S){
            midiChannel.noteOff(79, 127);
        }

        //BLACK KEYS
        if(key2 == KeyEvent.VK_0){
            midiChannel.noteOff(49, 127);
        }
        if(key2 == KeyEvent.VK_1){
            midiChannel.noteOff(51, 127);
        }
        if(key2 == KeyEvent.VK_2){
            midiChannel.noteOff(54, 127);
        }
        if(key2 == KeyEvent.VK_3){
            midiChannel.noteOff(56, 127);
        }
        if(key2 == KeyEvent.VK_4){
            midiChannel.noteOff(58, 127);
        }
        if(key2 == KeyEvent.VK_5){
            midiChannel.noteOff(61, 127);
        }
        if(key2 == KeyEvent.VK_6){
            midiChannel.noteOff(63, 127);
        }
        if(key2 == KeyEvent.VK_7){
            midiChannel.noteOff(66, 127);
        }
        if(key2 == KeyEvent.VK_8){
            midiChannel.noteOff(68, 127);
        }
        if(key2 == KeyEvent.VK_9){
            midiChannel.noteOff(70, 127);
        }
        if(key2 == KeyEvent.VK_ALT+58){
            midiChannel.noteOff(73, 127);
        }
        if(key2 == KeyEvent.VK_ALT+59){
            midiChannel.noteOff(75, 127);
        }
        if(key2 == KeyEvent.VK_ALT+60){
            midiChannel.noteOff(78, 127);
        }
    }

}
