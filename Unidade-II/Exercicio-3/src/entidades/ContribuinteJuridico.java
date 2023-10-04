package entidades;

public class ContribuinteJuridico extends Contribuintes {
    private Integer empregados;

    public ContribuinteJuridico(String nome, Double rendimento, Integer empregados){
        super(nome, rendimento);
        this.empregados = empregados;
    }

    public Integer getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Integer empregados) {
        this.empregados = empregados;
    }

    @Override
    public String toString(){
        return (this.nome+": R$ "+String.format("%.2f", imposto()));
    }

    public Double imposto(){
        if(empregados>10) return (rendimento*14/100);
        else return (rendimento*16/100);
    }
}
