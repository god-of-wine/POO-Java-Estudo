package entidades;

public class Dados {

    private String nome, email;
    private int quarto;
    private boolean ocupado=false;
    
    public Dados(String nome, String email, int quarto){
        this.nome = nome;
        this.email = email;
        this.quarto = quarto;
        this.ocupado = true;
    }

    public String toString(){
        return quarto+": "+nome+", "+email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
}