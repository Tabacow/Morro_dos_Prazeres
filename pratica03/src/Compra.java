public class Compra {
    int id;
    cliente client;
    produto produt;

    public Compra(int id, cliente client, produto produt){
        this.id = id;
        this.client = client;
        this.produt = produt;
    }
    public String getDetails(){
        return "ID: " + id + " nome: " + client.getNome() + " Produto: " + produt.getNome();
    }
}
