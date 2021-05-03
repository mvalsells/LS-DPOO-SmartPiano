package smartpianoA8.business;

import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.dao.PlayListDAO;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.UserDAO;

public class BusinessFacadeImpl implements BusinessFacade{

    private UserManager userManager;
    private SongDAO songDAO;
    private PlayListDAO playListDAO;

    public BusinessFacadeImpl(UserDAO userDAO, SongDAO songDAO, PlayListDAO playListDAO){
        userManager = new UserManager(userDAO);
    }


    @Override
    public boolean startDB() {
        return false;
    }

    // ------------------------------------------------------
    //  START user implementation
    // ------------------------------------------------------
    @Override
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException {
        userManager.registerUser(username, email, password, type);
    }

    @Override
    public void login(String id, String password) throws UserManagerException {
        userManager.login(id,password);
    }

    @Override
    public void removeCurrentUser() {
        userManager.removeCurrentUser();
    }

    @Override
    public boolean modifyCurrentUserEmail(String newEmail) {
        return userManager.modifyCurrentUserEmail(newEmail);
    }

    @Override
    public boolean modifyCurrentUserPassword(String newPassword) throws PasswordException {
        return userManager.modifyCurrentUserPassword(newPassword);
    }

    @Override
    public boolean modifyCurrentUserName(String newUserName) {
        return userManager.modifyCurrentUserName(newUserName);
    }
    // ------------------------------------------------------
    //  END user implementation
    // ------------------------------------------------------

}
