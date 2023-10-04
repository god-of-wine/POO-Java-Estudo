package entidades;

public class ContribuinteJuridico extends Contribuintes {
    private Integer empregados;

    public ContribuinteJuridico(String nome, Double rendimento, Integer empregados){
        super(nome, rendimento);
        this.empregados = empregados;
        this.imposto = imposto(rendimento, empregados);
    }

    public Integer getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Integer empregados) {
        this.empregados = empregados;
    }

    @Override
    public String toString(){
        return (this.nome+": R$ "+String.format("%.2f", this.imposto));
    }
}
