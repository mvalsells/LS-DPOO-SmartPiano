package smartpianoA8.business.exceptions;

public class PasswordException extends Exception{
    //Atributs de la exception
    boolean passwordToShort;
    boolean equalsEmail;
    boolean equalsUsername;
    boolean hasNotUpperCase;
    boolean hasNotLowerCase;
    boolean hasNotNumber;
    boolean passwordsDifferent;

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

    public boolean isPasswordToShort() {
        return passwordToShort;
    }

    public boolean isEqualsEmail() {
        return equalsEmail;
    }

    public boolean isEqualsUsername() {
        return equalsUsername;
    }

    public boolean isHasNotUpperCase() {
        return hasNotUpperCase;
    }

    public boolean isHasNotLowerCase() {
        return hasNotLowerCase;
    }

    public boolean isHasNotNumber() {
        return hasNotNumber;
    }

    public boolean isPasswordsDifferent() {
        return passwordsDifferent;
    }

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
