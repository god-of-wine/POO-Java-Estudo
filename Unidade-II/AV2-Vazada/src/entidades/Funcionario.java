package entidades;

import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Funcionario {
    protected String nome;
    protected Integer id;
    protected Date admissao;
    protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Funcionario(String nome, Integer id, Date admissao) {
        this.nome = nome;
        this.id = id;
        this.admissao = admissao;
    }

    public Double calcularSalario(){
        return 0D;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }
}
