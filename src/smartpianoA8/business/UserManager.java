package smartpianoA8.business;

import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;

public class UserManager {
    //Constructor
    public UserManager(){

    }

    public boolean createUser (String userName, String email, String passwordHash, String type){

        UserDAO userDao = new SQLUserDAO();
        //Check if users exists
        if (userDao.getUserByUsername(userName) == null && userDao.getUserByEmail(email) == null){
            User userTmp = new User(userName,email,type,passwordHash);
            if (userDao.addUser(userTmp)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void removeUser(User user){
        UserDAO usrTmp = new SQLUserDAO();
        usrTmp.removeUser(user);
    }
}
