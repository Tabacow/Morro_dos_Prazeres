package com.model;

import com.utilities.Constants;

public class User {

    public int id;
    public String nome, email, senha;

    public User(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = Constants.ID_NULO;
    }
}
