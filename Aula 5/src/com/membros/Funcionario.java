package com.membros;

public class Funcionario extends Empregado {
    private String funcao;
    public Funcionario(String nome, int CPF, String funcao);
    super(nome,CPF);
    this.funcao = funcao;
}
