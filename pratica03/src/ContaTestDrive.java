public class ContaTestDrive {
    public static void main(String[] args) {
        Conta c1; // declara um objeto do tipo conte
        Conta c2;
        Conta c3;
        c1 = new Conta(0 ,"All Might");
        c2 = new Conta(1,"Deku",500.0);
        c3 = new Conta(2,"Kazu",-800.0);
        c1.depositar(1000);
        c1.sacar(300);
        System.out.println("Conta:"+c2.getNome() + "Saldo:"+c2.getSaldo());
        System.out.println("Conta:"+c1.getNome() + "Saldo:"+c1.getSaldo());
        c1.depositar(1000);
        System.out.println("Saldo da conta: "+ c1.getSaldo());
        System.out.println("Conta:"+c3.getNome() + "Saldo:"+c3.getSaldo());







    }



