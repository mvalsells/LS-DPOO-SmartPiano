package smartpianoA8.business;

import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.dao.UserDAO;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Pattern;

public class UserManager {
    //Atributs
    private UserDAO userDAO;
    private User currentUser;

    //Constructor
    public UserManager(UserDAO userDAO){
        this.userDAO = userDAO;
        currentUser = null;
    }


    public void registerUser (String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException {
        email = email.toLowerCase();
        username = username.toLowerCase();
        //mirar si estam bien los datos recibidos
        boolean correctEmail =  checkEmail(email);
        boolean usernameExists = userDAO.userExists(User.TERM_USERNAME, username);
        boolean emailExists = userDAO.userExists(User.TERM_EMAIL, email);
        boolean typeIncorrect;

        if (type.equals(User.TYPE_SMARTPIANO)){
            typeIncorrect = false;
        } else {
            typeIncorrect = true;
        }

        if(!usernameExists && !emailExists && !typeIncorrect && correctEmail) {
            User newUser = new User(username, email, type);
            checkPassword(newUser, password, passwordRepetition);
            newUser.setPasswordHash(encryptPassword(password));
            userDAO.addUser(newUser);
        }else {
            throw new UserManagerException(usernameExists, emailExists,!correctEmail, typeIncorrect, false);
        }
    }


    public void login(String id, String password) throws UserManagerException {
        id = id.toLowerCase();
        currentUser = userDAO.loginUser(id, encryptPassword(password));
    }

    //TODO opt encontrar usuario segun id y comprobar en el manager si contra correctas o no.


    public void removeCurrentUser(){
        removeUser(currentUser);
    }
    private boolean removeUser(User user){
        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            userDAO.removeUser(user);
            return true;
        } else {
            return false;
        }
    }


    public boolean modifyCurrentUserEmail(String newEmail){
        return modifyEmail(currentUser, newEmail);
    }
    private boolean modifyEmail(User user, String newEmail){
        newEmail = newEmail.toLowerCase();
        if (userDAO.getUserByUsername(user.getUsername()) != null && checkEmail(newEmail)) {
            userDAO.updateDataUser(user.getEmail(), User.TERM_EMAIL, newEmail);
            return true;
        }else {
            //System.err.println("Not able to change Email from user: " + user.getUsername());
            return false;
        }

    }

    public boolean modifyCurrentUserPassword(String newPassword, String newPasswordRepetition) throws PasswordException{
        return modifyPassword(currentUser,newPassword, newPasswordRepetition);
    }
    private boolean modifyPassword(User user, String newPassword, String newPasswordRepetition) throws PasswordException {

        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            checkPassword(user, newPassword, newPasswordRepetition);
            userDAO.updateDataUser(user.getEmail(), User.TERM_PASSWORD, encryptPassword(newPassword));
            return true;
        }else {
            //System.err.println("Not able to change Password from user: " + user.getUsername());
            return false;
        }

    }


    public boolean modifyCurrentUserName(String newUsername){
        return modifyUsername(currentUser, newUsername);
    }
    private boolean modifyUsername(User user, String newUsername){

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

    private void checkPassword(User user,String password, String passwordRepetition) throws PasswordException {
        boolean passwordToShort = false;
        boolean equalsEmail = false;
        boolean equalsUsername = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        boolean passwordDifferent = false;
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
        if(!password.equals(passwordRepetition)){
            passwordDifferent = true;
        }

        if (passwordToShort || passwordDifferent || equalsEmail || equalsUsername || !hasUpperCase || !hasLowerCase || !hasSpecialChar) {
            throw new PasswordException(passwordToShort,passwordDifferent, equalsEmail, equalsUsername, !hasUpperCase, !hasLowerCase, !hasSpecialChar);
        }
    }

    private boolean checkEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(regex)) {
            return true;
        }else {
            return false;
        }
    }

    public void logoutCurrentUser() {
        currentUser=null;
    }
}
