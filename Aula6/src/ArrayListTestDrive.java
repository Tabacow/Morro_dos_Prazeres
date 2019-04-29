import java.util.List;
import java.util.ArrayList;

public class ArrayListTestDrive {
    public static void main(String[] args) {
        List<MinhaClasse> minhaLista;
        minhaLista = new ArrayList<MinhaClasse>();
        MinhaClasse minhaClasse = new MinhaClasse(10, "Tony");
        System.out.println(minhaClasse);
        minhaLista.add(minhaClasse);
        minhaLista.add(new MinhaClasse(2, "Steve"));
        minhaClasse = minhaLista.get(10);
        System.out.println(minhaClasse);
        for (MinhaClasse m : minhaLista) {
            System.out.println(m);
        }
    }
}

