package entidades;

public class Alunos {
    private String matricula, nome;
    private Float n1, n2, n3, media;

    public Alunos(String matricula, String nome, Float n1, Float n2, Float n3){
        this.matricula = matricula;
        this.nome = nome;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.media = (this.n1+this.n2+this.n3)/3;
    }

    public String toString(){
        return ("Matricula = "+this.matricula+" - Nome = "+this.nome+" - Media = "+String.format("%.1f", media));
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getN1() {
        return n1;
    }

    public void setN1(Float n1) {
        this.n1 = n1;
    }

    public Float getN2() {
        return n2;
    }

    public void setN2(Float n2) {
        this.n2 = n2;
    }

    public Float getN3() {
        return n3;
    }

    public void setN3(Float n3) {
        this.n3 = n3;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }
    

}
