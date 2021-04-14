package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.User;

public interface UserDAO {
    void addUser(User user);
    Boolean removeUser(User user);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
