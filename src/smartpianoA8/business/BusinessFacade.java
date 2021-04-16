package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;

public interface BusinessFacade {

    public void addSong(String nom, String autor, String duracio, String time, String directori, Boolean isPublic, String nomUsuari);
    public void removeSong(Song song);
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException;
    public boolean removeUser(User user);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public boolean newPlayList(String nom, String nomUsuari);
    public void removePlayList(int idPlayList);
    public boolean modifyUserEmail(String currentEmail, String newEmail);
    public boolean modifyPassword(String currentName, String newPassword);
    public boolean modifyUserName(String currentUserName, String newUserName);
    public boolean startDB();

}
