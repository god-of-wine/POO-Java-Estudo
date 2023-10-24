package entidades;

import java.util.Date;

public class Temporario extends Funcionario{
    private Double salarioHora;
    private Integer horas;

    public Temporario(String nome, Integer id, Date admissao, Double salarioHora, Integer horas) {
        super(nome, id, admissao);
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    public Double calcularSalario(){
        return horas*salarioHora;
    }

    public Double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(Double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString(){
        return ("Temporário - Nome = "+nome+" - Número de identificação = "+id+" - Data de Admissão = "+sdf.format(admissao)+" - Salário Mensal = "+String.format("%.2f", calcularSalario()));
    }
}
