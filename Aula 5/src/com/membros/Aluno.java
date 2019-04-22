package com.membros;

public class Aluno extends MembroDaComunidade {
    protected int RA;
    public Aluno(String nome, int CPF, int RA){
        super(nome);
        super(CPF);
        this.RA = RA;
    }
}
