public class Main {

    public static void main(String[] args) {
        Sayajin sl;
        Sayajin s1 = new Sayajin();
        s1.nome = "Yamcha não é Sayajin";
        s1.ki = 1.;
        s1.odio = true;
        Sayajin s2 = new Sayajin();
        s2.nome = "Broa de milho";
        s2.ki = 1000000.;
        s2.odio = false;
        System.out.println("\n"+s1.nome);
        s1.Treinar();
        System.out.println("\n"+s2.nome);
        s2.Treinar();
    }
}
