package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

public interface BusinessFacade {

    public void addSong(String nom, String autor, String duracio, String time, String directori, Boolean isPublic, String nomUsuari);
    public void removeSong(Song song);
    public boolean createUser(String userName, String email, String password, String type);
    public void  removeUser(String currentUser);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public boolean newPlayList(String nom, String nomUsuari);
    public void removePlayList(int idPlayList);
    public boolean modifyUserEmail(String currentEmail, String newEmail);
    public boolean modifyPassword(String currentName, String newPassword);
    public boolean modifyUserName(String currentUserName, String newUserName);

}
