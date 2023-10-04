package entidades;

public class ContribuinteFisico extends Contribuintes {
    private Double saude;

    public ContribuinteFisico(String nome, Double rendimento, Double saude){
        super(nome, rendimento);
        this.saude = saude;
        this.imposto = imposto(rendimento, saude);
    }

    public Double getSaude() {
        return saude;
    }

    public void setSaude(Double saude) {
        this.saude = saude;
    }

    @Override
    public String toString(){
        return (this.nome+": R$ "+String.format("%.2f", this.imposto));
    }
}
