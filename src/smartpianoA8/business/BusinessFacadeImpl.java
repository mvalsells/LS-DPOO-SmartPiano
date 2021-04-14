package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

public class BusinessFacadeImpl implements BusinessFacade {


    @Override
    public void addSong(String nom, String autor, String duracio, String time, String directori, Boolean isPublic, String nomUsuari) {

    }

    @Override
    public void removeSong(Song song) {

    }

    @Override
    public boolean createUser(String userName, String email, String password, String type) {

        return false;
    }

    @Override
    public void removeUser(String currentUser) {

    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean newPlayList(String nom, String nomUsuari) {
        return false;
    }

    @Override
    public void removePlayList(int idPlayList) {

    }

    @Override
    public boolean modifyUserEmail(String currentEmail, String newEmail) {
        return false;
    }

    @Override
    public boolean modifyPassword(String currentName, String newPassword) {
        return false;
    }

    @Override
    public boolean modifyUserName(String currentUserName, String newUserName) {
        return false;
    }

    @Override
    public boolean startDB() {
        return false;
    }
}
