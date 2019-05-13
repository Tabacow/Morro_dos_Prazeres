public class TesteMinhaExcecao {
    public static void main(String[] args) {
        String frase = "All Might é melhor que Endevour.";
        try{
            testarFrase(frase);
        } catch(SemLetraException e){
            System.out.println(e);
        }
        System.out.println(frase);
    }
    private static  void testarFrase(String frase)throws SemLetraException{
        if(!frase.toUpperCase().contains("B")){
            throw new SemLetraException();
        }
    }
}
