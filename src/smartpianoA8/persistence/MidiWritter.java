package smartpianoA8.persistence;

public interface MidiWritter {

    public void startRecording();
    public void endRecording();
    public boolean getIsRecording();
    public void setOnMessage(int key, long startedNote);
    public void setOffMessage(int key, long endedNote);
    public void saveRecording(String userName, String songName);
    public void stopPlayingRecording();
    public void playRecording();

}
