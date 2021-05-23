package smartpianoA8.business.exceptions;

/**
 * Exepció per contrassenyes d'usuaris
 * @see smartpianoA8.business.entity.User
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class PasswordException extends Exception{
    //Atributs de la exception
    boolean passwordToShort;
    boolean equalsEmail;
    boolean equalsUsername;
    boolean hasNotUpperCase;
    boolean hasNotLowerCase;
    boolean hasNotNumber;
    boolean passwordsDifferent;

    /**
     * Constructor
     * @param passwordToShort boolean contrassenya massa curta
     * @param passwordsDifferent boolean contrassenya incorrecta
     * @param equalsEmail boolean contrassenya = email
     * @param equalsUsername boolean contrassenya = user
     * @param hasNotUpperCase contrassenya no té majúscules
     * @param hasNotLowerCase contrassenya no té minúscules
     * @param hasNotNumber contrassenya no té nombres
     */
    public PasswordException(boolean passwordToShort, boolean passwordsDifferent, boolean equalsEmail, boolean equalsUsername, boolean hasNotUpperCase, boolean hasNotLowerCase, boolean hasNotNumber) {
        super();
        this.passwordToShort = passwordToShort;
        this.equalsEmail = equalsEmail;
        this.equalsUsername = equalsUsername;
        this.hasNotUpperCase = hasNotUpperCase;
        this.hasNotLowerCase = hasNotLowerCase;
        this.hasNotNumber = hasNotNumber;
        this.passwordsDifferent = passwordsDifferent;
     //   toString();
    }

    /**
     * Getter estat contrassenya curta
     * @return boolean true/false estat
     */
    public boolean isPasswordToShort() {
        return passwordToShort;
    }

    /**
     * Getter estat contrassenya = email
     * @return true/false estat
     */
    public boolean isEqualsEmail() {
        return equalsEmail;
    }

    /**
     * Getter estat = user
     * @return true/false estat
     */
    public boolean isEqualsUsername() {
        return equalsUsername;
    }

    /**
     * Getter estat contrassenya no ABC
     * @return true/fasle estat
     */
    public boolean isHasNotUpperCase() {
        return hasNotUpperCase;
    }

    /**
     * Getter estat contrassenya no abc
     * @return estat true/false
     */
    public boolean isHasNotLowerCase() {
        return hasNotLowerCase;
    }

    /**
     * Getter estat no nombres
     * @return true/false estat
     */
    public boolean isHasNotNumber() {
        return hasNotNumber;
    }

    /**
     * Getter contrassenya incorrecta
     * @return true/false estat
     */
    public boolean isPasswordsDifferent() {
        return passwordsDifferent;
    }

    /**
     * Mètode que converteix i retorna tots els estats en String
     * @return String estats
     * @implNote per debugging només
     */
    @Override
    public String toString() {
        return "PasswordException{" +
                "passwordToShort=" + passwordToShort +
                ", equalsEmail=" + equalsEmail +
                ", equalsUsername=" + equalsUsername +
                ", hasNotUpperCase=" + hasNotUpperCase +
                ", hasNotLowerCase=" + hasNotLowerCase +
                ", hasNotNumber=" + hasNotNumber +
                '}';
    }
}
