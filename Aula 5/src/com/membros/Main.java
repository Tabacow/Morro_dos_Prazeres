package com.membros;

public abstract class Main {
    Aluno a1 = new Aluno("Joao", 1234, 17564230);
    Graduado g1 = new Graduado("Caue", 1337, "Quimica");
    void mostrarDados(MembroDaComunidade mdc){
        System.out.println(mdc.getDados());
    }
    mostrarDados(a1);
    mostrarDados(g1);

}
