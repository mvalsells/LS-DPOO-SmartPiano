package smartpianoA8.business.entity;

public class User {
    private String username;
    private String email;
    private String type;
    private String passwordHash;

    public static final String TYPE_SMARTPIANO = "";
    public static final String TYPE_FACEBOOK = "facebook";
    public static final String TYPE_GOOGLE = "google";
    public static final String UPDATE_EMAIL = "Email";
    public static final String UPDATE_USERNAME = "Username";
    public static final String UPDATE_PASSWORD = "Password";

    public User(){
    }

    public User(String username, String email, String type, String passwordHash){
        this.username = username;
        this.email = email;
        this.type = type;
        this.passwordHash = passwordHash;

    }

    public User(String username, String email, String type) {
        this.username = username;
        this.email = email;
        this.type = type;
    }

    //Getter and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

}
