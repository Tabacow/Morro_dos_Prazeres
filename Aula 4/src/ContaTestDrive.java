public class ContaTestDrive {
    public static void main(String[] args){
        Conta c1 = new Conta("Midori",150);
        Conta c2 = new Conta("Stain", 0);
        System.out.println("Conta c1: "+ c1.pegaDados());
        System.out.println("Conta c2: "+ c2.pegaDados());
        System.out.println("Total: " + Conta.getTotalDeContas());
    }
}
