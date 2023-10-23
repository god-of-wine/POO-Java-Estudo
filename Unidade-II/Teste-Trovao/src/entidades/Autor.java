package entidades;

import java.util.Date;

import servicos.Pesquisavel;

public class Autor implements Pesquisavel{
    private String nome;
    private Date nascimento;
    
    public Autor(String nome, Date nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    public boolean pesquisar(String nome){
        return getNome().toLowerCase().contains(nome.toLowerCase());
    }
}
