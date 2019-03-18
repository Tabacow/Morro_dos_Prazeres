public class ContaTestDrive {
    public static void main(String[] args) {
        Conta c1,c2;
        c1 = new Conta();
        c2 = new Conta();
        c1.numero = 123;
        c2.numero = 789;
        c1.transferirDinheiro(100,c2);
        c1.depositar(500.0);
        c1.VisualizarSaldo();
        c2.VisualizarSaldo();
    }
}
