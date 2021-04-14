package smartpianoA8.business;

import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        if (usrTmp.getUserByUsername(user.getUserName()) != null) {
            usrTmp.removeUser(user);
        }
    }

    public boolean modifyUserEmail(User user, String newEmail){
        UserDAO usrTmp = new SQLUserDAO();
        if (usrTmp.getUserByUsername(user.getUserName()) != null){
            //TODO Falta implementació a la interifcie UsuariDAO
        }
        return true;
    }

    public boolean modifyUserPassword(User user, String newPasswordHash){
        UserDAO usrTmp = new SQLUserDAO();
        if (usrTmp.getUserByUsername(user.getUserName()) != null){
            //TODO Falta implementació a la interifcie UsuariDAO
        }
        return true;
    }
    public boolean modifyUserUserName(User user, String newUsername){
        UserDAO usrTmp = new SQLUserDAO();
        if (usrTmp.getUserByUsername(user.getUserName()) != null){
            //TODO Falta implementació a la interifcie UsuariDAO
        }
        return true;
    }

    protected String encryptPassword(String plainTextPassword){
        //TODO Acabar de mirar bé
        // https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(plainTextPassword.getBytes(StandardCharsets.UTF_8));
        return "Hello";
    }
}
