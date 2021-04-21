package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.User;

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

    //void updateDataUser(User user, String whatToUpdate, String data);

}
