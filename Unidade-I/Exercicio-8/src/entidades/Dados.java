package entidades;

public class Dados {

    private String nome, email;
    private int quarto;

    public Dados(){}
    
    public Dados(String nome, String email, int quarto){
        this.nome = nome;
        this.email = email;
        this.quarto = quarto;
    }

    public String toString(){
        return (quarto+": "+nome+", "+email);
    }
}