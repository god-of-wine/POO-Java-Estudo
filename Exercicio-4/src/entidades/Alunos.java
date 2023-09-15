package entidades;

public class Alunos{
    private String nome;
    private Float nota1, nota2, nota3;

    public Alunos(String nome, Float nota1, Float nota2, Float nota3){
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public float notafinal(){
        return (this.nota1+this.nota2+this.nota3);
    }

    public String toString(){
        if(notafinal()>=60) return ("Nome: "+this.nome+"\nNota final: "+String.format("%.2f", notafinal())+"\nAprovado\n");
        else return ("Nome: "+this.nome+"\nNota final: "+String.format("%.2f", notafinal())+"\nReprovado\nFaltaram "+String.format("%.2f", 60-notafinal())+"\n");
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Float getNota1() {
        return nota1;
    }
    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }
    public Float getNota2() {
        return nota2;
    }
    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }
    public Float getNota3() {
        return nota3;
    }
    public void setNota3(Float nota3) {
        this.nota3 = nota3;
    } 
}