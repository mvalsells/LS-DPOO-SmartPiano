package smartpianoA8.business;

import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;

import java.math.BigInteger;
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


    private String encryptPassword(String input){
        String toReturn = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, md.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    private boolean checkPassword(String password, User user) throws PasswordException {
        boolean passwordToShort = false;
        boolean equalsEmail = false;
        boolean equalsUsername = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;

        if (password.length()<8) {
            passwordToShort = true;
        }

        if (user != null) {
            if (user.getUserName().equals(password)) {
                equalsUsername = true;
            }
            if (user.getEmail().equals(password)) {
                equalsEmail = true;
            }

        }

        //Comprovació mínim una majuscual, una minuscula i un nombre
        for (int i=0; i < password.length(); i++){
            Character c = password.charAt(i);
            if (Character.isDigit(c)){
                hasNumber = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase=true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }

            //Si ja hem fet les 3 comprovacions podem sortir del for
            if (hasLowerCase && hasUpperCase && hasNumber) {
                break;
            }
        }

        if (!passwordToShort && !equalsEmail && !equalsUsername && hasUpperCase && hasLowerCase && hasNumber) {
            return true;
        } else {
            throw new PasswordException(passwordToShort, equalsEmail, equalsUsername, !hasUpperCase, !hasLowerCase, !hasNumber);
        }
    }

    /*public String encryptPassword(String plainTextPassword){
        //TODO Acabar de mirar bé
        // https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
        // https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/
        String passwordHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(plainTextPassword.getBytes());
            passwordHash = new String(hashBytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordHash;
    }*/
}
