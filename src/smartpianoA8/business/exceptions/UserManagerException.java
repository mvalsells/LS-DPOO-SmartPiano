package smartpianoA8.business.exceptions;

/**
 * Exepció per noms d'usuari i email
 * @see smartpianoA8.business.entity.User
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class UserManagerException extends Exception{
    boolean usernameExists;
    boolean emailExists;
    boolean typeIncorrect;
    boolean passwordIncorrect;
    boolean emailIncorrect;

    /**
     * Constructor amb els possibles estats
     * @param usernameExists boolean usuari existent
     * @param emailExists boolean email existent
     * @param emailIncorrect boolean email incorrecte
     * @param typeIncorrect boolean tipus de compte incorrecte
     * @param passwordIncorrect boolean contra incorrecta
     * @see PasswordException per <passwordIncorrect></passwordIncorrect>
     */
    public UserManagerException(boolean usernameExists, boolean emailExists, boolean emailIncorrect, boolean typeIncorrect, boolean passwordIncorrect) {
        this.usernameExists = usernameExists;
        this.emailExists = emailExists;
        this.emailIncorrect = emailIncorrect;
        this.typeIncorrect = typeIncorrect;
        this.passwordIncorrect = passwordIncorrect;
    }

    /**
     * Getter de l'estat d'usuari existent
     * @return true/false de l'estat
     */
    public boolean isUsernameExists() {
        return usernameExists;
    }

    /**
     * Getter de l'estat d'email existent
     * @return true/false de l'estat
     */
    public boolean isEmailExists() {
        return emailExists;
    }

    /**
     * Getter de l'estat de tipus incorrecte de compte
     * @return true/false de l'estat
     */
    public boolean isTypeIncorrect() {
        return typeIncorrect;
    }

    /**
     * Getter de l'estat de contrassenya incorrecte
     * @return true/false de l'estat
     */
    public boolean isPasswordIncorrect() {
        return passwordIncorrect;
    }

    /**
     * Getter de l'estat del correu incorrecte
     * @return true/false de l'estat
     */
    public boolean isEmailIncorrect() {
        return emailIncorrect;
    }

    /**
     * Mètode per convertir a String els estats
     * @implNote per debugging només
     * @return String amb els estats
     */
    @Override
    public String toString() {
        return "UserManagerException{" +
                "usernameExists=" + usernameExists +
                ", emailExists=" + emailExists +
                ", typeIncorrect=" + typeIncorrect +
                ", passwordIncorrect=" + passwordIncorrect +
                '}';
    }
}
