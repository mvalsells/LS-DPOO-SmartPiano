package smartpianoA8.business.entity;

public class User {
    private String userName;
    private String email;
    private final String type;
    private String passwordHash;

    public User(String userName, String email, String type, String passwordHash){
        this.userName = userName;
        this.email = email;
        this.type = type;
        this.passwordHash = passwordHash;

    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
