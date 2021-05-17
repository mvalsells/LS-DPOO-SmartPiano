package smartpianoA8.persistence;

/**
 * Interficie per la creació de cançons MIDI
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface MidiWritter {

    public void startRecording();
    public void endRecording();
    public boolean getIsRecording();
    public void setOnMessage(int key, long startedNote);
    public void setOffMessage(int key, long endedNote);
    public void saveRecording(String userName, String songName, boolean isPublic, long totalTimeInMilis);
    public void stopPlayingRecording();
    public void playRecording();

}
