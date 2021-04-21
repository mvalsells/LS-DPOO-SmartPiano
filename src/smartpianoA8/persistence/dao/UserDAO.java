package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.UserManagerException;

public interface UserDAO {

    /**
     *
     * @param user
     * @return
     */
    Boolean addUser(User user);

    /**
     *
     * @param user
     */
    void removeUser(User user);

    /**
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    void updateDataUser(User user, String whatToUpdate, String data);

    User loginUser(String id, String passwordHash) throws UserManagerException;

    void updateDataUser(String email, String whatToUpdate, String dataToUpdate);

    Boolean userExists(String whatToCheck, String dataToCheck);

}
