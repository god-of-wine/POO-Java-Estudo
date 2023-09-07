package entidades;

public class Funcionario {
    private int id;
    private String nome;
    private float salario;

    public Funcionario(int id, String nome, float salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setAumento(float percentual){
        this.salario+=(this.salario*percentual)/100;
    }

    public String toString(){
        return (id+", "+nome+", "+salario);
    }
}