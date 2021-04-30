package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;

public interface BusinessFacade {

    public void addSong(String nom, String autor, String duracio, String time, String directori, Boolean isPublic, String nomUsuari);
    public void removeSong(Song song);
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException;
    public boolean removeCurrentUser();
    public void login(String id, String password) throws UserManagerException;
    public boolean newPlayList(String nom, String nomUsuari);
    public void removePlayList(int idPlayList);
    public boolean modifyCurrentUserEmail(String newEmail);
    public boolean modifyCurrentUserPassword(String newPassword) throws PasswordException;
    public boolean modifyCurrentUserName(String newUserName);
    public boolean startDB();

}
