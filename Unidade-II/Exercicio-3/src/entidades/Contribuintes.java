package entidades;

public class Contribuintes {
    protected String nome;
    protected Double rendimento;

    protected Contribuintes(String nome, Double rendimento){
        this.nome = nome;
        this.rendimento = rendimento;
    }

    public Double imposto(){
        return 0D;
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

    @Override
    public String toString(){
        return (this.nome+": R$ "+String.format("%.2f", imposto()));
    }
}
