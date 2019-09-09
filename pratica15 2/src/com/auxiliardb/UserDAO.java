package com.auxiliardb;

import com.model.User;
import com.utilities.Constants;
import com.utilities.DAO;
import com.utilities.exceptions.InvalidEmailException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDAO implements DAO<User> {
    private Connection connection;
    //private User tempUserQuery;
    private Pattern email_patern;
    private static UserDAO instance;

    public static UserDAO getInstance(String myConnection){
        if(instance==null){
            instance = new UserDAO(myConnection);
            return instance;
        }
        return instance;
    }
    private UserDAO(String myConnection){
        /**
         * Constructor for the User table DAO.
         * <p>
         * @param myConnection path to the database, including the JDBC.
         */
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);

            email_patern = Pattern.compile(Constants.email_regex);

            //creates table if it doesn't exist
            Statement comandoSQL = connection.createStatement();
            comandoSQL.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "\"id\" INTEGER PRIMARY KEY UNIQUE NOT NULL, " +
                    "\"nome\" VARCHAR(100), " +
                    "\"email\" VARCHAR(100), " +
                    "\"senha\" VARCHAR(100) );");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }
    public boolean insert(User user){
        /**
         * DAO interface method.
         * Inserts a certain user into the user table.
         * @param user user to be inserted.
         * @return  whether the insert was successful or not.
         */
        PreparedStatement comandoSQL;
        try {

           //checks email validity
            Matcher email_matcher = email_patern.matcher(user.email);
            if (!email_matcher.matches())
                throw new InvalidEmailException("Given E-Mail is not valid!");

            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_USERS, 4));

            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.setString(2,user.nome);
            comandoSQL.setString(3,user.email);
            comandoSQL.setString(4,user.senha);

            comandoSQL.executeUpdate();
            comandoSQL.close();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        catch (InvalidEmailException e){
            System.out.println("\nInvalid Email...\nCanceling Insertion\n");
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<User> getAll(){
        /**
         * Returns all users in the user table
         * @return List<User> of all users in the connected db users table
         */
        List<User> users = new ArrayList<>();

        try {
            Statement comandoSQL = connection.createStatement();
            ResultSet rs = comandoSQL.executeQuery(Constants.getSelectAll(Constants.TABELA_USERS));

            while(rs.next()){
                User user = new User(
                 rs.getString("nome"),
                 rs.getString("email"),
                 rs.getString("senha")
                );
                user.id = rs.getInt("id");
                users.add(user);
            }
            rs.close();
        } catch (Exception e) {
            return null;
        }
        return users;
    }
    public User get(String id){
        User tempUserQuery = null;
        /**
         * Given a name, will search and return the given User with said name
         * @param nome String name of the user to be searched
         * @return User object if found in table
         */
        try {
            Statement comandoSQL = connection.createStatement();
            ResultSet rs = comandoSQL.executeQuery(Constants.getSelect(Constants.TABELA_USERS, "id", id));

            while (rs.next()){
                tempUserQuery = new User(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                tempUserQuery.id = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tempUserQuery;
    }
    public boolean update(String id, User user){
        /**
         * Updates all columns of the table entry.
         * @param id original name of table entry to be searched.
         * @param user new User object with the info of the updated user
         * @return whether the update was successful or not.
         */
        try {

            Matcher email_matcher = email_patern.matcher(user.email);
            if(!email_matcher.matches())
                throw new InvalidEmailException("Email Not Valid!");

            Statement comandoSQL = connection.createStatement();
            comandoSQL.executeUpdate(Constants.getUpdate(Constants.TABELA_USERS, "id", id, user.nome, user.email, user.senha));

            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidEmailException e) {
            //e.printStackTrace();
            System.out.println("E-Mail Inválido!");
            return false;
        }
    }
    public boolean remove(String id){
        /**
         * Removes an entry from the user table based of name
         * @param nome name column of the entry to find and remove.
         * @return  whether the remove was successful.
         */
        try {
            Statement comandoSQL = connection.createStatement();
            comandoSQL.executeUpdate(Constants.getDelete(Constants.TABELA_USERS, "id",id));
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        catch (Exception e){
            System.out.println("Not Expected Exception!");
            e.printStackTrace();
            return false;
        }
    }

}
