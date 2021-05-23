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

/**
 * Classe per la organització d'utilitats i eines pels Usuaris
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class UserManager {
    //Atributs
    private UserDAO userDAO;
    private User currentUser;

    //Constructor

    /**
     * Constructor amb l'accés a la DAO de la bbdd per Usuaris
     * @param userDAO DAO dels usuaris de la bbdd
     * @see smartpianoA8.persistence.dao.sql.SQLUserDAO
     */
    public UserManager(UserDAO userDAO){
        this.userDAO = userDAO;
        currentUser = null;
    }

    /**
     * Mètode per registrar un nou usuari, enviabnt totes les dades necessaries des de la vista
     * @param username String nom d'usuari
     * @param email String email
     * @param password String contrassenya
     * @param passwordRepetition String repetició de la contrassenya
     * @param type String tipus d'usuari (smartpiano / google / facebook)
     * @throws PasswordException Exepció del control d'errors de la contrassenya
     * @throws UserManagerException Exepció del control d'errors del nom d'usuari i el correu
     */
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

    /**
     * Mètode per comprobar el login d'un usuari
     * @param id Int id de l'usuari
     * @param password String contrassenya de l'usuari
     * @throws UserManagerException Exepció pel control d'errors i problemes del nom d'usuari i email
     */
    public void login(String id, String password) throws UserManagerException {
        id = id.toLowerCase();
        currentUser = userDAO.loginUser(id, encryptPassword(password));
    }

    //TODO opt encontrar usuario segun id y comprobar en el manager si contra correctas o no.

    /**
     * Mètode per eliminar l'usuari loggejat completament
     */
    public void removeCurrentUser(){
        if (userDAO.getUserByUsername(currentUser.getUsername()) != null) {
            userDAO.removeUser(currentUser);
        }
    }

    /**
     * Mètode per modificar l'email de l'usuari loggejat actual
     * @param newEmail String nou email de l'usuari
     * @return true: completat, false: no permés
     */
    public boolean modifyCurrentUserEmail(String newEmail){

        if (modifyEmail(currentUser.getEmail(), newEmail)){
            currentUser.setEmail(newEmail);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mètode per realitar l'acció de canviar l'email amb la lògica de realitzar l'acció
     * @param currentEmail String email actual
     * @param newEmail String email nou demanat
     * @return boolean true: completat false: no completat
     */
    private boolean modifyEmail(String currentEmail, String newEmail){
        newEmail = newEmail.toLowerCase();
        User tmpUser = userDAO.getUserByEmail(newEmail);
        if (tmpUser == null && checkEmail(newEmail)) {
            userDAO.updateDataUser(currentEmail, User.TERM_EMAIL, newEmail);
            currentUser.setEmail(newEmail);
            return true;
        }else {
            //System.err.println("Not able to change Email from user: " + user.getUsername());
            return false;
        }

    }

    /**
     * Mètode per modificar la contrassenya de l'usuari actual
     * @param newPassword String nova contrassenya demanada
     * @param newPasswordRepetition String nova contrassenya demanada repetida
     * @return true: s'ha pogut modificasr false: no s'ha pogut
     * @throws PasswordException Exepciñó per comporvar problemes amb la nova contrassenya (compleix requisits)
     */
    public boolean modifyCurrentUserPassword(String newPassword, String newPasswordRepetition) throws PasswordException{
        if (modifyPassword(currentUser,newPassword, newPasswordRepetition)){
            currentUser.setPasswordHash(encryptPassword(newPassword));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mètode per canviar de contrassenya. Lògica de realitzar l'acció.
     * @param user User usuari a qui canviar la contrassenya
     * @param newPassword String nova contrassenya
     * @param newPasswordRepetition String repetició de la novas contrassenya
     * @return boolean true: s'ha pogut, false: no s'ha pogut o no s'ha permés
     * @throws PasswordException Exepció per comprovar que la contrassenya nova compleix les mesures i control d'errors
     */
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

    /**
     * Mèotde per modificsar el nom d'usuari de l'usuari actual loggejat
     * @param newUsername nou String del nom d'usuari
     * @return boolean true: completat, false: no completat
     */
    public boolean modifyCurrentUserName(String newUsername){
        if (modifyUsername(currentUser.getEmail(), newUsername)){
            currentUser.setUsername(newUsername);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mètode amb la lògica del canvi de nom d'usuari
     * @param currentEmail String email actual (necessari per mantenir la tracabilitat de l'usuari en questió
     * @param newUsername String usuari actual
     * @return boolean amb true: s'ha pogut o permés i false: no s'ha permés
     */
    private boolean modifyUsername(String currentEmail, String newUsername){
        User tmpUser = userDAO.getUserByUsername(newUsername);
        if (tmpUser == null) {
            userDAO.updateDataUser(currentEmail, User.TERM_USERNAME, newUsername);
            return true;
        }else {
            //System.err.println("Not able to change Username from user: " + user.getUsername());
            return false;
        }

    }

    /**
     * Mètode per encriptar una contrassenya amb SHA256
     * @param input String amb la contrassenya desencriptada
     * @return String HASH de contrassenya encriptat en SHA256
     */
    private String encryptPassword(String input){
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

    /**
     * Mètode per comprovar quin error hi ha en una contrassenya incorrecte i si és que hi ha algun error
     * @param user User usuari a comprovar
     * @param password String contrassenya
     * @param passwordRepetition String contrassenya repetida per la comprovació
     * @throws PasswordException Exepció per avisar dels errors ocasionats i detectats
     */
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

    /**
     * Mètode per comprovar que els email compleixen la característica de ser un email
     * @param email String email a comprovar
     * @return boolean true: correcte false: incorrecte/no és un email
     */
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

    public User getCurrentUser() {
        return currentUser;
    }
}
