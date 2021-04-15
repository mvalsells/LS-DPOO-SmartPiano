package smartpianoA8.business.exceptions;

public class UserManagerException extends Exception{
    boolean usernameExists;
    boolean emailExists;
    boolean typeIncorrect;

    public UserManagerException(boolean usernameExists, boolean emailExists, boolean typeIncorrect) {
        this.usernameExists = usernameExists;
        this.emailExists = emailExists;
        this.typeIncorrect = typeIncorrect;
    }

    public boolean isUsernameExists() {
        return usernameExists;
    }

    public boolean isEmailExists() {
        return emailExists;
    }

    public boolean isTypeIncorrect() {
        return typeIncorrect;
    }
}
