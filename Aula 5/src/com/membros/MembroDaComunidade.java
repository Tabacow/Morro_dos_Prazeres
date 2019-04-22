package com.membros;

public class MembroDaComunidade {
    protected String nome;
    protected int CPF;

    public MembroDaComunidade(String nome, int CPF){
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getDados(){
        return nome + '\t' + CPF;
    }

}
