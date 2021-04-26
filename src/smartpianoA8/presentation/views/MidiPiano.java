package smartpianoA8.presentation.views;

public class MidiPiano {

    /*final int OCTAVES = 4; // change as desired

    private WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private BlackKey[] blacks = new BlackKey[5 * OCTAVES];

    MidiChannel channel;



    public MidiPiano() {

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel channels[] = synth.getChannels();
            for (int i = 0; i < channels.length; i++) {
                if (channels[i] != null) {
                    channel = channels[i];
                    break;
                }
            }

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

    public void mousePressed(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOn(key.getNote(), 127);
    }

    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOff(key.getNote());
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public WhiteKey[] getWhites() {
        return whites;
    }

    public void setWhites(WhiteKey[] whites) {
        this.whites = whites;
    }

    public BlackKey[] getBlacks() {
        return blacks;
    }

    public void setBlacks(BlackKey[] blacks) {
        this.blacks = blacks;
    }*/

}
