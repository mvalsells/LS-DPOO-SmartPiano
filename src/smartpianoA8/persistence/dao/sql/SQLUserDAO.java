package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.dao.sql.SQLConnector;

public class SQLUserDAO implements UserDAO {
    @Override
    public Boolean addUser(User user) {
        Boolean returnBool = false;

        return returnBool;
    }

    @Override
    public void removeUser(User user) {
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
