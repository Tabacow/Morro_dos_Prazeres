package com.dinheiro;

public class Main {
    public static void main(String[] args){
        Funcionario g1 = new Gerente("Genario", 12345);
        g1.setSalario(6000.00);
        Funcionario d1 = new Diretor("Celso");
        d1.setSalario(3333.33);
        Funcionario e1 = new Engenheiro("Rubens");
        e1.setSalario(5000.00);
        Funcionario v1 = new Vendedor("Sylmara");
        v1.setSalario(2000.00);
        RH rh = new RH();
        rh.adicionaComissao(g1);
        rh.adicionaComissao(e1);

        System.out.println("Gerente: " + g1.comissao());
        System.out.println("Diretor: " + d1.comissao());
        System.out.println("Engenheiro: " + e1.comissao());
        System.out.println("Vendedor: " + v1.comissao());
        System.out.println("RH: " + rh.getTotalComissao());
    }

}
