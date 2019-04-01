public class Funcionario {
    private String nome;
    private String gerente;
    private double salarioBase;
    private double comissao;

    public Funcionario(String nome,String gerente, double salarioBase ){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.comissao = 0.05;
        this.gerente = gerente;
    }
    public double getSalarioBase(){
        return this.salarioBase;
    }
    public String getNome(){
        return this.nome;
    }
    public double getComissao(double totalDeVendas){
        return this.comissao*totalDeVendas;
    }
    public double getSalarioDoMes(double totalDeVendas){
        return this.comissao*totalDeVendas + this.salarioBase;

    }
}

