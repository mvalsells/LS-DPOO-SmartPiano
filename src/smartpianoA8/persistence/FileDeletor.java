package smartpianoA8.persistence;

import smartpianoA8.business.entity.User;

public interface FileDeletor {
    /**
     * Interface to delete users data form file
     * @version 1.0
     * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
     */

    /**
     * Deletes all midi files from a specific user
     * @param user username of the user to delete the files
     */
    void removeUserSongsWhenDeletedUser(String user);
    /**
     * Removes the HashMap file from a specific user
     * @param user username of the user to delete the file
     */
    void removeHMFileByUser(String user);
    /**
     * Removes a specific midi file related to a specific user
     * @param user username of which to delete the song
     * @param song name of the song of which to be remove
     */
    void removeSongFromUser(String user, String song);

}
