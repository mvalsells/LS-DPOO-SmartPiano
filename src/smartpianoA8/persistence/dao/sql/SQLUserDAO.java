package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    private SQLConnector connector;
    public SQLUserDAO(String username, String password, int port, String ip, String databaseName){
        SQLConnector connector = new SQLConnector(username,  password,  ip,  port, databaseName);
    }


    /**
     * Busca si un usuari ja existeix per email i username i l'afegeix si no hi és.
     * @param user amb nom i email nous
     * @return true si s'ha afegit o false si ja existia
     */
    @Override
    public Boolean addUser(User user) {
        String buit = "null";
        String query = "SELECT NomUsuari, Email FROM Users;";
        ResultSet result = connector.selectQuery(query);

        try{
            while(result.next()) {
                if(result.getString("Email").compareTo(user.getEmail()) == 0 && result.getString("NomUsuari").compareTo(user.getUsername()) == 0){
                    query = "INSERT INTO User(NomUsuari, Email, Contrassenya, tipus) VALUES ('" +
                            user.getUsername() + "', '" +
                            user.getEmail() + "', '" +
                            user.getPasswordHash() + "', '" +
                            buit +
                            "');";
                    connector.insertQuery(query);
                    return true;
                }

            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
            return false;
        }
        return false;

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
}
