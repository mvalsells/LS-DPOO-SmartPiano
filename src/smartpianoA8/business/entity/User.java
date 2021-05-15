package smartpianoA8.business.entity;

/**
 * Entity d'usuari que es pot registrar i loggejar
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class User {
    private String username;
    private String email;
    private String type;
    private String passwordHash;

    public static final String TYPE_SMARTPIANO = "smartpiano";
    public static final String TYPE_FACEBOOK = "facebook";
    public static final String TYPE_GOOGLE = "google";
    public static final String TERM_EMAIL = "Email";
    public static final String TERM_USERNAME = "Username";
    public static final String TERM_PASSWORD = "Password";

    /**
     * Constructor buit
     */
    public User(){
    }

    /**
     * Constructor amb les dades completes
     * @param username String nom d'usuari únic
     * @param email String email únic
     * @param type String amb el tipus d'usuari (en aquesta versó 1.0)
     *             null: username/email
     *             0: username(email
     *             google: google login api (unimplemented)
     *             facebook: facebook login api (unimplemented)
     * @param passwordHash Hash codificat amb la contrassenya
     */
    public User(String username, String email, String type, String passwordHash){
        this.username = username;
        this.email = email;
        this.type = type;
        this.passwordHash = passwordHash;

    }

    /**
     * Constructor sense la contrassenya
     * @param username String nom d'usuari
     * @param type String amb el tipus d'usuari (en aquesta versó 1.0)
     *             null: username/email
     *             0: username(email
     *             google: google login api (unimplemented)
     *             facebook: facebook login api (unimplemented)
     */
    public User(String username, String email, String type) {
        this.username = username;
        this.email = email;
        this.type = type;
    }

    /**
     * Getter del nom d'usuari únic
     * @return String nom d'usuari únic
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter del nom d'usuari
     * @param username String nom d'usuari
     * @implNote Necessari canviar de la BBDD la mateixa dada
     * @see smartpianoA8.persistence.dao.sql.SQLUserDAO
     * @see smartpianoA8.persistence.dao.UserDAO
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter del email
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter del email
     * @param email String email
     * @see smartpianoA8.persistence.dao.sql.SQLUserDAO
     * @see smartpianoA8.persistence.dao.UserDAO
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter del hash de la contra
     * @return String hash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Getter del tipus de compta
     * @return String amb el tipus d'usuari (en aquesta versó 1.0)
     *             null: username/email
     *             0: username(email
     *             google: google login api (unimplemented)
     *             facebook: facebook login api (unimplemented)
     */
    public String getType() {
        return type;
    }

    /**
     * Setter del has de la contra
     * @param passwordHash Strign hash
     * @implNote ha d'estar en SHA256
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
