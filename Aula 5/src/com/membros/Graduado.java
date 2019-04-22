package com.membros;

public class Graduado extends MembroDaComunidade {
    protected String curso;

    public Graduado(String nome, int CPF, String curso){

        super(nome);
        this.CPF = CPF;
        this.curso = curso;
}
