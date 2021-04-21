package smartpianoA8.business;

import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.SQLUserDAO;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class UserManager {
    //Atributs
    private UserDAO userDAO;

    //Constructor
    public UserManager(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    //TODO Hablar con diseño de vistas para en lugar de crear funciones para cambiar usuario, contraseña, email... Una SOLA funcion a la que mandamos un string con QUE cambiar y el que así nos ahorramos muchas funciones y simplificamos codigo.

    public void registerUser (String username, String email, String password, String type) throws PasswordException, UserManagerException {

        //mirar si estam bien los datos recibidos
        boolean correctEmail = false;
        boolean usernameExists = false;
        boolean emailExists = false;
        boolean typeIncorrect = false;

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(regex)) {
            correctEmail = true;
            emailExists = userDAO.userExists(User.TERM_EMAIL, email);
        }

        usernameExists = userDAO.userExists(User.TERM_USERNAME, username);

        if (!type.equals("")) {
            typeIncorrect = false;
        }

        if(!usernameExists && !emailExists && !typeIncorrect && correctEmail) {
            User newUser = new User(username, email, type);
            checkPassword(newUser, password);
            newUser.setPasswordHash(encryptPassword(password));
            userDAO.addUser(newUser);
        }else {
            throw new UserManagerException(usernameExists, emailExists, typeIncorrect, true);
        }










        /*--------------

        User newUser = new User(username, email, type);

        if (userDAO.getUserByUsername(username) != null){
            usernameExists = true;
        }

        if (userDAO.getUserByEmail(email) != null){
            emailExists = true;
        }

        if (!type.equals("")) {
            typeIncorrect = true;
        }

        checkPassword(newUser, password);

        if (usernameExists || emailExists || typeIncorrect) {
            throw new UserManagerException(usernameExists, emailExists, typeIncorrect, true);
        } else {
            newUser.setPasswordHash(encryptPassword(password));
            userDAO.addUser(newUser);
        }*/
    }


    public User login(String id, String password) throws UserManagerException {

        /*boolean passwordIncorrect = false;
        boolean usernameIncorrect = false;
        boolean emailIncorrect = false;
        boolean userIncorrect = false;*/

        return userDAO.loginUser(id, encryptPassword(password));

        /*User userTmp = userDAO.getUserByUsername(user.getUsername());

        if (userTmp != null) {
            usernameIncorrect = false;
            if (userTmp.getEmail().equals(user.getEmail())) {
                emailIncorrect = false;
            }
            if (userTmp.getPasswordHash().equals(user.getPasswordHash())) {
                passwordIncorrect = false;
            }
        }

        if (!passwordIncorrect || !usernameIncorrect || !emailIncorrect) {
            //throw new UserManagerException(!usernameIncorrect);
            throw new UserManagerException(!usernameIncorrect, !emailIncorrect, false, !passwordIncorrect);
        }

        userTmp = userDAO.getUserByEmail(user.getEmail());

        if (userTmp != null) {
            emailIncorrect = false;
            if (userTmp.getUsername().equals(user.getUsername())) {
                usernameIncorrect = false;
            }
            if (userTmp.getPasswordHash().equals(user.getPasswordHash())) {
                passwordIncorrect = false;
            }
        }

        if (!passwordIncorrect || !usernameIncorrect || !emailIncorrect) {
            //throw new UserManagerException(!usernameIncorrect);
            throw new UserManagerException(!usernameIncorrect, !emailIncorrect, false, !passwordIncorrect);
        }*/

    }

    public boolean removeUser(User user){
        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            userDAO.removeUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyEmail(User user, String newEmail){

        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            userDAO.updateDataUser(user.getEmail(), User.TERM_EMAIL, newEmail);
            return true;
        }else {
            System.err.println("Not able to change Email from user: " + user.getUsername());
            return false;
        }

    }

    public boolean modifyPassword(User user, String newPassword) throws PasswordException {

        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            userDAO.updateDataUser(user.getEmail(), User.TERM_PASSWORD, newPassword);
            return true;
        }else {
            System.err.println("Not able to change Password from user: " + user.getUsername());
            return false;
        }

    }

    public boolean modifyUsername(User user, String newUsername){

        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            userDAO.updateDataUser(user.getEmail(), User.TERM_USERNAME, newUsername);
            return true;
        }else {
            System.err.println("Not able to change Username from user: " + user.getUsername());
            return false;
        }

    }


    public String encryptPassword(String input){
        String toReturn = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(input.getBytes(StandardCharsets.UTF_8));
            toReturn = String.format("%064x", new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
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
        boolean hasSpecialChar = false;

        Pattern specialCharPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern upperCasePattern = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

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

        //Ver sin for si tenemos los datos necesarios para una password correcta

        if(specialCharPattern.matcher(password).find() || digitCasePatten.matcher(password).find()) {
            hasSpecialChar = true;
        }
        if(upperCasePattern.matcher(password).find()) {
            hasUpperCase = true;
        }
        if(lowerCasePatten.matcher(password).find()) {
            hasLowerCase = true;
        }

        if (passwordToShort || equalsEmail || equalsUsername || !hasUpperCase || !hasLowerCase || !hasSpecialChar) {
            throw new PasswordException(passwordToShort, equalsEmail, equalsUsername, !hasUpperCase, !hasLowerCase, !hasSpecialChar);
        }
    }

    /*public String encryptPassword(String plainTextPassword){
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
