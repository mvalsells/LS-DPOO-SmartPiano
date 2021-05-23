package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.UserManagerException;

/**
 * Interfície pel control d'usuaris de la bbdd
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface UserDAO {

    /**
     * Mètode per crear un usuari
     * @param user usuari
     */
    void addUser(User user);

    /**
     * Mètode per eliminar un usuari
     * @param user l'usuari
     */
    void removeUser(User user);

    /**
     * Mètode per obtenir un usuari amb un correu
     * @param email el correu a buscar
     * @return l'usuari
     */
    User getUserByEmail(String email);

    /**
     * Mètode per obtenir un usuari amb un nom d'usuari
     * @param username el nom d'usuari
     * @return l'usuari
     */
    User getUserByUsername(String username);

    /**
     * Mètode per loggejar un usuari
     * @param id username o email
     * @param passwordHash la contrassenya
     * @return usauri loggejat
     * @throws UserManagerException usuari no trobat
     */
    User loginUser(String id, String passwordHash) throws UserManagerException;

    /**
     * Mètode per actualitzar les dades d'un usuari
     * @param email email de l'usuari
     * @param whatToUpdate User.TERM_EMAIL o User.TERM_USERNAME
     * @param dataToUpdate String amb la dada
     */
    void updateDataUser(String email, String whatToUpdate, String dataToUpdate);

    /**
     * Mètode per comprobar si un usuari existeix
     * @param whatToCheck tipus Email o Username a buscar
     * @param dataToCheck contingut del Email o Username
     * @return true o false trobat
     */
    Boolean userExists(String whatToCheck, String dataToCheck);

}
