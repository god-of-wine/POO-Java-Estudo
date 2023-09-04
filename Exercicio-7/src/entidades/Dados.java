package entidades;

public class Dados {

    private String nome, email;
    private int quarto;
    private boolean ocupado=false;

    public Dados(){}
    
    public Dados(String nome, String email, int quarto){
        this.nome = nome;
        this.email = email;
        this.quarto = quarto;
        this.ocupado = true;
    }

    public boolean checkSlot(){
        if (ocupado == true) return true;
        else return false;
    }

    public void printData(){
        System.out.println(quarto+": "+nome+", "+email);
    }
    
}