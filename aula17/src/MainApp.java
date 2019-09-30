import DAO.SingletonJogoDAO;
import model.Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private Scanner scan;
    private List<Jogo> jogos;
    public MainApp(){
        scan = new Scanner(System.in);
        jogos = new ArrayList<>();
    }
    private void menu(){
        System.out.println(
                        "1 - Ver" +
                        "\n" +
                        "2 - Criar" +
                        "\n" +
                        "3 - procura por nome" +
                        "\n" +
                        "4 - procura por genero" +
                        "\n" +
                        "5 - atualizar" +
                        "\n" +  "6 - deletar " + "\n" +
                         "0 - Sair" +
                        "\n" +

                        "\n");
    }
    public void mainLoop(){
        int op;
        while(true){
            menu();
            op = scan.nextInt();
            if(op == 0)
                break;
            else
                avaliarOp(op);
        }
    }
    private void avaliarOp(int op){
        Jogo jogo = new Jogo();
        switch(op){
            case 1: // Buscar todos
                jogos = SingletonJogoDAO.getInstance().getAllJogos();
                exibirJogos();
                break;
            case 2: // Criar
                System.out.println("Informe nome, genero, plataforma e ano de lancamento: ");
                jogo.name = scan.next();
                jogo.genre = scan.next();
                jogo.plataform = scan.next();
                jogo.launchdate = scan.next();
                SingletonJogoDAO.getInstance().insertJogo(jogo);
                break;
            case 3: // print by name
                System.out.println("Informe um nome: ");
                jogo.name = scan.next();
                jogos = SingletonJogoDAO.getInstance().getAllJogoByName(jogo.name);
                exibirJogos();
                break;
            case 4: // print by genre
                System.out.println("Informe um genero: ");
                jogo.genre = scan.next();
                jogos = SingletonJogoDAO.getInstance().getAllJogoByGenre(jogo.genre);
                exibirJogos();
                break;
            case 5: //update
                System.out.println("Informe um nome: ");
                jogo.name = scan.next();
                jogos = SingletonJogoDAO.getInstance().getAllJogoByName(jogo.name);
                if(jogos == null)
                    System.out.println("Jogo nao cadastrado.");
                else{
                    jogo = jogos.get(0);
                    System.out.println("Nome + ["+jogo.name+"]: ");
                    jogo.name = scan.next();
                    System.out.println("Genero + ["+jogo.genre+"]: ");
                    jogo.genre = scan.next();
                    System.out.println("Plataforma + ["+jogo.plataform+"]: ");
                    jogo.plataform = scan.next();
                    System.out.println("Lancamento + ["+jogo.launchdate+"]: ");
                    jogo.launchdate = scan.next();
                    SingletonJogoDAO.getInstance().updateJogo(jogo);
                }
                break;
            case 6:
                System.out.println("Informe o ID:");
                jogo.id = scan.nextInt();
                SingletonJogoDAO.getInstance().deleteById(jogo.id);
                break;
            case 0: // Sair
        }
    }
    private void exibirJogos(){
        for(Jogo jogo: jogos){
            System.out.println(jogo);
        }
    }
}
