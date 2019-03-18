public class Conta {
    int numero;
    String titular, cpf;
    float saldo;

    public void VisualizarSaldo(){
        System.out.println("Seu saldo é: " + saldo);
    }
    public void depositar(double ValorParaDepositar){
        saldo += ValorParaDepositar;

    }
    public void sacar(double ValorParaSacar){
        if (saldo >= -10)
        saldo -= ValorParaSacar;
    }
    public void transferirDinheiro(double valor, Conta beneficiado){
        sacar(valor);
        beneficiado.depositar(valor);

    }
}
