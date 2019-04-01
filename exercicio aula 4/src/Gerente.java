public class Gerente {
    private String nome;
    private double salarioBase;
    private double comissao;


    public Gerente(String nome, double salarioBase ){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.comissao = 0.1;
    }
    public double getSalarioBase(){
        return salarioBase;
    }
    public String getNome(){
        return nome;
    }
    public double getComissao(double totalDeVendas){
        return this.comissao * totalDeVendas + 0.5 * this.salarioBase;
    }
    public double getSalarioDoMes(double totalDeVendas){
        return this.comissao * totalDeVendas + 0.5 * this.salarioBase + this.salarioBase;
    }
    public boolean aumentarSalarioBaseVendedor(Vendedor vendedor){
        if(vendedor.getGerente().equals(this.nome)){
            return true;
        }
        else{
            return false;
        }
    }
}

