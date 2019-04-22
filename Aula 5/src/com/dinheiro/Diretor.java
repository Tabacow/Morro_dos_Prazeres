package com.dinheiro;

public class Diretor extends Funcionario{

    public Diretor(String nome){

        super(nome);
    }

    @Override
    public double comissao(){
        return 0.6 * super.salario;
    }
}
