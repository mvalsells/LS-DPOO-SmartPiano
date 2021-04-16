package smartpianoA8.business.exceptions;

public class UserManagerException extends Exception{
    boolean usernameExists;
    boolean emailExists;
    boolean typeIncorrect;
    boolean passwordIncorrect;

    public UserManagerException(boolean usernameExists, boolean emailExists, boolean typeIncorrect, boolean passwordIncorrect) {
        this.usernameExists = usernameExists;
        this.emailExists = emailExists;
        this.typeIncorrect = typeIncorrect;
        this.passwordIncorrect = passwordIncorrect;
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

    public boolean isPasswordIncorrect() {
        return passwordIncorrect;
    }
}
