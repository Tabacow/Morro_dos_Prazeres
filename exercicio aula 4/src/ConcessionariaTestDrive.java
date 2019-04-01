public class ConcessionariaTestDrive {
    public static void main(String[] args){
        Gerente g1 = new Gerente("Jão",6000);
        Vendedor v1 = new Vendedor("Carlão", g1.getNome(),1000);
        double totalVendasMes=10000;
        System.out.println("Nome Vendedor: " + v1.getNome() + '\n' + "Comissão: " + v1.getComissao(10000)+ '\n' + "Salário base: " + v1.getSalarioBase() + '\n' + "Salario do mês: " + v1.getSalarioDoMes(10000) + '\n' + "Gerente: " + v1.getGerente());
        if(g1.aumentarSalarioBaseVendedor(v1)){
            System.out.println("Pode dar aumento!");
        }else {
            System.out.println("Não pode dar aumento!");
        }
    }
}
