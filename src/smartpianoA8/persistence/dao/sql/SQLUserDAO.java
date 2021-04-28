package smartpianoA8.persistence.dao.sql;

import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    private SQLConnector connector;
    public SQLUserDAO(SQLConnector connector){
        this.connector = connector;
    }


    /**
     * Busca si un usuari ja existeix per email i username i l'afegeix si no hi és.
     * @param user amb nom i email nous
     * @return true si s'ha afegit o false si ja existia
     */
    @Override
    public void addUser(User user) {
        String query = "INSERT INTO Users (NomUsuari, Email, Contrassenya, tipus) VALUES ('" +
                            user.getUsername() + "', '" +
                            user.getEmail() + "', '" +
                            user.getPasswordHash() + "', '" +
                            user.getType() +
                            "');";
        connector.insertQuery(query);
    }

    /**
     * Borra un usuari ja existent 100% segur, de la BBDD.
     * @param user amb l'username de l'usuari a borrar
     */
    @Override
    public void removeUser(User user) {
        String query = "DELETE FROM Users WHERE NomUsuari LIKE '" + user.getUsername() + "';";
        connector.deleteQuery(query);
    }

    /**
     * Retorna les dades d'un usuari enviant un email
     * @param email a buscar de l'usuari
     * @return l'usuari amb les seves dades
     */
    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT NomUsuari, Email, Contrassenya FROM Users;";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                if(result.getString("Email").compareTo(email) == 0){
                    return new User(result.getString("NomUsuari"), result.getString("Email"), "null", result.getString("Contrassenya"));
                }

            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
        }
        return null;
    }

    /**
     * Retorna les dades d'un usuari enviant un username
     * @param username a buscar de l'usuari
     * @return l'usuari amb les seves dades
     */
    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT NomUsuari, Email, Contrassenya FROM Users;";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                if(result.getString("NomUsuari").compareTo(username) == 0){
                    return new User(result.getString("NomUsuari"), result.getString("Email"), "null", result.getString("Contrassenya"));
                }

            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
        }
        return null;
    }

    @Override
    public User loginUser(String id, String passwordHash) throws UserManagerException{
        //mirem si és UserName
        User testUser = getUserByEmail(id);
        if(testUser != null){
            if(testUser.getPasswordHash().compareTo(passwordHash) == 0){
                return testUser;
            }else{
                throw new UserManagerException(true, false, false, true);
            }

        }

        //mirem si és Email
        testUser = getUserByUsername(id);
            if(testUser != null){
                if(testUser.getPasswordHash().compareTo(passwordHash) == 0){
                    return testUser;
                }else{
                    throw new UserManagerException(true, false, false, true);
                }

            }else{
                throw new UserManagerException(false, false, false, false);
            }

    }

    @Override
    public void updateDataUser(String email, String whatToUpdate, String dataToUpdate) {
        String query = null;
        if(whatToUpdate.compareTo(User.TERM_EMAIL) == 0){
             query = "UPDATE Users SET Email = '" + dataToUpdate + "' WHERE Email = '" + email + "';";
        }else if(whatToUpdate.compareTo(User.TERM_USERNAME) == 0){
             query = "UPDATE Users SET NomUsuari = '" + dataToUpdate + "' WHERE Email = '" + email + "';";
        }else if(whatToUpdate.compareTo(User.TERM_PASSWORD) == 0){
             query = "UPDATE Users SET Contrassenya = '" + dataToUpdate + "' WHERE Email = '" + email + "';";
        }else{
            System.out.print("ERROR: query incorrecta UPDATE, camp passat no coincideix amb res (SQLUserDAO)");
            System.exit(1);
        }

        connector.updateQuery(query);
    }

    /**
     *
     * @param whatToCheck tipus Email o Username a buscar
     * @param dataToCheck contingut del Email o Username
     * @return true o false trobat
     */
    @Override
    public Boolean userExists(String whatToCheck, String dataToCheck){
        String query = null;

        if(whatToCheck.compareTo(User.TERM_EMAIL)==0){
            query = "SELECT Email FROM Users;";


        }else if(whatToCheck.compareTo(User.TERM_USERNAME)==0){
            query = "SELECT NomUsuari FROM Users;";

        }else{
            System.out.print("ERROR: query incorrecta UPDATE, camp passat no coincideix amb res (SQLUserDAO)");
            System.exit(1);
        }



        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                if(whatToCheck.compareTo(User.TERM_EMAIL)==0 && result.getString("Email").compareTo(dataToCheck) == 0){
                    return true;//un existeix i és email
                }

                if(whatToCheck.compareTo(User.TERM_USERNAME)==0 && result.getString("NomUsuari").compareTo(dataToCheck) == 0) {
                    return true;//un existeix i és username
                }
            }
            //cap coincideix però algun s'ha trobat
            return false;
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
            System.out.print("ERROR: No s'ha trobat CAP usuari (SQLUserDAO)");
        return false;
        }

    }

}
