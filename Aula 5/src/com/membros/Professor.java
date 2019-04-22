package com.membros;

public class Professor extends CorpoDocente {
    private String disciplina;

    public Professor(String nome, int CPF, String disciplina);
    super(nome,CPF);
    this.disciplina = disciplina;
}
