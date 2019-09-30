package model;

public class Jogo {
    public String name, genre, plataform, launchdate;
    public int id;

    public Jogo(String name, String genre, String plataform, String launchdate, int id) {
        this.name = name;
        this.genre = genre;
        this.plataform = plataform;
        this.launchdate = launchdate;
        this.id = id;
    }

    public Jogo( ) {

    }

    @Override
    public String toString() {
        return "Jogo{" + "\n" + "nome = " + name + "\n" + "genero = " + genre + "\n" + "plataforma = " + plataform + "\n" + "data de lancamento = " + launchdate + "}";
    }
}
