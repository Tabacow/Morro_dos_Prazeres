import java.util.LinkedList;

public class LinkedListTestDrive {
    public static void main(String[] args) {
        LinkedList<Item> lista = new LinkedList<Item>();
        lista.add(new Item(1,"xboxta"));
        lista.add(0, new Item(2,"Switch"));
        lista.add(new Item(1,"ps4"));
        System.out.println("Tamanho: " + lista.size());
        for(Item i: lista){
            System.out.println("Item - " + i);
        }
    }
}
