package smartpianoA8.persistence;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Class to delete harddrive files
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */

public class FileDeletorImpl implements FileDeletor {

    public FileDeletorImpl() {}

    /**
     * Deletes all midi files from a specific user
     * @param user username of the user to delete the files
     */
    @Override
    public void removeUserSongsWhenDeletedUser(String user) {
        try {
            FileUtils.deleteDirectory(new File("resources/midiFiles/"+user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes the HashMap file from a specific user
     * @param user username of the user to delete the file
     */
    @Override
    public void removeHMFileByUser(String user) {
        File file = new File("resources/hmFiles/"+user+".txt");
        FileUtils.deleteQuietly(file);
    }

    /**
     * Removes a specific midi file related to a specific user
     * @param user username of which to delete the song
     * @param song name of the song of which to be remove
     */
    @Override
    public void removeSongFromUser(String user, String song) {
        File file = new File("resources/midiFiles/"+user+"/"+song+".mid");
        FileUtils.deleteQuietly(file);
    }

}
