public class cliente {

        private String nome;
        private int RA;
        private boolean funcionário;
        private boolean visitante;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public boolean isFuncionário() {
        return funcionário;
    }

    public void setFuncionário(boolean funcionário) {
        this.funcionário = funcionário;
    }

    public boolean isVisitante() {
        return visitante;
    }

    public void setVisitante(boolean visitante) {
        this.visitante = visitante;
    }
    public Cliente(String nome, boolean visitante){
        this.nome = nome;
        this.visitante = nome;
    }
    public Cliente(String nome, boolean funcionário){
        this.nome = nome;
        if(funcionário){
        this.funcionário = nome;}
        else visitante = true;

    }
    public Cliente(String nome, int RA){
        this.nome = nome;
        this.RA = RA;
    }
}




