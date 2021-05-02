package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;

public interface BusinessFacade {

    //Usuari
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException;
    public void login(String id, String password) throws UserManagerException;
    public void removeCurrentUser();
    public boolean modifyCurrentUserEmail(String newEmail);
    public boolean modifyCurrentUserPassword(String newPassword) throws PasswordException;
    public boolean modifyCurrentUserName(String newUserName);


    //Cançons
    //public void addSong(String nom, String autor, String duracio, String time, String directori, Boolean isPublic, String nomUsuari);
    //public void removeSong(Song song);


    //Playlist
    //public boolean newPlayList(String nom, String nomUsuari);
    //public void removePlayList(int idPlayList);


    //Altres
    public boolean startDB();

}
