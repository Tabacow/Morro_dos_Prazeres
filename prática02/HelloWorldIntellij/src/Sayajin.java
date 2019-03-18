public class Sayajin {
    String nome;
    double ki;
    boolean odio;
    int NivelDePoder;

    public void Treinar(){
        if (odio){
        ki = ki * 1.2;
            System.out.println("\n Depois do treino, o poder de luta de " + nome + " é: " + ki ); }
        else{
            ki = ki * 1.1;
            System.out.println("\n Depois do treino, o poder de luta de " + nome + " é: " + ki ); }
    }

    public String PegarCorDoCabelo(){
        String resultado;
        if(NivelDePoder == 0) resultado = "Preto";
        else if(NivelDePoder > 1 && NivelDePoder <= 3 ) resultado = "Amarelo";
        else resultado = "Azul";
        return resultado;
    }


}
