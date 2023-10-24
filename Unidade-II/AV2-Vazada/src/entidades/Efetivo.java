package entidades;

import java.util.Date;

public class Efetivo extends Funcionario{
    private Double salarioMensal;

    public Efetivo(String nome, Integer id, Date admissao, Double salarioMensal) {
        super(nome, id, admissao);
        this.salarioMensal = salarioMensal;
    }

    public Double calcularSalario(){
        return salarioMensal;
    }

    public Double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(Double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public String toString(){
        return ("Efetivo - Nome = "+nome+" - Número de identificação = "+id+" - Data de Admissão = "+sdf.format(admissao)+" - Salário Mensal = "+String.format("%.2f", calcularSalario()));
    }
}
