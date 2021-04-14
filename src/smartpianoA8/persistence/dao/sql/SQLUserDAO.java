package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.dao.sql.SQLConnector;

public class SQLUserDAO implements UserDAO {
    /**
     *
     * @param user
     * @return
     */
    @Override
    public Boolean addUser(User user) {
        Boolean returnBool = false;

        return returnBool;
    }

    /**
     *
     * @param user
     */
    @Override
    public void removeUser(User user) {
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
