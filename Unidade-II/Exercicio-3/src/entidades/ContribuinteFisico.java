package entidades;

public class ContribuinteFisico extends Contribuintes {
    private Double saude;

    public ContribuinteFisico(String nome, Double rendimento, Double saude){
        super(nome, rendimento);
        this.saude = saude;
    }

    public Double getSaude() {
        return saude;
    }

    public void setSaude(Double saude) {
        this.saude = saude;
    }

    @Override
    public String toString(){
        return (this.nome+": R$ "+String.format("%.2f", imposto()));
    }

    public Double imposto(){
        if(rendimento>=20000) return ((rendimento/4)-(saude/2));
        else return ((rendimento*15/100)-(saude/2));
    }
}
