package smartpianoA8.business;

import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class UserManager {
    //Constructor
    public UserManager(){

    }

    public void registerUser (String username, String email, String password, String type) throws PasswordException, UserManagerException {

        UserDAO userDao = new SQLUserDAO();

        //Check user data
        boolean usernameExists = false;
        boolean emailExists = false;
        boolean typeIncorrect = false;

        User newUser = new User(username, email, type);

        if (userDao.getUserByUsername(username) != null){
            usernameExists = true;
        }

        if (userDao.getUserByEmail(email) != null){
            emailExists = true;
        }

        if (!type.equals("")) {
            typeIncorrect = true;
        }

        checkPassword(newUser, password);

        if (usernameExists || emailExists || typeIncorrect) {
            throw new UserManagerException(usernameExists, emailExists, typeIncorrect);
        } else {
            newUser.setPasswordHash(encryptPassword(password));
            userDao.addUser(newUser);
        }
    }

    public void removeUser(User user){
        UserDAO usrTmp = new SQLUserDAO();
        if (usrTmp.getUserByUsername(user.getUsername()) != null) {
            usrTmp.removeUser(user);
        }
    }

    public boolean modifyEmail(User user, String newEmail){
        UserDAO usrTmp = new SQLUserDAO();
        if (usrTmp.getUserByUsername(user.getUsername()) != null){
            //TODO Falta implementació a la interifcie UsuariDAO
        }
        return true;
    }

    public boolean modifyPassword(User user, String newPassword) throws PasswordException {
        UserDAO usrTmp = new SQLUserDAO();
        checkPassword(user, newPassword);

        if (usrTmp.getUserByUsername(user.getUsername()) != null){
            //TODO Falta implementació a la interifcie UsuariDAO
        }
        return true;
    }
    public boolean modifyUsername(User user, String newUsername){
        UserDAO usrTmp = new SQLUserDAO();
        if (usrTmp.getUserByUsername(user.getUsername()) != null){
            //TODO Falta implementació a la interifcie UsuariDAO
        }
        return true;
    }


    private String encryptPassword(String input){
        String toReturn = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(input.getBytes(StandardCharsets.UTF_8));
            toReturn = String.format("%064x", new BigInteger(1, md.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    private void checkPassword(User user,String password) throws PasswordException {
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
            if (user.getUsername().equals(password)) {
                equalsUsername = true;
            }
            if (user.getEmail().equals(password)) {
                equalsEmail = true;
            }

        }

        //Comprovació mínim una majuscual, una minuscula i un nombre
        for (int i=0; i < password.length(); i++){
            char c = password.charAt(i);
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

        if (passwordToShort || equalsEmail || equalsUsername || !hasUpperCase || !hasLowerCase || !hasNumber) {
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
