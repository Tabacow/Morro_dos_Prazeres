import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTestDrive {
    public static void main(String[] args){
        List<Item> lista = new ArrayList<Item>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Informe ID e Nome: \n");
            int id = scanner.nextInt();
            String nome = scanner.next();
            lista.add(new Item(id, nome));
            System.out.println("Continuar?");
            if (scanner.nextInt() == 0) break;
        }
        System.out.println("tamanho da lista : " + lista.size());
        System.out.println("Itens da Lista: ");
        for (Item i: lista) {
            System.out.println("Item - " + i);
        }
    }

}
