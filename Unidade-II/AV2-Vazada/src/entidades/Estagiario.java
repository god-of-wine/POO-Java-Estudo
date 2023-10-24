package entidades;

import java.util.Date;

public class Estagiario extends Funcionario{
    private Double valorBolsa;
    private String universidade;

    public Estagiario(String nome, Integer id, Date admissao, Double valorBolsa, String universidade) {
        super(nome, id, admissao);
        this.valorBolsa = valorBolsa;
        this.universidade = universidade;
    }

    public Double calcularSalario(){
        return valorBolsa;
    }

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    @Override
    public String toString(){
        return ("Estagiário - Nome = "+nome+" - Número de identificação = "+id+" - Data de Admissão = "+sdf.format(admissao)+" - Salário Mensal = "+String.format("%.2f", calcularSalario()));
    }
}
