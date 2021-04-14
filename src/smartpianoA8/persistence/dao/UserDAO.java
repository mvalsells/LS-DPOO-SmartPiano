package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public interface UserDAO {

    Boolean addUser(User user);

    void removeUser(User user);

    User getUserByEmail(String email);

    User getUserByUsername(String username);

}
