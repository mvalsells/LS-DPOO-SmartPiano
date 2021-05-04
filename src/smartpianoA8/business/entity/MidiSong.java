package smartpianoA8.business.entity;

import java.time.LocalDate;

public class MidiSong {

    private String songName;
    private String author;
    private String datePublished;
    private String midiAddress;

    public MidiSong() {

    }

    public MidiSong(String songName, String author, String datePublished, String midiAddress) {
        this.songName = songName;
        this.author = author;
        this.datePublished = datePublished;
        this.midiAddress = midiAddress;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MidiSong) {
            return this.songName.equals(((MidiSong) obj).songName);
        }else {
            return false;
        }
    }

    public String getSongName() {
        return songName;
    }
}
