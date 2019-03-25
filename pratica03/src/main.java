public class main {

    public static void main(String[] args){
        cliente client = new cliente("Scalco", 17000565);
        produto produt = new produto(0,"coxinha", 5.0);
        Compra c1 = new Compra(1, client, produt);
        System.out.println(c1.getDetails());
        Compra c2 = new Compra(2, client("Paulo"), produt("Rola de Borracha"));

    }
}
