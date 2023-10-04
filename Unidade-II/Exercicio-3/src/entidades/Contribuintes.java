package entidades;

public class Contribuintes {
    protected String nome;
    protected Double rendimento;
    protected double imposto;

    protected Contribuintes(String nome, Double rendimento){
        this.nome = nome;
        this.rendimento = rendimento;
    }

    public Double imposto(Double rendimento, Integer empregados){
        if(empregados>10) return (rendimento*14/100);
        else return (rendimento*16/100);
    }

    public Double imposto(Double rendimento, Double saude){
        if(rendimento>=20000) return ((rendimento/4)-(saude/2));
        else return ((rendimento*15/100)-(saude/2));
    }

    // getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getRendimento() {
        return rendimento;
    }
    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    @Override
    public String toString(){
        return (this.nome+": R$ "+String.format("%.2f", this.imposto));
    }
}
