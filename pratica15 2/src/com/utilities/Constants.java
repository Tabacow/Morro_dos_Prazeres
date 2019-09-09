package com.utilities;

public class Constants {

    public static final String URL_MY_DB = "jdbc:sqlite:MDouglas.db";
    public static final int ID_NULO = -1;
    public static final String TABELA_USERS = "users";
    public static final String SQL_INSERT_USER = "INSERT INTO " + TABELA_USERS + " VALUES (?,?,?,?)";
    public static final String ANSI_CLS = "\u001b[2J";
    public static final String ANSI_HOME = "\u001b[H";
    public static final String email_regex = "^[A-Za-z0-9+_.-]+@(.+)\\.(.+)$";


    public static final String getInsert(String table, int parametersCount){
        String sqlInsert = "INSERT INTO " + table + " VALUES (";

        for (int i = 0; i < parametersCount-1; i++){
            sqlInsert+= "?,";
        }
        sqlInsert += "?);";

        return sqlInsert;
    }
    public static final String getSelectAll(String table){
        return "SELECT * FROM " + table + ";";
    }
    public static final String getSelect(String table, String column, String search_parameter){
        return "SELECT * FROM " + table +
                " WHERE " + column + " = \"" + search_parameter + "\";";
    }
    public static final String getUpdate(String table, String search_param_column, String search_parameter, String nome_replace, String email_replace, String senha_replace){
        return "UPDATE " + table +
                " SET nome = \"" + nome_replace +"\", email = \"" + email_replace + "\", senha = \"" + senha_replace +
                "\" WHERE " + search_param_column + " = \"" + search_parameter + "\";";
    }
    public static final String getDelete(String table, String search_param_column, String search_parameter){
        return "DELETE FROM " + table +
                " WHERE " + search_param_column + " = \"" + search_parameter + "\";";
    }
    public static final void clearCMD(){
        System.out.println(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }
}