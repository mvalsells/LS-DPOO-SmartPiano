package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.Key;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.sound.midi.*;
import javax.sound.midi.spi.MidiFileWriter;
import java.awt.event.*;

public class PianoController /*implements ActionListener, MouseListener, KeyListener*/ {

    private JPPiano jpPiano;
    private MidiChannel channel;

    public PianoController(JPPiano jpPiano) {
        this.jpPiano = jpPiano;
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel channels[] = synth.getChannels();
            //channel = channels[test.getChanel];
            channel = channels[0];

            for (int i = 0; i < insts.length; i++) {
                if (insts[i].toString()
                        .startsWith("Instrument MidiPiano")) {
                    channel.programChange(i);
                    break;
                }
            }
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }


   /* @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key2 = e.getKeyCode();

        //WHITE KEYS
        switch (key2){
            case KeyEvent.VK_A:
                channel.noteOn(48, 127);
                break;
            case KeyEvent.VK_B:
                channel.noteOn(50, 127);
                break;
            case  KeyEvent.VK_C:
                channel.noteOn(52, 127);
                break;
            case KeyEvent.VK_D:
                channel.noteOn(53, 127);
                break;
            case KeyEvent.VK_E:
                channel.noteOn(55, 127);
                break;
            case KeyEvent.VK_F:
                channel.noteOn(57, 127);
                break;
            case KeyEvent.VK_G:
                channel.noteOn(59, 127);
                break;
            case KeyEvent.VK_H:
                channel.noteOn(60, 127);
                break;
            case KeyEvent.VK_I:
                channel.noteOn(62, 127);
                break;
            case KeyEvent.VK_J:
                channel.noteOn(64, 127);
                break;
            case KeyEvent.VK_K:
                channel.noteOn(65, 127);
                break;
            case KeyEvent.VK_L:
                channel.noteOn(67, 127);
                break;
            case KeyEvent.VK_M:
                channel.noteOn(69, 127);
                break;
            case KeyEvent.VK_N:
                channel.noteOn(71, 127);
                break;
            case KeyEvent.VK_O:
                channel.noteOn(72, 127);
                break;
            case KeyEvent.VK_P:
                channel.noteOn(74, 127);
                break;
            case KeyEvent.VK_Q:
                channel.noteOn(76, 127);
                break;
            case KeyEvent.VK_R:
                channel.noteOn(77, 127);
                break;
            case KeyEvent.VK_S:
                channel.noteOn(79, 127);
                break;
            //BLACK KEYS
            case KeyEvent.VK_0:
                channel.noteOn(49, 127);
                break;
            case KeyEvent.VK_1:
                channel.noteOn(51, 127);
                break;
            case KeyEvent.VK_2:
                channel.noteOn(54, 127);
                break;
            case  KeyEvent.VK_3:
                channel.noteOn(56, 127);
                break;
            case KeyEvent.VK_4:
                channel.noteOn(58, 127);
                break;
            case KeyEvent.VK_5:
                channel.noteOn(61, 127);
                break;
            case KeyEvent.VK_6:
                channel.noteOn(63, 127);
                break;
            case KeyEvent.VK_7:
                channel.noteOn(66, 127);
                break;
            case KeyEvent.VK_8:
                channel.noteOn(68, 127);
                break;
            case KeyEvent.VK_9:
                channel.noteOn(70, 127);
                break;
            case KeyEvent.VK_SEMICOLON:
                channel.noteOn(73, 127);
                break;
            case KeyEvent.VK_COLON:
                    channel.noteOn(75, 127);
                    break;
            //case menor que:
            //channel.noteOn(75, 127);
            //break;
            case KeyEvent.VK_EQUALS:
                channel.noteOn(78, 127);
                break;







        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key2 = e.getKeyCode();

        //WHITE KEYS
        if(key2 == KeyEvent.VK_A){
            channel.noteOff(48, 127);
        }
        if(key2 == KeyEvent.VK_B){
            channel.noteOff(50, 127);
        }
        if(key2 == KeyEvent.VK_C){
            channel.noteOff(52, 127);
        }
        if(key2 == KeyEvent.VK_D){
            channel.noteOff(53, 127);
        }
        if(key2 == KeyEvent.VK_E){
            channel.noteOff(55, 127);
        }
        if(key2 == KeyEvent.VK_F){
            channel.noteOff(57, 127);
        }
        if(key2 == KeyEvent.VK_G){
            channel.noteOff(59, 127);
        }
        if(key2 == KeyEvent.VK_H){
            channel.noteOff(60, 127);
        }
        if(key2 == KeyEvent.VK_I){
            channel.noteOff(62, 127);
        }
        if(key2 == KeyEvent.VK_J){
            channel.noteOff(64, 127);
        }
        if(key2 == KeyEvent.VK_K){
            channel.noteOff(65, 127);
        }
        if(key2 == KeyEvent.VK_L){
            channel.noteOff(67, 127);
        }
        if(key2 == KeyEvent.VK_M){
            channel.noteOff(69, 127);
        }
        if(key2 == KeyEvent.VK_N){
            channel.noteOff(71, 127);
        }
        if(key2 == KeyEvent.VK_O){
            channel.noteOff(72, 127);
        }
        if(key2 == KeyEvent.VK_P){
            channel.noteOff(74, 127);
        }
        if(key2 == KeyEvent.VK_Q){
            channel.noteOff(76, 127);
        }
        if(key2 == KeyEvent.VK_R){
            channel.noteOff(77, 127);
        }
        if(key2 == KeyEvent.VK_S){
            channel.noteOff(79, 127);
        }

        //BLACK KEYS
        if(key2 == KeyEvent.VK_0){
            channel.noteOff(49, 127);
        }
        if(key2 == KeyEvent.VK_1){
            channel.noteOff(51, 127);
        }
        if(key2 == KeyEvent.VK_2){
            channel.noteOff(54, 127);
        }
        if(key2 == KeyEvent.VK_3){
            channel.noteOff(56, 127);
        }
        if(key2 == KeyEvent.VK_4){
            channel.noteOff(58, 127);
        }
        if(key2 == KeyEvent.VK_5){
            channel.noteOff(61, 127);
        }
        if(key2 == KeyEvent.VK_6){
            channel.noteOff(63, 127);
        }
        if(key2 == KeyEvent.VK_7){
            channel.noteOff(66, 127);
        }
        if(key2 == KeyEvent.VK_8){
            channel.noteOff(68, 127);
        }
        if(key2 == KeyEvent.VK_9){
            channel.noteOff(70, 127);
        }
        if(key2 == KeyEvent.VK_ALT+58){
            channel.noteOff(73, 127);
        }
        if(key2 == KeyEvent.VK_ALT+59){
            channel.noteOff(75, 127);
        }
        if(key2 == KeyEvent.VK_ALT+60){
            channel.noteOff(78, 127);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Key key = (Key) e.getSource();
        channel.noteOn(key.getNote(), 127);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOff(key.getNote(),127);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }*/

}
