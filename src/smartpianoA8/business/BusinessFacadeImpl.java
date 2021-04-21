package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.dao.UserDAO;

public class BusinessFacadeImpl implements BusinessFacade {

    //Atributs
    UserManager userManager;
    User currentUser;
    //Constructor
    public BusinessFacadeImpl(UserDAO userDAO){
        userManager = new UserManager(userDAO);
        currentUser = null;
    }

    //Metodes
    @Override
    public void addSong(String nom, String autor, String duracio, String time, String directori, Boolean isPublic, String nomUsuari) {

    }

    @Override
    public void removeSong(Song song) {

    }

    @Override
    public void registerUser(String userName, String email, String password, String type) throws PasswordException, UserManagerException {
        userManager.registerUser(userName,email,password,type);
    }

    @Override
    public boolean removeUser(User user) {
        return userManager.removeUser(user);
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
