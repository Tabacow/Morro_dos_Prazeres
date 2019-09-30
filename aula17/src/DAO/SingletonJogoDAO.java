package DAO;

import model.Jogo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonJogoDAO {
    private static SingletonJogoDAO instance = null;
    private Connection con;

    public static SingletonJogoDAO getInstance() {
        if (instance == null) {
            instance = new SingletonJogoDAO();
        }
        return instance;
    }

    private SingletonJogoDAO() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:Games.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertJogo(Jogo jogo) {
        PreparedStatement comandoSQL;
        try {
            comandoSQL = con.prepareStatement("INSERT INTO Game VALUES  (null, ?, ?, ?, ?)");
            comandoSQL.setString(1, jogo.name);
            comandoSQL.setString(2, jogo.genre);
            comandoSQL.setString(3, jogo.plataform);
            comandoSQL.setString(4, jogo.launchdate);
            comandoSQL.executeUpdate();
           // con.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Jogo> getAllJogos(){
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery("SELECT * FROM Game;");
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("plataform"),
                        rs.getString("launchdate"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public  List<Jogo> getAllJogoByName(String name){
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.executeQuery("SELECT * FROM Game WHERE name LIKE '%" + name + "%'");
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("plataform"),
                        rs.getString("launchdate"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public  List<Jogo> getAllJogoByGenre(String genre){
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.executeQuery("SELECT * FROM Game WHERE genre LIKE '%" + genre + "%'");
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("plataform"),
                        rs.getString("launchdate"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public void updateJogo(Jogo jogo) {
        try {
            Statement comandoSql = con.createStatement();
            comandoSql.executeUpdate("UPDATE Game SET "+
                    "name=\"" + jogo.name + "\"," +
                    "genre=\"" + jogo.genre + "\"," +
                    "plataform=\"" + jogo.plataform + "\"," +
                    "launchdate=\"" + jogo.launchdate + "\"" +
                    " WHERE id=" + jogo.id+";");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {

        try {
            Statement comandoSql = con.createStatement();
            comandoSql.executeUpdate(
                    "DELETE FROM Game WHERE id=" + id+";"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
