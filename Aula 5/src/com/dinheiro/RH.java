package com.dinheiro;

public class RH {
    private double totalComissao;

    public double getTotalComissao(){
        return  totalComissao;
    }

    public void adicionaComissao(Funcionario f){
        this.totalComissao += f.comissao();
    }
    public void adicionaComissao(Engenheiro e){
        this.totalComissao += e.comissao();
    }
}