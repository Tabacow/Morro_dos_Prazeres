public class produto {
    private double preço;
    private String nome;
    private int id;

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public produto(int id, String nome, Double preço) {
        this.id = id;
        this.nome = nome;
        this.preço = preço
    }

}
