public class FuncionariosTestDrive {
    public static void main(String[] args){
        Vendedor v1 = new Vendedor("Midori","Leyla",1000);
        Vendedor v2 = new Vendedor("All Might", "Fry",10000);
        Gerente g1 = new Gerente("Leyla", 10000);
        System.out.println("Nome Vendedor: " + v1.getNome() + '\n' + "Comissão: " + v1.getComissao(15000)+ '\n' + "Salário base: " + v1.getSalarioBase() + '\n' + "Salario do mês: " + v1.getSalarioDoMes(40000) + '\n' + "Gerente: " + v1.getGerente());
        System.out.println("Salario Mês: " + g1.getSalarioDoMes(30000));
    }
}
